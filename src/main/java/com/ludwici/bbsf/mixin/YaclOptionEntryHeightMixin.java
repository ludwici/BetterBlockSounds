package com.ludwici.bbsf.mixin;

import com.ludwici.bbsf.client.SoundTypeRowController;
import dev.isxander.yacl3.gui.AbstractWidget;
import net.minecraft.client.gui.components.events.ContainerEventHandler;
import net.minecraft.client.gui.components.events.GuiEventListener;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "dev.isxander.yacl3.gui.OptionListWidget$OptionEntry", remap = false)
public abstract class YaclOptionEntryHeightMixin {
    @Shadow(remap = false)
    @Final
    public AbstractWidget widget;

    @Inject(method = "getItemHeight", at = @At("HEAD"), remap = false, require = 0)
    private void bbsf$expandSoundTypeRow(CallbackInfoReturnable<Integer> cir) {
        if (widget instanceof ContainerEventHandler container) {
            for (GuiEventListener child : container.children()) {
                if (child instanceof SoundTypeRowController.SoundTypeRowWidget row) {
                    widget.setDimension(widget.getDimension().withHeight(row.getDimension().height()));
                    return;
                }
            }
        }
    }
}
