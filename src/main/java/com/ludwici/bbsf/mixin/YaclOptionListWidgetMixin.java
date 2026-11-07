package com.ludwici.bbsf.mixin;

import com.ludwici.bbsf.client.SoundTypeRowController;
import dev.isxander.yacl3.gui.AbstractWidget;
import dev.isxander.yacl3.gui.OptionListWidget;
import net.minecraft.client.gui.components.events.ContainerEventHandler;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.input.MouseButtonEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "dev.isxander.yacl3.gui.OptionListWidget", remap = false)
public abstract class YaclOptionListWidgetMixin {
    @Shadow(remap = false)
    private String searchQuery;

    @Inject(method = "mouseClicked", at = @At("RETURN"), remap = false, require = 0)
    private void bbsf$relayoutSoundTypeRows(MouseButtonEvent event, boolean doubleClick, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            return;
        }

        OptionListWidget list = (OptionListWidget) (Object) this;
        boolean resized = false;

        for (OptionListWidget.Entry entry : list.children()) {
            if (!(entry instanceof OptionListWidget.OptionEntry optionEntry)) {
                continue;
            }

            AbstractWidget wrapper = optionEntry.widget;

            if (!(wrapper instanceof ContainerEventHandler container)) {
                continue;
            }

            for (GuiEventListener child : container.children()) {
                if (child instanceof SoundTypeRowController.SoundTypeRowWidget row) {
                    int height = row.getDimension().height();

                    if (wrapper.getDimension().height() != height) {
                        wrapper.setDimension(wrapper.getDimension().withHeight(height));
                        ((YaclOptionEntryAccessor) (Object) optionEntry).bbsf$updateHeight();
                        resized = true;
                    }

                    break;
                }
            }
        }

        if (resized) {
            list.updateSearchQuery(searchQuery);
        }
    }
}
