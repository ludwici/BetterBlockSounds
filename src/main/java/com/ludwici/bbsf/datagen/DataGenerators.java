package com.ludwici.bbsf.datagen;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import static com.ludwici.bbsf.BetterBlockSoundsFork.MODID;

@EventBusSubscriber(modid = MODID)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        event.createProvider(ModBlockTagProvider::new);
    }
}