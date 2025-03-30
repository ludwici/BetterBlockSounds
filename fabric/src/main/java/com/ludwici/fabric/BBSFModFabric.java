package com.ludwici.fabric;

import net.fabricmc.api.ModInitializer;

import com.ludwici.bbsf.BBSFMod;

public final class BBSFModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BBSFMod.init();
    }
}
