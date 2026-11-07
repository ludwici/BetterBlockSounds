package com.ludwici.bbsf.client;

import dev.isxander.yacl3.api.Controller;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.utils.Dimension;
import dev.isxander.yacl3.gui.AbstractWidget;
import dev.isxander.yacl3.gui.YACLScreen;
import dev.isxander.yacl3.gui.controllers.string.StringController;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.input.CharacterEvent;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class SoundTypeRowController implements Controller<String> {
    private final Option<String> option;
    private final String originalId;
    private final StringController delegate;
    private final List<BlockPreviewCategory.BlockEntry> blocks;

    public SoundTypeRowController(Option<String> option, Map<String, List<BlockPreviewCategory.BlockEntry>> previews) {
        this.option = option;
        this.originalId = option.pendingValue();
        this.delegate = new StringController(option);
        this.blocks = previews.getOrDefault(originalId, List.of());
    }

    public String originalId() {
        return originalId;
    }

    @Override
    public Option<String> option() {
        return option;
    }

    @Override
    public Component formatValue() {
        return delegate.formatValue();
    }

    @Override
    public AbstractWidget provideWidget(YACLScreen screen, Dimension<Integer> dimension) {
        return new SoundTypeRowWidget(delegate.provideWidget(screen, dimension), dimension, blocks);
    }

    public static final class SoundTypeRowWidget extends AbstractWidget {
        private static final int HEADER = 20;
        private static final int ARROW = 22;
        private static final int ROW = 23;
        private static final int VISIBLE = 8;
        private static final int FOOTER = 20;

        private final AbstractWidget editor;
        private final List<BlockPreviewCategory.BlockEntry> blocks;
        private boolean expanded;
        private int scroll;

        private SoundTypeRowWidget(AbstractWidget editor, Dimension<Integer> dimension, List<BlockPreviewCategory.BlockEntry> blocks) {
            super(dimension);
            this.editor = editor;
            this.blocks = blocks;
            setDimension(dimension);
        }

        private int expandedHeight() {
            return HEADER + (expanded ? Math.max(1, Math.min(VISIBLE, blocks.size())) * ROW + (blocks.size() > VISIBLE ? FOOTER : 0) + 3 : 0);
        }

        @Override
        public void setDimension(Dimension<Integer> dimension) {
            Dimension<Integer> row = dimension.withHeight(expandedHeight());
            super.setDimension(row);
            editor.setDimension(Dimension.ofInt(row.x(), row.y(), Math.max(20, row.width() - ARROW), HEADER));
        }

        private int arrowX() {
            return getDimension().xLimit() - ARROW;
        }

        @Override
        public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
            Dimension<Integer> dim = getDimension();
            int x = dim.x();
            int y = dim.y();
            int width = dim.width();
            editor.extractRenderState(graphics, mouseX, mouseY, delta);

            boolean hovered = mouseX >= arrowX() && mouseX < dim.xLimit() && mouseY >= y && mouseY < y + HEADER;
            drawButtonRect(graphics, arrowX(), y, dim.xLimit(), y + HEADER, hovered, true);
            centeredText(graphics, expanded ? "▼" : "▶", arrowX() + ARROW / 2, y + 6, -1);

            if (!expanded) {
                return;
            }

            int listTop = y + HEADER + 2;

            if (blocks.isEmpty()) {
                graphics.text(textRenderer, Component.translatable("config.bbsf.type_preview.empty"), x + 5, listTop + 7, 0xFFAAAAAA, false);
            } else {
                int end = Math.min(blocks.size(), scroll + VISIBLE);

                for (int i = scroll; i < end; i++) {
                    BlockPreviewCategory.BlockEntry entry = blocks.get(i);
                    int itemY = listTop + (i - scroll) * ROW;

                    if (i % 2 == 0) {
                        graphics.fill(x, itemY, x + width, itemY + ROW, 0x29000000);
                    }

                    int textWidth = Math.max(16, width - 33);
                    String name = textRenderer.plainSubstrByWidth(entry.displayName(), textWidth);
                    String id = textRenderer.plainSubstrByWidth(entry.blockId(), textWidth);
                    graphics.text(textRenderer, Component.literal(name), x + 26, itemY + 1, 0xFFFFFFFF, false);
                    graphics.text(textRenderer, Component.literal(id), x + 26, itemY + 12, 0xFFAAAAAA, false);
                }
            }

            if (blocks.size() > VISIBLE) {
                int footerY = listTop + VISIBLE * ROW;
                drawButtonRect(graphics, x + 1, footerY, x + 23, footerY + 18, mouseX >= x + 1 && mouseX < x + 23 && mouseY >= footerY && mouseY < footerY + 18, scroll > 0);
                drawButtonRect(graphics, dim.xLimit() - 23, footerY, dim.xLimit() - 1, footerY + 18, mouseX >= dim.xLimit() - 23 && mouseX < dim.xLimit() - 1 && mouseY >= footerY && mouseY < footerY + 18, scroll + VISIBLE < blocks.size());
                centeredText(graphics, "◀", x + 12, footerY + 5, -1);
                centeredText(graphics, "▶", dim.xLimit() - 12, footerY + 5, -1);
                centeredText(graphics, (scroll + 1) + "–" + Math.min(scroll + VISIBLE, blocks.size()) + " / " + blocks.size(), x + width / 2, footerY + 5, -1);
            }
        }

        private void centeredText(GuiGraphicsExtractor graphics, String value, int x, int y, int color) {
            graphics.text(textRenderer, Component.literal(value), x - textRenderer.width(value) / 2, y, color, false);
        }

        @Override
        public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
            double mouseX = event.x();
            double mouseY = event.y();
            Dimension<Integer> dim = getDimension();

            if (event.isLeft() && mouseY >= dim.y() && mouseY < dim.y() + HEADER && mouseX >= arrowX() && mouseX < dim.xLimit()) {
                editor.unfocus();
                expanded = !expanded;
                scroll = 0;
                setDimension(dim);
                playDownSound();
                return true;
            }

            if (event.isLeft() && expanded && blocks.size() > VISIBLE) {
                int footerY = dim.y() + HEADER + 2 + VISIBLE * ROW;

                if (mouseY >= footerY && mouseY < footerY + FOOTER) {
                    if (mouseX >= dim.x() && mouseX < dim.x() + 24) {
                        scroll = Math.max(0, scroll - VISIBLE);
                        return true;
                    }

                    if (mouseX >= dim.xLimit() - 24 && mouseX < dim.xLimit()) {
                        scroll = Math.min(blocks.size() - VISIBLE, scroll + VISIBLE);
                        return true;
                    }
                }
            }

            return editor.mouseClicked(event, doubleClick);
        }

        @Override
        public boolean mouseScrolled(double mouseX, double mouseY, double horizontal, double vertical) {
            Dimension<Integer> dim = getDimension();

            if (expanded && blocks.size() > VISIBLE && dim.isPointInside((int) mouseX, (int) mouseY) && mouseY >= dim.y() + HEADER && vertical != 0) {
                scroll = Math.max(0, Math.min(blocks.size() - VISIBLE, scroll - (int) Math.signum(vertical)));
                return true;
            }

            return editor.mouseScrolled(mouseX, mouseY, horizontal, vertical);
        }

        @Override
        public boolean mouseReleased(MouseButtonEvent event) {
            return editor.mouseReleased(event);
        }

        @Override
        public boolean mouseDragged(MouseButtonEvent event, double dx, double dy) {
            return editor.mouseDragged(event, dx, dy);
        }

        @Override
        public boolean keyPressed(KeyEvent event) {
            return editor.keyPressed(event);
        }

        @Override
        public boolean keyReleased(KeyEvent event) {
            return editor.keyReleased(event);
        }

        @Override
        public boolean charTyped(CharacterEvent event) {
            return editor.charTyped(event);
        }

        @Override
        public boolean isFocused() {
            return editor.isFocused();
        }

        @Override
        public void setFocused(boolean focused) {
            editor.setFocused(focused);
        }

        @Override
        public void unfocus() {
            editor.unfocus();
        }

        @Override
        public boolean matchesSearch(String query) {
            String search = query.toLowerCase(Locale.ROOT);

            if (editor.matchesSearch(search)) {
                return true;
            }

            for (BlockPreviewCategory.BlockEntry block : blocks) {
                if (block.blockId().toLowerCase(Locale.ROOT).contains(search) || block.displayName().toLowerCase(Locale.ROOT).contains(search)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public NarrationPriority narrationPriority() {
            return editor.narrationPriority();
        }

        @Override
        public void updateNarration(NarrationElementOutput builder) {
            editor.updateNarration(builder);
        }
    }
}
