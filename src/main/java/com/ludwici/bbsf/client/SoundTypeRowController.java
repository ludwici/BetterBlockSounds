package com.ludwici.bbsf.client;

import dev.isxander.yacl3.api.Controller;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.utils.Dimension;
import dev.isxander.yacl3.gui.AbstractWidget;
import dev.isxander.yacl3.gui.YACLScreen;
import dev.isxander.yacl3.gui.controllers.string.StringController;
import net.minecraft.network.chat.Component;

public final class SoundTypeRowController implements Controller<String> {
    private final Option<String> option;
    private final String originalId;
    private final StringController delegate;

    public SoundTypeRowController(Option<String> option) {
        this.option = option;
        this.originalId = option.pendingValue();
        this.delegate = new StringController(option);
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
        return delegate.provideWidget(screen, dimension);
    }
}
