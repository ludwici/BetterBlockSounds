package com.ludwici.bbsf.mixin;

import com.ludwici.bbsf.client.SoundTypeRowController;
import dev.isxander.yacl3.gui.AbstractWidget;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "dev.isxander.yacl3.gui.controllers.ListEntryWidget", remap = false)
public abstract class YaclListEntryWidgetMixin {
    @Shadow(remap = false)
    @Final
    private AbstractWidget entryWidget;

    @Inject(method = "extractRenderState", at = @At("HEAD"), remap = false, require = 0)
    private void bbsf$resizeSoundTypeEntry(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (entryWidget instanceof SoundTypeRowController.SoundTypeRowWidget) {
            AbstractWidget widget = (AbstractWidget) (Object) this;
            widget.setDimension(widget.getDimension().withHeight(entryWidget.getDimension().height()));
        }
    }
}
