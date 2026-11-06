package com.ludwici.bbsf;

import com.ludwici.bbsf.config.SoundConfigManager;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(BetterBlockSoundsFork.MODID)
public class BetterBlockSoundsFork {
    public static final String MODID = "bbsf";

    public BetterBlockSoundsFork(IEventBus modEventBus, ModContainer container) {
        SoundConfigManager.load();
    }
}
