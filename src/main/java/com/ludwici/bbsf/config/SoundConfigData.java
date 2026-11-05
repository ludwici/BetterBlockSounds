package com.ludwici.bbsf.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class SoundConfigData {
    @SerializedName("sound_types")
    public Map<String, SoundDefinition> soundTypes = new LinkedHashMap<>();
    public List<SoundRule> rules = new ArrayList<>();

    public static final class SoundDefinition {
        public String vanilla;
        public float volume = 1.0F;
        public float pitch = 1.0F;
        @SerializedName("break")
        public String breakSound;
        public String step;
        public String place;
        public String hit;
        public String fall;
    }

    public static final class SoundRule {
        public String target;
        @SerializedName("sound_type")
        public String soundType;

        public SoundRule() {
        }

        public SoundRule(String target, String soundType) {
            this.target = target;
            this.soundType = soundType;
        }
    }
}
