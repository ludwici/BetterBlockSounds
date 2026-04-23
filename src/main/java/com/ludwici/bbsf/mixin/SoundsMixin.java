package com.ludwici.bbsf.mixin;

import com.ludwici.bbsf.ModSoundTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public abstract class SoundsMixin {
    @Shadow
    protected abstract Block asBlock();

    @Inject(method = "getSoundType", at = @At("TAIL"), cancellable = true)
    private void getSoundGroupMixin(CallbackInfoReturnable<SoundType> cir){
        cir.setReturnValue(ModSoundTypes.assignSounds(this.asBlock(), cir));
    }
}
