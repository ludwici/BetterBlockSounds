package com.ludwici.bbsf.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ludwici.bbsf.config.SoundConfigData;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class BlockPreviewCategory {
    private BlockPreviewCategory() {
    }

    public static Map<String, List<BlockEntry>> collect(SoundConfigData data) {
        Map<String, List<BlockEntry>> groups = new LinkedHashMap<>();
        Map<String, Set<String>> bundledTags = new HashMap<>();

        for (Block block : BuiltInRegistries.BLOCK) {
            Item item = block.asItem();

            if (item == Items.AIR) {
                continue;
            }

            String blockId = BuiltInRegistries.BLOCK.getKey(block).toString();
            String soundType = null;
            String matchingRule = null;

            for (SoundConfigData.SoundRule rule : data.rules) {
                if (rule == null || rule.target == null || rule.soundType == null || !data.soundTypes.containsKey(rule.soundType)) {
                    continue;
                }

                if (matches(block, blockId, rule.target, bundledTags)) {
                    soundType = rule.soundType;
                    matchingRule = rule.target;
                }
            }

            if (soundType != null) {
                groups.computeIfAbsent(soundType, key -> new ArrayList<>()).add(new BlockEntry(blockId, matchingRule, item));
            }
        }

        for (List<BlockEntry> entries : groups.values()) {
            entries.sort(java.util.Comparator.comparing(entry -> new ItemStack(entry.item()).getHoverName().getString(), String.CASE_INSENSITIVE_ORDER));
        }

        return groups;
    }

    private static boolean matches(Block block, String blockId, String target, Map<String, Set<String>> bundledTags) {
        if (!target.startsWith("#")) {
            return target.equals(blockId);
        }

        String tagName = target.substring(1);
        Set<String> members = bundledTags.computeIfAbsent(tagName, key -> readTag(key, new HashSet<>()));

        if (members.contains(blockId)) {
            return true;
        }

        Identifier id = Identifier.tryParse(tagName);
        return id != null && block.defaultBlockState().is(TagKey.create(Registries.BLOCK, id));
    }

    private static Set<String> readTag(String tagName, Set<String> visited) {
        if (!visited.add(tagName)) {
            return Set.of();
        }

        Identifier location = Identifier.tryParse(tagName);

        if (location == null) {
            return Set.of();
        }

        String resourcePath = "/data/" + location.getNamespace() + "/tags/block/" + location.getPath() + ".json";
        Set<String> result = new HashSet<>();

        try (InputStream stream = BlockPreviewCategory.class.getResourceAsStream(resourcePath)) {
            if (stream != null) {
                JsonObject json = JsonParser.parseReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).getAsJsonObject();

                if (json.has("values")) {
                    for (JsonElement element : json.getAsJsonArray("values")) {
                        String value = element.isJsonPrimitive() ? element.getAsString() : element.getAsJsonObject().get("id").getAsString();

                        if (value.startsWith("#")) {
                            result.addAll(readTag(value.substring(1), visited));
                        } else {
                            result.add(value);
                        }
                    }
                }
            }
        } catch (RuntimeException | java.io.IOException ignored) {
        }

        visited.remove(tagName);
        return result;
    }

    public record BlockEntry(String blockId, String ruleTarget, Item item) {
    }
}
