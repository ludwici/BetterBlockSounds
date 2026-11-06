package com.ludwici.bbsf;

import com.ludwici.bbsf.config.SoundConfigManager;
import net.fabricmc.api.ModInitializer;

public final class BetterBlockSoundsFork implements ModInitializer {
    public static final String MODID = "bbsf";

    @Override
    public void onInitialize() {
        SoundConfigManager.load();
    }
}
