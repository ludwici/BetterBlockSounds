package com.ludwici.bbsf;

import com.ludwici.bbsf.client.BetterBlockSoundsClient;
import com.ludwici.bbsf.config.SoundConfigManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(BetterBlockSoundsFork.MODID)
public final class BetterBlockSoundsFork {
    public static final String MODID = "bbsf";

    public BetterBlockSoundsFork() {
        SoundConfigManager.load();

        if (FMLEnvironment.dist == Dist.CLIENT) {
            BetterBlockSoundsClient.register();
        }
    }
}
