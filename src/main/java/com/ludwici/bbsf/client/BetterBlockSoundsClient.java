package com.ludwici.bbsf.client;

import com.ludwici.bbsf.config.SoundConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.network.chat.Component;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public final class BetterBlockSoundsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(literal("bbsf")
                .then(literal("reload").executes(context -> {
                    SoundConfigManager.load();
                    context.getSource().sendFeedback(Component.translatable("message.bbsf.reloaded"));
                    return 1;
                }))));
    }
}
