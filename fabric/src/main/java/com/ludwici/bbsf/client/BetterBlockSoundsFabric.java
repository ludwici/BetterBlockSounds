package com.ludwici.bbsf.client;

import com.ludwici.bbsf.config.SoundConfigManager;
import net.fabricmc.api.ModInitializer;

public final class BetterBlockSoundsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SoundConfigManager.load();
    }
}
