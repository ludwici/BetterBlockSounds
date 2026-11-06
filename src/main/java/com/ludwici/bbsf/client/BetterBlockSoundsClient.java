package com.ludwici.bbsf.client;

import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;

public final class BetterBlockSoundsClient {
    private BetterBlockSoundsClient() {
    }

    public static void register() {
        if (ModList.get().isLoaded("yet_another_config_lib_v3")) {
            ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory((minecraft, parent) -> SoundConfigScreen.create(parent)));
        }
    }
}
