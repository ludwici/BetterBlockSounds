package com.ludwici.bbsf.mixin;

import com.ludwici.bbsf.config.SoundConfigManager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class SoundsMixin {
    @Inject(method = "getSoundType(Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/world/level/block/SoundType;", at = @At("RETURN"), cancellable = true)
    private void bbsf$getSoundType(CallbackInfoReturnable<SoundType> cir) {
        SoundType original = cir.getReturnValue();
        SoundType updated = SoundConfigManager.resolve((Block) (Object) this, original);

        if (updated != original) {
            cir.setReturnValue(updated);
        }
    }
}
