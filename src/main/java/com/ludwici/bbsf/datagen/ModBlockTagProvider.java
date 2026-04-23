package com.ludwici.bbsf.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.ludwici.bbsf.BetterBlockSoundsFork.*;
import static com.ludwici.bbsf.ModTags.*;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(STONE_ORES)
                .add(Blocks.COAL_ORE)
                .add(Blocks.COPPER_ORE)
                .add(Blocks.IRON_ORE)
                .add(Blocks.GOLD_ORE)
                .add(Blocks.EMERALD_ORE)
                .add(Blocks.DIAMOND_ORE)
                .add(Blocks.REDSTONE_ORE)
        ;

        tag(RAW_ORES)
                .add(Blocks.RAW_COPPER_BLOCK)
                .add(Blocks.RAW_IRON_BLOCK)
                .add(Blocks.RAW_GOLD_BLOCK)
                .add(Blocks.COAL_BLOCK)
        ;

        tag(LEAVES)
                .add(Blocks.OAK_LEAVES)
                .add(Blocks.SPRUCE_LEAVES)
                .add(Blocks.BIRCH_LEAVES)
                .add(Blocks.JUNGLE_LEAVES)
                .add(Blocks.ACACIA_LEAVES)
                .add(Blocks.DARK_OAK_LEAVES)
                .add(Blocks.MANGROVE_LEAVES)
                .add(Blocks.CHERRY_LEAVES)
        ;

        tag(SAPLINGS)
                .add(Blocks.OAK_SAPLING)
                .add(Blocks.SPRUCE_SAPLING)
                .add(Blocks.BIRCH_SAPLING)
                .add(Blocks.JUNGLE_SAPLING)
                .add(Blocks.ACACIA_SAPLING)
                .add(Blocks.DARK_OAK_SAPLING)
                .add(Blocks.MANGROVE_PROPAGULE)
                .add(Blocks.CHERRY_SAPLING)
                .add(Blocks.DEAD_BUSH)
        ;

        tag(LILIES)
                .add(Blocks.LILY_PAD)
        ;

        tag(BELLS)
                .add(Blocks.BELL)
        ;

        tag(BONES)
                .add(Blocks.SKELETON_SKULL)
                .add(Blocks.WITHER_SKELETON_SKULL)
        ;

        tag(WET)
                .add(Blocks.SPONGE)
                .add(Blocks.WET_SPONGE)
        ;

        tag(SHROOMS)
                .add(Blocks.END_ROD)
        ;

        tag(NETHERRACKS)
                .add(Blocks.MAGMA_BLOCK)
        ;

        tag(BLACKSTONES)
                .add(Blocks.BLACKSTONE)
                .add(Blocks.BLACKSTONE_STAIRS)
                .add(Blocks.BLACKSTONE_SLAB)
                .add(Blocks.BLACKSTONE_WALL)
        ;

        tag(POLISHED_BLACKSTONES)
                .add(Blocks.POLISHED_BLACKSTONE)
                .add(Blocks.POLISHED_BLACKSTONE_STAIRS)
                .add(Blocks.POLISHED_BLACKSTONE_SLAB)
                .add(Blocks.POLISHED_BLACKSTONE_WALL)
                .add(Blocks.POLISHED_BLACKSTONE_BUTTON)
                .add(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE)
        ;

        tag(POLISHED_BLACKSTONES_BRICKS)
                .add(Blocks.POLISHED_BLACKSTONE_BRICKS)
                .add(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS)
                .add(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB)
                .add(Blocks.POLISHED_BLACKSTONE_BRICK_WALL)
                .add(Blocks.CHISELED_POLISHED_BLACKSTONE)
        ;

        tag(BASALT)
                .add(Blocks.END_STONE)
                .add(Blocks.END_PORTAL_FRAME)
                .add(Blocks.ANDESITE)
                .add(Blocks.ANDESITE_WALL)
                .add(Blocks.ANDESITE_SLAB)
                .add(Blocks.ANDESITE_STAIRS)
                .add(Blocks.DIORITE)
                .add(Blocks.DIORITE_WALL)
                .add(Blocks.DIORITE_STAIRS)
                .add(Blocks.DIORITE_SLAB)
                .add(Blocks.GRANITE)
                .add(Blocks.GRANITE_WALL)
                .add(Blocks.GRANITE_STAIRS)
                .add(Blocks.GRANITE_SLAB)
        ;

        tag(TUFF)
                .add(Blocks.SANDSTONE)
                .add(Blocks.CHISELED_SANDSTONE)
                .add(Blocks.CUT_SANDSTONE)
                .add(Blocks.SMOOTH_SANDSTONE)
                .add(Blocks.SANDSTONE_STAIRS)
                .add(Blocks.SMOOTH_SANDSTONE_STAIRS)
                .add(Blocks.SANDSTONE_SLAB)
                .add(Blocks.CUT_SANDSTONE_SLAB)
                .add(Blocks.SMOOTH_SANDSTONE_SLAB)
                .add(Blocks.SANDSTONE_WALL)
                .add(Blocks.RED_SANDSTONE)
                .add(Blocks.CHISELED_RED_SANDSTONE)
                .add(Blocks.CUT_RED_SANDSTONE)
                .add(Blocks.SMOOTH_RED_SANDSTONE)
                .add(Blocks.RED_SANDSTONE_STAIRS)
                .add(Blocks.SMOOTH_RED_SANDSTONE_STAIRS)
                .add(Blocks.RED_SANDSTONE_SLAB)
                .add(Blocks.CUT_RED_SANDSTONE_SLAB)
                .add(Blocks.SMOOTH_RED_SANDSTONE_SLAB)
                .add(Blocks.RED_SANDSTONE_WALL)
                .add(Blocks.TURTLE_EGG)
        ;

        tag(END_STONE_BRICKS)
                .add(Blocks.END_STONE_BRICKS)
                .add(Blocks.END_STONE_BRICK_STAIRS)
                .add(Blocks.END_STONE_BRICK_SLAB)
                .add(Blocks.END_STONE_BRICK_WALL)
        ;

        tag(OBSIDIAN)
                .add(Blocks.OBSIDIAN)
                .add(Blocks.CRYING_OBSIDIAN)
                .add(Blocks.RESPAWN_ANCHOR)
                .add(Blocks.ENDER_CHEST)
                .add(Blocks.BEDROCK)
                .add(Blocks.ENCHANTING_TABLE)
                .add(Blocks.BEACON)
        ;

        tag(QUARTZ)
                .add(Blocks.SMOOTH_QUARTZ)
                .add(Blocks.SMOOTH_QUARTZ_SLAB)
                .add(Blocks.SMOOTH_QUARTZ_STAIRS)
                .add(Blocks.QUARTZ_BLOCK)
                .add(Blocks.QUARTZ_SLAB)
                .add(Blocks.QUARTZ_STAIRS)
                .add(Blocks.PRISMARINE)
                .add(Blocks.PRISMARINE_SLAB)
                .add(Blocks.PRISMARINE_STAIRS)
                .add(Blocks.PRISMARINE_WALL)
        ;

        tag(QUARTZ_BRICKS)
                .add(Blocks.CHISELED_QUARTZ_BLOCK)
                .add(Blocks.QUARTZ_PILLAR)
                .add(Blocks.QUARTZ_BRICKS)
                .add(Blocks.PRISMARINE_BRICKS)
                .add(Blocks.PRISMARINE_BRICK_SLAB)
                .add(Blocks.PRISMARINE_BRICK_STAIRS)
                .add(Blocks.DARK_PRISMARINE)
                .add(Blocks.DARK_PRISMARINE_SLAB)
                .add(Blocks.DARK_PRISMARINE_STAIRS)
                .add(Blocks.PURPUR_BLOCK)
                .add(Blocks.PURPUR_SLAB)
                .add(Blocks.PURPUR_STAIRS)
                .add(Blocks.PURPUR_PILLAR)
                .add(Blocks.SEA_LANTERN)
        ;

        tag(GRASS_BLOCKS)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.PODZOL)
                .add(Blocks.MYCELIUM)
                .add(Blocks.DIRT_PATH)
        ;

        tag(HANGING_ROOTS)
                .add(Blocks.SHORT_GRASS)
                .add(Blocks.TALL_GRASS)
                .add(Blocks.FERN)
                .add(Blocks.LARGE_FERN)
                .add(Blocks.DANDELION)
                .add(Blocks.POPPY)
                .add(Blocks.BLUE_ORCHID)
                .add(Blocks.ALLIUM)
                .add(Blocks.AZURE_BLUET)
                .add(Blocks.RED_TULIP)
                .add(Blocks.ORANGE_TULIP)
                .add(Blocks.WHITE_TULIP)
                .add(Blocks.PINK_TULIP)
                .add(Blocks.OXEYE_DAISY)
                .add(Blocks.LILY_OF_THE_VALLEY)
                .add(Blocks.WITHER_ROSE)
                .add(Blocks.BROWN_MUSHROOM)
                .add(Blocks.RED_MUSHROOM)
        ;

        tag(VINE)
                .add(Blocks.COBWEB)
                .add(Blocks.GLOW_LICHEN)
        ;

        tag(TERRACOTTA)
                .add(Blocks.WHITE_TERRACOTTA)
                .add(Blocks.ORANGE_TERRACOTTA)
                .add(Blocks.MAGENTA_TERRACOTTA)
                .add(Blocks.LIGHT_BLUE_TERRACOTTA)
                .add(Blocks.YELLOW_TERRACOTTA)
                .add(Blocks.LIME_TERRACOTTA)
                .add(Blocks.PINK_TERRACOTTA)
                .add(Blocks.GRAY_TERRACOTTA)
                .add(Blocks.LIGHT_GRAY_TERRACOTTA)
                .add(Blocks.CYAN_TERRACOTTA)
                .add(Blocks.PURPLE_TERRACOTTA)
                .add(Blocks.BROWN_TERRACOTTA)
                .add(Blocks.GREEN_TERRACOTTA)
                .add(Blocks.RED_TERRACOTTA)
                .add(Blocks.BLACK_TERRACOTTA)
                .add(Blocks.TERRACOTTA)
                .add(Blocks.CONDUIT)
        ;

        tag(STONE_BRICKS)
                .add(Blocks.STONE_BRICK_SLAB)
                .add(Blocks.INFESTED_STONE_BRICKS)
                .add(Blocks.INFESTED_MOSSY_STONE_BRICKS)
                .add(Blocks.INFESTED_CHISELED_STONE_BRICKS)
                .add(Blocks.STONE_BRICKS)
                .add(Blocks.MOSSY_STONE_BRICKS)
                .add(Blocks.CRACKED_STONE_BRICKS)
                .add(Blocks.CHISELED_STONE_BRICKS)
                .add(Blocks.STONE_BRICK_STAIRS)
                .add(Blocks.MOSSY_STONE_BRICK_WALL)
                .add(Blocks.STONE_BRICK_WALL)
                .add(Blocks.MOSSY_STONE_BRICK_STAIRS)
                .add(Blocks.MOSSY_STONE_BRICK_SLAB)
        ;

        tag(CLAY_BRICKS)
                .add(Blocks.BRICK_SLAB)
                .add(Blocks.BRICKS)
                .add(Blocks.BRICK_STAIRS)
                .add(Blocks.BRICK_WALL)
        ;

        tag(NETHERITE_BLOCKS)
                .add(Blocks.GOLD_BLOCK)
                .add(Blocks.DIAMOND_BLOCK)
                .add(Blocks.IRON_BARS)
                .add(Blocks.IRON_DOOR)
                .add(Blocks.IRON_BLOCK)
                .add(Blocks.OBSERVER)
                .add(Blocks.DROPPER)
                .add(Blocks.DISPENSER)
        ;

        tag(CRYSTALLS)
                .add(Blocks.EMERALD_BLOCK)
        ;

        tag(CORALS)
                .add(Blocks.DEAD_BRAIN_CORAL)
                .add(Blocks.DEAD_HORN_CORAL)
                .add(Blocks.DEAD_FIRE_CORAL)
                .add(Blocks.DEAD_TUBE_CORAL)
                .add(Blocks.DEAD_BUBBLE_CORAL)
                .add(Blocks.DEAD_BRAIN_CORAL_FAN)
                .add(Blocks.DEAD_HORN_CORAL_FAN)
                .add(Blocks.DEAD_FIRE_CORAL_FAN)
                .add(Blocks.DEAD_TUBE_CORAL_FAN)
                .add(Blocks.DEAD_BUBBLE_CORAL_FAN)
                .add(Blocks.DEAD_BRAIN_CORAL_BLOCK)
                .add(Blocks.DEAD_HORN_CORAL_BLOCK)
                .add(Blocks.DEAD_FIRE_CORAL_BLOCK)
                .add(Blocks.DEAD_TUBE_CORAL_BLOCK)
                .add(Blocks.DEAD_BUBBLE_CORAL_BLOCK)
        ;

        tag(ROOTED_DIRT)
                .add(Blocks.GRAVEL)
                .add(Blocks.DIRT)
                .add(Blocks.COARSE_DIRT)
        ;

        tag(WART)
                .add(Blocks.ROOTED_DIRT)
                .add(Blocks.RED_MUSHROOM_BLOCK)
                .add(Blocks.BROWN_MUSHROOM_BLOCK)
                .add(Blocks.MUSHROOM_STEM)
        ;

        tag(STEMS)
                .add(Blocks.CHORUS_PLANT)
                .add(Blocks.CHORUS_FLOWER)
        ;

        tag(CROP)
                .add(Blocks.ROSE_BUSH)
                .add(Blocks.PEONY)
                .add(Blocks.LILAC)
                .add(Blocks.SUNFLOWER)
                .add(Blocks.CACTUS)
                .add(Blocks.SUGAR_CANE)
                .add(Blocks.TORCHFLOWER)
        ;

        tag(SMALL_OBJECTS)
                .add(Blocks.FLOWER_POT)
                .add(Blocks.TORCH)
                .add(Blocks.SOUL_TORCH)
                .add(Blocks.REDSTONE_TORCH)
                .add(Blocks.WALL_TORCH)
                .add(Blocks.SOUL_WALL_TORCH)
                .add(Blocks.REDSTONE_WALL_TORCH)
        ;
    }
}
