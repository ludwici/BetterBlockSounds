package com.ludwici.bbsf.client;

import com.ludwici.bbsf.config.SoundConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public final class BetterBlockSoundsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(literal("bbsf")
                .then(literal("config").executes(context -> {
                    if (!FabricLoader.getInstance().isModLoaded("yet_another_config_lib_v3")) {
                        context.getSource().sendFeedback(Component.translatable("message.bbsf.requires_yacl"));
                        return 0;
                    }

                    Minecraft.getInstance().execute(() -> Minecraft.getInstance().setScreen(SoundConfigScreen.create(null)));
                    return 1;
                }))
                .then(literal("reload").executes(context -> {
                    SoundConfigManager.load();
                    context.getSource().sendFeedback(Component.translatable("message.bbsf.reloaded"));
                    return 1;
                }))));
    }
}
