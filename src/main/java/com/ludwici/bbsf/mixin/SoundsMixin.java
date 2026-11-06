package com.ludwici.bbsf.mixin;

import com.ludwici.bbsf.config.SoundConfigManager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class SoundsMixin {
    @Shadow
    protected abstract Block asBlock();

    @Inject(method = "getSoundType", at = @At("TAIL"), cancellable = true)
    private void bbsf$getSoundType(CallbackInfoReturnable<SoundType> cir) {
        SoundType original = cir.getReturnValue();
        SoundType updated = SoundConfigManager.resolve(asBlock(), original);

        if (updated != original) {
            cir.setReturnValue(updated);
        }
    }
}
