package com.ludwici.bbsf.client;

import dev.isxander.yacl3.api.Controller;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.utils.Dimension;
import dev.isxander.yacl3.gui.AbstractWidget;
import dev.isxander.yacl3.gui.YACLScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.Locale;

public final class BlockPreviewController implements Controller<String> {
    private final Option<String> option;
    private final BlockPreviewCategory.BlockEntry block;

    public BlockPreviewController(Option<String> option, BlockPreviewCategory.BlockEntry block) {
        this.option = option;
        this.block = block;
    }

    @Override
    public Option<String> option() {
        return option;
    }

    @Override
    public Component formatValue() {
        return Component.literal(block.displayName());
    }

    @Override
    public AbstractWidget provideWidget(YACLScreen screen, Dimension<Integer> dimension) {
        return new PreviewWidget(dimension.withHeight(26), block);
    }

    private static final class PreviewWidget extends AbstractWidget {
        private final BlockPreviewCategory.BlockEntry block;

        private PreviewWidget(Dimension<Integer> dimension, BlockPreviewCategory.BlockEntry block) {
            super(dimension);
            this.block = block;
        }

        @Override
        public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
            Dimension<Integer> dim = getDimension();
            int x = dim.x() + 4;
            int y = dim.y() + 3;

            if (block.hasBoundComponents()) {
                graphics.fakeItem(new ItemStack(block.item()), x, y);
            } else {
                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, client.getModelManager().getBlockStateModelSet().getParticleMaterial(block.block().defaultBlockState()).sprite(), x, y, 16, 16);
            }

            int maxWidth = Math.max(30, dim.width() - 33);
            String name = textRenderer.plainSubstrByWidth(block.displayName(), maxWidth);
            String identifier = textRenderer.plainSubstrByWidth(block.blockId(), maxWidth);

            graphics.text(textRenderer, Component.literal(name), x + 22, y, 0xFFFFFFFF, false);
            graphics.text(textRenderer, Component.literal(identifier), x + 22, y + 12, 0xFFAAAAAA, false);
        }

        @Override
        public boolean matchesSearch(String query) {
            String lower = query.toLowerCase(Locale.ROOT);
            return block.blockId().toLowerCase(Locale.ROOT).contains(lower) || block.displayName().toLowerCase(Locale.ROOT).contains(lower);
        }
    }
}
