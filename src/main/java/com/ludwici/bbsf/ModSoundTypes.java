package com.ludwici.bbsf;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


public class ModSoundTypes {

    private static final DeferredSoundType STONE_ORE = registerSound(1.0F, 0.9F, SoundEvents.NETHER_ORE_BREAK, SoundEvents.NETHER_ORE_STEP, SoundEvents.NETHER_ORE_PLACE, SoundEvents.NETHER_ORE_HIT, SoundEvents.NETHER_ORE_FALL);
    private static final DeferredSoundType OBSIDIAN = registerSound(1.0F, 0.7F, SoundEvents.DEEPSLATE_BREAK, SoundEvents.DEEPSLATE_STEP, SoundEvents.DEEPSLATE_PLACE, SoundEvents.DEEPSLATE_HIT, SoundEvents.DEEPSLATE_FALL);
    private static final DeferredSoundType BLACKSTONE = registerSound(1.0F, 0.9F, SoundEvents.DEEPSLATE_BREAK, SoundEvents.DEEPSLATE_STEP, SoundEvents.DEEPSLATE_PLACE, SoundEvents.DEEPSLATE_HIT, SoundEvents.DEEPSLATE_FALL);
    private static final DeferredSoundType POLISHED_BLACKSTONE = registerSound(1.0F, 0.9F, SoundEvents.POLISHED_DEEPSLATE_BREAK, SoundEvents.POLISHED_DEEPSLATE_STEP, SoundEvents.POLISHED_DEEPSLATE_PLACE, SoundEvents.POLISHED_DEEPSLATE_HIT, SoundEvents.POLISHED_DEEPSLATE_FALL);
    private static final DeferredSoundType POLISHED_BLACKSTONE_BRICKS = registerSound(1.0F, 0.9F, SoundEvents.DEEPSLATE_BRICKS_BREAK, SoundEvents.DEEPSLATE_BRICKS_STEP, SoundEvents.DEEPSLATE_BRICKS_PLACE, SoundEvents.DEEPSLATE_BRICKS_HIT, SoundEvents.DEEPSLATE_BRICKS_FALL);
    private static final DeferredSoundType END_STONE_BRICKS = registerSound(1.0F, 0.8F, SoundEvents.DEEPSLATE_TILES_BREAK, SoundEvents.DEEPSLATE_TILES_STEP, SoundEvents.DEEPSLATE_TILES_PLACE, SoundEvents.DEEPSLATE_TILES_HIT, SoundEvents.DEEPSLATE_TILES_FALL);
    private static final DeferredSoundType QUARTZ = registerSound(1.0F, 0.9F, SoundEvents.CALCITE_BREAK, SoundEvents.CALCITE_STEP, SoundEvents.CALCITE_PLACE, SoundEvents.CALCITE_HIT, SoundEvents.CALCITE_FALL);
    private static final DeferredSoundType QUARTZ_BRICKS = registerSound(1.0F, 1.1F, SoundEvents.CALCITE_BREAK, SoundEvents.CALCITE_STEP, SoundEvents.CALCITE_PLACE, SoundEvents.CALCITE_HIT, SoundEvents.CALCITE_FALL);
    private static final DeferredSoundType GRASS_BLOCK = registerSound(1.0F, 1.0F, SoundEvents.ROOTED_DIRT_BREAK, SoundEvents.GRASS_STEP, SoundEvents.ROOTED_DIRT_BREAK, SoundEvents.ROOTED_DIRT_BREAK, SoundEvents.GRASS_FALL);
    private static final DeferredSoundType TERRACOTTA = registerSound(1.0F, 0.6F, SoundEvents.CALCITE_BREAK, SoundEvents.CALCITE_STEP, SoundEvents.CALCITE_PLACE, SoundEvents.CALCITE_HIT, SoundEvents.CALCITE_FALL);
    private static final DeferredSoundType STONE_BRICK = registerSound(1.0F, 0.6F, SoundEvents.DEEPSLATE_TILES_BREAK, SoundEvents.DEEPSLATE_TILES_STEP, SoundEvents.DEEPSLATE_TILES_PLACE, SoundEvents.DEEPSLATE_TILES_HIT, SoundEvents.DEEPSLATE_TILES_FALL);
    private static final DeferredSoundType CLAY_BRICK = registerSound(1.0F, 1.3F, SoundEvents.NETHER_BRICKS_BREAK, SoundEvents.NETHER_BRICKS_STEP, SoundEvents.NETHER_BRICKS_PLACE, SoundEvents.NETHER_BRICKS_HIT, SoundEvents.NETHER_BRICKS_FALL);
    private static final DeferredSoundType METAL = registerSound(1.0F, 0.6F, SoundEvents.COPPER_BREAK, SoundEvents.COPPER_STEP, SoundEvents.COPPER_PLACE, SoundEvents.COPPER_HIT, SoundEvents.COPPER_FALL);
    private static final DeferredSoundType LILY_PAD = registerSound(1.0F, 1.0F, SoundEvents.BIG_DRIPLEAF_BREAK, SoundEvents.BIG_DRIPLEAF_STEP, SoundEvents.LILY_PAD_PLACE, SoundEvents.BIG_DRIPLEAF_HIT, SoundEvents.BIG_DRIPLEAF_FALL);
    private static final DeferredSoundType SMALL_OBJECT = registerSound(1.0F, 0.8F, SoundEvents.CANDLE_BREAK, SoundEvents.CANDLE_STEP, SoundEvents.CANDLE_PLACE, SoundEvents.CANDLE_HIT, SoundEvents.CANDLE_FALL);
    private static final DeferredSoundType BELL = registerSound(1.0F, 1.0F, SoundEvents.BELL_BLOCK, SoundEvents.METAL_STEP, SoundEvents.BELL_BLOCK, SoundEvents.COPPER_HIT, SoundEvents.BELL_RESONATE);

