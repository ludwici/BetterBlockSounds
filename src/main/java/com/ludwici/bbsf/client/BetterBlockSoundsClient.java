package com.ludwici.bbsf.client;

import com.ludwici.bbsf.BetterBlockSoundsFork;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = BetterBlockSoundsFork.MODID, dist = Dist.CLIENT)
public final class BetterBlockSoundsClient {
    public BetterBlockSoundsClient(ModContainer container) {
        if (ModList.get().isLoaded("yet_another_config_lib_v3")) {
            container.registerExtensionPoint(IConfigScreenFactory.class, (ignored, parent) -> SoundConfigScreen.create(parent));
        }
    }
}
