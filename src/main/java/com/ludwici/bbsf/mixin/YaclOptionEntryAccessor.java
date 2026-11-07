package com.ludwici.bbsf.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.gen.Invoker;

@Pseudo
@Mixin(targets = "dev.isxander.yacl3.gui.OptionListWidget$OptionEntry", remap = false)
public interface YaclOptionEntryAccessor {
    @Invoker(value = "updateHeight", remap = false)
    void bbsf$updateHeight();
}
