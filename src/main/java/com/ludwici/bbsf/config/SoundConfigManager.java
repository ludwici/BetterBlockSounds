package com.ludwici.bbsf.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.ludwici.bbsf.BetterBlockSoundsFork;
import net.neoforged.fml.loading.FMLPaths;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class SoundConfigManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(BetterBlockSoundsFork.MODID);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final Path FILE = FMLPaths.CONFIGDIR.get().resolve("bbsf").resolve("sounds.json");
    private static volatile List<CompiledRule> compiledRules = List.of();
    private static SoundConfigData current;

    private SoundConfigManager() {
    }

    public static synchronized void load() {
        try {
            SoundConfigData data;

            if (Files.isRegularFile(FILE)) {
                try (Reader reader = Files.newBufferedReader(FILE, StandardCharsets.UTF_8)) {
                    data = GSON.fromJson(reader, SoundConfigData.class);
                }
            } else {
                data = readDefaults();
                expandVanilla(data);
                write(data);
            }

            validateStructure(data);
            expandVanilla(data);
            apply(data);
        } catch (Exception exception) {
            LOGGER.error("Unable to load {}. Keeping the last valid sound configuration.", FILE, exception);

            if (current == null) {
                try {
                    SoundConfigData defaults = readDefaults();
                    expandVanilla(defaults);
                    apply(defaults);
                } catch (Exception fallbackException) {
                    LOGGER.error("Unable to load bundled sound defaults.", fallbackException);
                }
            }
        }
    }

    public static synchronized SoundConfigData snapshot() {
        if (current == null) {
            return defaults();
        }

        return copy(current);
    }

    public static synchronized SoundConfigData defaults() {
        try {
            SoundConfigData data = readDefaults();
            expandVanilla(data);
            return data;
        } catch (Exception exception) {
            throw new IllegalStateException("Unable to read bundled sound defaults", exception);
        }
    }

    public static synchronized boolean save(SoundConfigData data) {
        try {
            validateStructure(data);
            expandVanilla(data);
            List<CompiledRule> next = compile(data);
            write(data);
            current = copy(data);
            compiledRules = next;
            return true;
        } catch (Exception exception) {
            LOGGER.error("Unable to save sound configuration to {}", FILE, exception);
            return false;
        }
    }

    public static SoundType resolve(Block block, SoundType original) {
        SoundType result = original;

        for (CompiledRule rule : compiledRules) {
            if (rule.tag != null && block.defaultBlockState().is(rule.tag)) {
                result = rule.soundType;
            } else if (rule.blockId != null && rule.blockId.equals(BuiltInRegistries.BLOCK.getKey(block))) {
                result = rule.soundType;
            }
        }

        return result;
    }

    private static void apply(SoundConfigData data) {
        List<CompiledRule> next = compile(data);
        current = copy(data);
        compiledRules = next;
        LOGGER.info("Loaded {} sound definitions and {} block sound rules.", data.soundTypes.size(), next.size());
    }

    private static List<CompiledRule> compile(SoundConfigData data) {
        Map<String, SoundType> sounds = new java.util.LinkedHashMap<>();

        for (Map.Entry<String, SoundConfigData.SoundDefinition> entry : data.soundTypes.entrySet()) {
            try {
                sounds.put(entry.getKey(), createSoundType(entry.getValue()));
            } catch (RuntimeException exception) {
                LOGGER.warn("Skipping invalid sound type '{}': {}", entry.getKey(), exception.getMessage());
            }
        }

        List<CompiledRule> rules = new ArrayList<>();

        for (SoundConfigData.SoundRule rule : data.rules) {
            if (rule == null || rule.target == null || rule.soundType == null) {
                LOGGER.warn("Skipping incomplete block sound rule.");
                continue;
            }

            SoundType type = sounds.get(rule.soundType);

            if (type == null) {
                LOGGER.warn("Unknown sound type '{}' in rule '{}'.", rule.soundType, rule.target);
                continue;
            }

            boolean tag = rule.target.startsWith("#");
            String target = tag ? rule.target.substring(1) : rule.target;
            Identifier id = Identifier.tryParse(target);

            if (id == null) {
                LOGGER.warn("Invalid block or tag ID '{}'.", rule.target);
                continue;
            }

            if (tag) {
                rules.add(new CompiledRule(TagKey.create(Registries.BLOCK, id), null, type));
            } else {
                rules.add(new CompiledRule(null, id, type));
            }
        }

        return List.copyOf(rules);
    }

    private static SoundType createSoundType(SoundConfigData.SoundDefinition sound) {
        if (sound == null || !Float.isFinite(sound.volume) || !Float.isFinite(sound.pitch) || sound.volume < 0.0F || sound.pitch <= 0.0F) {
            throw new IllegalArgumentException("Volume and pitch must be finite, volume >= 0 and pitch > 0");
        }

        return new SoundType(sound.volume, sound.pitch, event(sound.breakSound), event(sound.step), event(sound.place), event(sound.hit), event(sound.fall));
    }

    private static SoundEvent event(String name) {
        Identifier id = name == null ? null : Identifier.tryParse(name);

        if (id == null) {
            throw new IllegalArgumentException("Invalid sound event ID: " + name);
        }

        return BuiltInRegistries.SOUND_EVENT.getOptional(id).orElseThrow(() -> new IllegalArgumentException("Unknown sound event: " + id));
    }

    private static void expandVanilla(SoundConfigData data) {
        validateStructure(data);

        for (Map.Entry<String, SoundConfigData.SoundDefinition> entry : data.soundTypes.entrySet()) {
            SoundConfigData.SoundDefinition definition = entry.getValue();

            if (definition != null && definition.vanilla != null) {
                SoundType vanilla = vanillaSoundType(definition.vanilla);

                if (vanilla == null) {
                    throw new IllegalArgumentException("Unknown vanilla SoundType: " + definition.vanilla);
                }

                entry.setValue(fromVanilla(vanilla));
            }
        }
    }

    private static SoundConfigData.SoundDefinition fromVanilla(SoundType sound) {
        SoundConfigData.SoundDefinition definition = new SoundConfigData.SoundDefinition();
        definition.volume = sound.getVolume();
        definition.pitch = sound.getPitch();
        definition.breakSound = BuiltInRegistries.SOUND_EVENT.getKey(sound.getBreakSound()).toString();
        definition.step = BuiltInRegistries.SOUND_EVENT.getKey(sound.getStepSound()).toString();
        definition.place = BuiltInRegistries.SOUND_EVENT.getKey(sound.getPlaceSound()).toString();
        definition.hit = BuiltInRegistries.SOUND_EVENT.getKey(sound.getHitSound()).toString();
        definition.fall = BuiltInRegistries.SOUND_EVENT.getKey(sound.getFallSound()).toString();
        return definition;
    }

    private static SoundType vanillaSoundType(String id) {
        return switch (id) {
            case "HANGING_ROOTS" -> SoundType.HANGING_ROOTS;
            case "NETHER_GOLD_ORE" -> SoundType.NETHER_GOLD_ORE;
            case "AZALEA_LEAVES" -> SoundType.AZALEA_LEAVES;
            case "CHERRY_SAPLING" -> SoundType.CHERRY_SAPLING;
            case "BONE_BLOCK" -> SoundType.BONE_BLOCK;
            case "WET_GRASS" -> SoundType.WET_GRASS;
            case "SHROOMLIGHT" -> SoundType.SHROOMLIGHT;
            case "NETHERRACK" -> SoundType.NETHERRACK;
            case "BASALT" -> SoundType.BASALT;
            case "TUFF" -> SoundType.TUFF;
            case "VINE" -> SoundType.VINE;
            case "NETHERITE_BLOCK" -> SoundType.NETHERITE_BLOCK;
            case "AMETHYST" -> SoundType.AMETHYST;
            case "CORAL_BLOCK" -> SoundType.CORAL_BLOCK;
            case "ROOTED_DIRT" -> SoundType.ROOTED_DIRT;
            case "WART_BLOCK" -> SoundType.WART_BLOCK;
            case "STEM" -> SoundType.STEM;
            case "CROP" -> SoundType.CROP;
            default -> null;
        };
    }

    private static SoundConfigData readDefaults() throws java.io.IOException {
        try (InputStream stream = SoundConfigManager.class.getResourceAsStream("/assets/bbsf/default_sounds.json")) {
            if (stream == null) {
                throw new java.io.IOException("Bundled default_sounds.json is missing");
            }

            try (Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
                SoundConfigData data = GSON.fromJson(reader, SoundConfigData.class);
                validateStructure(data);
                return data;
            }
        }
    }

    private static SoundConfigData copy(SoundConfigData data) {
        return GSON.fromJson(GSON.toJson(data), SoundConfigData.class);
    }

    private static void validateStructure(SoundConfigData data) {
        if (data == null || data.soundTypes == null || data.rules == null) {
            throw new JsonParseException("Expected sound_types object and rules array");
        }
    }

    private static void write(SoundConfigData data) throws java.io.IOException {
        Files.createDirectories(FILE.getParent());
        Path temporary = Files.createTempFile(FILE.getParent(), "sounds-", ".tmp");

        try {
            Files.writeString(temporary, GSON.toJson(data) + System.lineSeparator(), StandardCharsets.UTF_8);

            try {
                Files.move(temporary, FILE, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException exception) {
                Files.move(temporary, FILE, StandardCopyOption.REPLACE_EXISTING);
            }
        } finally {
            Files.deleteIfExists(temporary);
        }
    }

    private record CompiledRule(TagKey<Block> tag, Identifier blockId, SoundType soundType) {
    }
}
