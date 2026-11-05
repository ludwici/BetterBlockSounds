package com.ludwici.bbsf;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(BetterBlockSoundsFork.MODID)
public class BetterBlockSoundsFork {
    public static final String MODID = "bbsf";

    public BetterBlockSoundsFork(IEventBus modEventBus, ModContainer modContainer) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
