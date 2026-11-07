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

    @Inject(method = "mouseClicked", at = @At("HEAD"), remap = false, cancellable = true, require = 0)
    private void bbsf$handleSoundTypePreviewClick(MouseButtonEvent event, boolean doubleClick, CallbackInfoReturnable<Boolean> cir) {
        if (!event.isLeft()) {
            return;
        }

        OptionListWidget list = (OptionListWidget) (Object) this;

        if (!list.isMouseOver(event.x(), event.y())) {
            return;
        }

        for (OptionListWidget.Entry entry : list.children()) {
            if (!(entry instanceof OptionListWidget.OptionEntry optionEntry) || !entry.isViewable()) {
                continue;
            }

            AbstractWidget wrapper = optionEntry.widget;

            if (!(wrapper instanceof ContainerEventHandler container)) {
                continue;
            }

            for (GuiEventListener child : container.children()) {
                if (!(child instanceof SoundTypeRowController.SoundTypeRowWidget row) || !row.isExpandButtonHovered(event.x(), event.y())) {
                    continue;
                }

                if (row.mouseClicked(event, doubleClick)) {
                    wrapper.setDimension(wrapper.getDimension().withHeight(row.getDimension().height()));
                    ((YaclOptionEntryAccessor) (Object) optionEntry).bbsf$updateHeight();
                    list.updateSearchQuery(searchQuery);
                    cir.setReturnValue(true);
                }

                return;
            }
        }
    }
}
