package com.ludwici.bbsf.client;

import com.ludwici.bbsf.config.SoundConfigData;
import com.ludwici.bbsf.config.SoundConfigManager;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.ListOption;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.OptionGroup;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.FloatFieldControllerBuilder;
import dev.isxander.yacl3.api.controller.StringControllerBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class SoundConfigScreen {
    private SoundConfigScreen() {
    }

    public static Screen create(Screen parent) {
        SoundConfigData data = SoundConfigManager.snapshot();
        SoundConfigData defaults = SoundConfigManager.defaults();
        RuleEditor ruleEditor = new RuleEditor(toLines(data.rules));
        TypeEditor typeEditor = new TypeEditor(new ArrayList<>(data.soundTypes.keySet()));

        ConfigCategory rules = ConfigCategory.createBuilder()
                .name(Component.translatable("config.bbsf.rules"))
                .tooltip(Component.translatable("config.bbsf.rules.description"))
                .group(ListOption.<String>createBuilder()
                        .name(Component.translatable("config.bbsf.rule_list"))
                        .description(OptionDescription.of(Component.translatable("config.bbsf.rule_list.description")))
                        .binding(toLines(defaults.rules), () -> ruleEditor.lines, value -> ruleEditor.lines = new ArrayList<>(value))
                        .controller(StringControllerBuilder::create)
                        .initial("#minecraft:logs=vanilla_stem")
                        .build())
                .build();

        YetAnotherConfigLib.Builder builder = YetAnotherConfigLib.createBuilder()
                .title(Component.translatable("config.bbsf.title"))
                .category(rules)
                .category(ConfigCategory.createBuilder()
                        .name(Component.translatable("config.bbsf.manage_types"))
                        .group(ListOption.<String>createBuilder()
                                .name(Component.translatable("config.bbsf.type_list"))
                                .description(OptionDescription.of(Component.translatable("config.bbsf.type_list.description")))
                                .binding(new ArrayList<>(defaults.soundTypes.keySet()), () -> typeEditor.names, value -> typeEditor.names = new ArrayList<>(value))
                                .controller(StringControllerBuilder::create)
                                .initial("custom_sound")
                                .build())
                        .build())
                .save(() -> {
                    data.rules = parseLines(ruleEditor.lines);
                    data.soundTypes = collectTypes(data.soundTypes, typeEditor.names);
                    SoundConfigManager.save(data);
                });

        ConfigCategory.Builder typesCategory = null;
        int index = 0;

        for (Map.Entry<String, SoundConfigData.SoundDefinition> entry : data.soundTypes.entrySet()) {
            if (index % 8 == 0) {
                if (typesCategory != null) {
                    builder.category(typesCategory.build());
                }

                typesCategory = ConfigCategory.createBuilder().name(Component.translatable("config.bbsf.types", index / 8 + 1));
            }

            SoundConfigData.SoundDefinition definition = entry.getValue();
            SoundConfigData.SoundDefinition original = defaults.soundTypes.get(entry.getKey());

            if (original == null) {
                original = definition;
            }

            OptionGroup group = createTypeGroup(entry.getKey(), definition, original);
            typesCategory.group(group);
            index++;
        }

        if (typesCategory != null) {
            builder.category(typesCategory.build());
        }

        return builder.build().generateScreen(parent);
    }

    private static OptionGroup createTypeGroup(String id, SoundConfigData.SoundDefinition definition, SoundConfigData.SoundDefinition defaults) {
        return OptionGroup.createBuilder()
                .name(Component.literal(id))
                .option(floatOption("config.bbsf.volume", defaults.volume, () -> definition.volume, value -> definition.volume = value))
                .option(floatOption("config.bbsf.pitch", defaults.pitch, () -> definition.pitch, value -> definition.pitch = value))
                .option(stringOption("config.bbsf.break", defaults.breakSound, () -> definition.breakSound, value -> definition.breakSound = value))
                .option(stringOption("config.bbsf.step", defaults.step, () -> definition.step, value -> definition.step = value))
                .option(stringOption("config.bbsf.place", defaults.place, () -> definition.place, value -> definition.place = value))
                .option(stringOption("config.bbsf.hit", defaults.hit, () -> definition.hit, value -> definition.hit = value))
                .option(stringOption("config.bbsf.fall", defaults.fall, () -> definition.fall, value -> definition.fall = value))
                .build();
    }

    private static Option<Float> floatOption(String key, float defaultValue, Supplier<Float> getter, Consumer<Float> setter) {
        return Option.<Float>createBuilder()
                .name(Component.translatable(key))
                .binding(defaultValue, getter, setter)
                .controller(FloatFieldControllerBuilder::create)
                .build();
    }

    private static Option<String> stringOption(String key, String defaultValue, Supplier<String> getter, Consumer<String> setter) {
        return Option.<String>createBuilder()
                .name(Component.translatable(key))
                .binding(safe(defaultValue), () -> safe(getter.get()), setter)
                .controller(StringControllerBuilder::create)
                .build();
    }

    private static String safe(String value) {
        return value == null ? "" : value;
    }

    private static List<String> toLines(List<SoundConfigData.SoundRule> rules) {
        List<String> lines = new ArrayList<>();

        for (SoundConfigData.SoundRule rule : rules) {
            if (rule != null && rule.target != null && rule.soundType != null) {
                lines.add(rule.target + "=" + rule.soundType);
            }
        }

        return lines;
    }

    private static List<SoundConfigData.SoundRule> parseLines(List<String> lines) {
        List<SoundConfigData.SoundRule> rules = new ArrayList<>();

        for (String line : lines) {
            int separator = line.lastIndexOf('=');

            if (separator > 0 && separator < line.length() - 1) {
                rules.add(new SoundConfigData.SoundRule(line.substring(0, separator).trim(), line.substring(separator + 1).trim()));
            }
        }

        return rules;
    }

    private static Map<String, SoundConfigData.SoundDefinition> collectTypes(Map<String, SoundConfigData.SoundDefinition> current, List<String> names) {
        Map<String, SoundConfigData.SoundDefinition> next = new java.util.LinkedHashMap<>();
        SoundConfigData.SoundDefinition template = current.get("stone_ore");

        if (template == null && !current.isEmpty()) {
            template = current.values().iterator().next();
        }

        for (String raw : names) {
            String id = raw.trim();

            if (!id.isEmpty() && !next.containsKey(id)) {
                SoundConfigData.SoundDefinition definition = current.get(id);

                if (definition == null && template != null) {
                    definition = copyDefinition(template);
                }

                if (definition != null) {
                    next.put(id, definition);
                }
            }
        }

        return next;
    }

    private static SoundConfigData.SoundDefinition copyDefinition(SoundConfigData.SoundDefinition source) {
        SoundConfigData.SoundDefinition result = new SoundConfigData.SoundDefinition();
        result.volume = source.volume;
        result.pitch = source.pitch;
        result.breakSound = source.breakSound;
        result.step = source.step;
        result.place = source.place;
        result.hit = source.hit;
        result.fall = source.fall;
        return result;
    }

    private static final class TypeEditor {
        private List<String> names;

        private TypeEditor(List<String> names) {
            this.names = names;
        }
    }

    private static final class RuleEditor {
        private List<String> lines;

        private RuleEditor(List<String> lines) {
            this.lines = lines;
        }
    }
}