    private static DeferredSoundType registerSound(float volumeIn, float pitchIn, SoundEvent breakSoundIn, SoundEvent stepSoundIn, SoundEvent placeSoundIn, SoundEvent hitSoundIn, SoundEvent fallSoundIn) {
        return new DeferredSoundType(volumeIn, pitchIn, () -> breakSoundIn, () -> stepSoundIn, () -> placeSoundIn, () -> hitSoundIn, () -> fallSoundIn);
    }

    public static SoundType assignSounds(Block block, CallbackInfoReturnable<SoundType> cir) {
        SoundType sound = null;

        if (block.defaultBlockState().is(BlockTags.SMALL_FLOWERS)) sound = SoundType.HANGING_ROOTS;
        if (block.defaultBlockState().is(ModTags.STONE_ORES)) sound = STONE_ORE;
        if (block.defaultBlockState().is(ModTags.RAW_ORES)) sound = SoundType.NETHER_GOLD_ORE;
        if (block.defaultBlockState().is(ModTags.LEAVES)) sound = SoundType.AZALEA_LEAVES;
        if (block.defaultBlockState().is(ModTags.SAPLINGS)) sound = SoundType.CHERRY_SAPLING;
        if (block.defaultBlockState().is(ModTags.LILIES)) sound = LILY_PAD;
        if (block.defaultBlockState().is(ModTags.BELLS)) sound = BELL;
        if (block.defaultBlockState().is(ModTags.BONES)) sound = SoundType.BONE_BLOCK;
        if (block.defaultBlockState().is(ModTags.WET)) sound = SoundType.WET_GRASS;
        if (block.defaultBlockState().is(ModTags.SHROOMS)) sound = SoundType.SHROOMLIGHT;
        if (block.defaultBlockState().is(ModTags.NETHERRACKS)) sound = SoundType.NETHERRACK;
        if (block.defaultBlockState().is(ModTags.BLACKSTONES)) sound = BLACKSTONE;
        if (block.defaultBlockState().is(ModTags.POLISHED_BLACKSTONES)) sound = POLISHED_BLACKSTONE;
        if (block.defaultBlockState().is(ModTags.POLISHED_BLACKSTONES_BRICKS)) sound = POLISHED_BLACKSTONE_BRICKS;
        if (block.defaultBlockState().is(ModTags.BASALT)) sound = SoundType.BASALT;
        if (block.defaultBlockState().is(ModTags.TUFF)) sound = SoundType.TUFF;
        if (block.defaultBlockState().is(ModTags.END_STONE_BRICKS)) sound = END_STONE_BRICKS;
        if (block.defaultBlockState().is(ModTags.OBSIDIAN)) sound = OBSIDIAN;
        if (block.defaultBlockState().is(ModTags.QUARTZ)) sound = QUARTZ;
        if (block.defaultBlockState().is(ModTags.QUARTZ_BRICKS)) sound = QUARTZ_BRICKS;
        if (block.defaultBlockState().is(ModTags.GRASS_BLOCKS)) sound = GRASS_BLOCK;
        if (block.defaultBlockState().is(ModTags.HANGING_ROOTS)) sound = SoundType.HANGING_ROOTS;
        if (block.defaultBlockState().is(ModTags.VINE)) sound = SoundType.VINE;
        if (block.defaultBlockState().is(ModTags.TERRACOTTA)) sound = TERRACOTTA;
        if (block.defaultBlockState().is(ModTags.STONE_BRICKS)) sound = STONE_BRICK;
        if (block.defaultBlockState().is(ModTags.CLAY_BRICKS)) sound = CLAY_BRICK;
        if (block.defaultBlockState().is(ModTags.NETHERITE_BLOCKS)) sound = SoundType.NETHERITE_BLOCK;
        if (block.defaultBlockState().is(ModTags.CRYSTALLS)) sound = SoundType.AMETHYST;
        if (block.defaultBlockState().is(ModTags.CORALS)) sound = SoundType.CORAL_BLOCK;
        if (block.defaultBlockState().is(ModTags.ROOTED_DIRT)) sound = SoundType.ROOTED_DIRT;
        if (block.defaultBlockState().is(ModTags.WART)) sound = SoundType.WART_BLOCK;
        if (block.defaultBlockState().is(ModTags.STEMS)) sound = SoundType.STEM;
        if (block.defaultBlockState().is(ModTags.CROP)) sound = SoundType.CROP;
        if (block.defaultBlockState().is(ModTags.SMALL_OBJECTS)) sound = SMALL_OBJECT;

        if (sound != null) {
            return sound;
        }
        return cir.getReturnValue();
    }
}
