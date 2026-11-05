package com.ludwici.bbsf.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.references.BlockIds;
import net.minecraft.references.BlockItemIds;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

import static com.ludwici.bbsf.BetterBlockSoundsFork.MODID;
import static com.ludwici.bbsf.ModTags.*;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(STONE_ORES)
                .add(BlockItemIds.COAL_ORE.block())
                .add(BlockItemIds.COAL_ORE.block())
                .add(BlockItemIds.COPPER_ORE.block())
                .add(BlockItemIds.IRON_ORE.block())
                .add(BlockItemIds.GOLD_ORE.block())
                .add(BlockItemIds.EMERALD_ORE.block())
                .add(BlockItemIds.DIAMOND_ORE.block())
                .add(BlockItemIds.REDSTONE_ORE.block())
        ;

        tag(RAW_ORES)
                .add(BlockItemIds.RAW_COPPER_BLOCK.block())
                .add(BlockItemIds.RAW_IRON_BLOCK.block())
                .add(BlockItemIds.RAW_GOLD_BLOCK.block())
                .add(BlockItemIds.COAL_BLOCK.block())
        ;

        tag(LEAVES)
                .add(BlockItemIds.OAK_LEAVES.block())
                .add(BlockItemIds.SPRUCE_LEAVES.block())
                .add(BlockItemIds.BIRCH_LEAVES.block())
                .add(BlockItemIds.JUNGLE_LEAVES.block())
                .add(BlockItemIds.ACACIA_LEAVES.block())
                .add(BlockItemIds.DARK_OAK_LEAVES.block())
                .add(BlockItemIds.MANGROVE_LEAVES.block())
                .add(BlockItemIds.CHERRY_LEAVES.block())
                .add(BlockItemIds.PALE_OAK_LEAVES.block())
        ;

        tag(SAPLINGS)
                .add(BlockItemIds.OAK_SAPLING.block())
                .add(BlockItemIds.SPRUCE_SAPLING.block())
                .add(BlockItemIds.BIRCH_SAPLING.block())
                .add(BlockItemIds.JUNGLE_SAPLING.block())
                .add(BlockItemIds.ACACIA_SAPLING.block())
                .add(BlockItemIds.DARK_OAK_SAPLING.block())
                .add(BlockItemIds.MANGROVE_PROPAGULE.block())
                .add(BlockItemIds.CHERRY_SAPLING.block())
                .add(BlockItemIds.PALE_OAK_SAPLING.block())
                .add(BlockItemIds.DEAD_BUSH.block())
        ;

        tag(LILIES)
                .add(BlockItemIds.LILY_PAD.block())
        ;

        tag(BELLS)
                .add(BlockItemIds.BELL.block())
        ;

        tag(BONES)
                .add(BlockItemIds.SKELETON_SKULL.block())
                .add(BlockItemIds.WITHER_SKELETON_SKULL.block())
        ;

        tag(WET)
                .add(BlockItemIds.SPONGE.block())
                .add(BlockItemIds.WET_SPONGE.block())
        ;

        tag(SHROOMS)
                .add(BlockItemIds.END_ROD.block())
        ;

        tag(NETHERRACKS)
                .add(BlockItemIds.MAGMA_BLOCK.block())
        ;

        tag(BLACKSTONES)
                .add(BlockItemIds.BLACKSTONE.block())
                .add(BlockItemIds.BLACKSTONE_STAIRS.block())
                .add(BlockItemIds.BLACKSTONE_SLAB.block())
                .add(BlockItemIds.BLACKSTONE_WALL.block())
        ;

        tag(POLISHED_BLACKSTONES)
                .add(BlockItemIds.POLISHED_BLACKSTONE.block())
                .add(BlockItemIds.POLISHED_BLACKSTONE_STAIRS.block())
                .add(BlockItemIds.POLISHED_BLACKSTONE_SLAB.block())
                .add(BlockItemIds.POLISHED_BLACKSTONE_WALL.block())
                .add(BlockItemIds.POLISHED_BLACKSTONE_BUTTON.block())
                .add(BlockItemIds.POLISHED_BLACKSTONE_PRESSURE_PLATE.block())
        ;

        tag(POLISHED_BLACKSTONES_BRICKS)
                .add(BlockItemIds.POLISHED_BLACKSTONE_BRICKS.block())
                .add(BlockItemIds.POLISHED_BLACKSTONE_BRICK_STAIRS.block())
                .add(BlockItemIds.POLISHED_BLACKSTONE_BRICK_SLAB.block())
                .add(BlockItemIds.POLISHED_BLACKSTONE_BRICK_WALL.block())
                .add(BlockItemIds.CHISELED_POLISHED_BLACKSTONE.block())
        ;

        tag(BASALT)
                .add(BlockItemIds.END_STONE.block())
                .add(BlockItemIds.END_PORTAL_FRAME.block())
                .add(BlockItemIds.ANDESITE.block())
                .add(BlockItemIds.ANDESITE_WALL.block())
                .add(BlockItemIds.ANDESITE_SLAB.block())
                .add(BlockItemIds.ANDESITE_STAIRS.block())
                .add(BlockItemIds.DIORITE.block())
                .add(BlockItemIds.DIORITE_WALL.block())
                .add(BlockItemIds.DIORITE_STAIRS.block())
                .add(BlockItemIds.DIORITE_SLAB.block())
                .add(BlockItemIds.GRANITE.block())
                .add(BlockItemIds.GRANITE_WALL.block())
                .add(BlockItemIds.GRANITE_STAIRS.block())
                .add(BlockItemIds.GRANITE_SLAB.block())
        ;

        tag(TUFF)
                .add(BlockItemIds.SANDSTONE.block())
                .add(BlockItemIds.CHISELED_SANDSTONE.block())
                .add(BlockItemIds.CUT_SANDSTONE.block())
                .add(BlockItemIds.SMOOTH_SANDSTONE.block())
                .add(BlockItemIds.SANDSTONE_STAIRS.block())
                .add(BlockItemIds.SMOOTH_SANDSTONE_STAIRS.block())
                .add(BlockItemIds.SANDSTONE_SLAB.block())
                .add(BlockItemIds.CUT_SANDSTONE_SLAB.block())
                .add(BlockItemIds.SMOOTH_SANDSTONE_SLAB.block())
                .add(BlockItemIds.SANDSTONE_WALL.block())
                .add(BlockItemIds.RED_SANDSTONE.block())
                .add(BlockItemIds.CHISELED_RED_SANDSTONE.block())
                .add(BlockItemIds.CUT_RED_SANDSTONE.block())
                .add(BlockItemIds.SMOOTH_RED_SANDSTONE.block())
                .add(BlockItemIds.RED_SANDSTONE_STAIRS.block())
                .add(BlockItemIds.SMOOTH_RED_SANDSTONE_STAIRS.block())
                .add(BlockItemIds.RED_SANDSTONE_SLAB.block())
                .add(BlockItemIds.CUT_RED_SANDSTONE_SLAB.block())
                .add(BlockItemIds.SMOOTH_RED_SANDSTONE_SLAB.block())
                .add(BlockItemIds.RED_SANDSTONE_WALL.block())
                .add(BlockItemIds.TURTLE_EGG.block())
        ;

        tag(END_STONE_BRICKS)
                .add(BlockItemIds.END_STONE_BRICKS.block())
                .add(BlockItemIds.END_STONE_BRICK_STAIRS.block())
                .add(BlockItemIds.END_STONE_BRICK_SLAB.block())
                .add(BlockItemIds.END_STONE_BRICK_WALL.block())
        ;

        tag(OBSIDIAN)
                .add(BlockItemIds.OBSIDIAN.block())
                .add(BlockItemIds.CRYING_OBSIDIAN.block())
                .add(BlockItemIds.RESPAWN_ANCHOR.block())
                .add(BlockItemIds.ENDER_CHEST.block())
                .add(BlockItemIds.BEDROCK.block())
                .add(BlockItemIds.ENCHANTING_TABLE.block())
                .add(BlockItemIds.BEACON.block())
        ;

        tag(QUARTZ)
                .add(BlockItemIds.SMOOTH_QUARTZ.block())
                .add(BlockItemIds.SMOOTH_QUARTZ_SLAB.block())
                .add(BlockItemIds.SMOOTH_QUARTZ_STAIRS.block())
                .add(BlockItemIds.QUARTZ_BLOCK.block())
                .add(BlockItemIds.QUARTZ_SLAB.block())
                .add(BlockItemIds.QUARTZ_STAIRS.block())
                .add(BlockItemIds.PRISMARINE.block())
                .add(BlockItemIds.PRISMARINE_SLAB.block())
                .add(BlockItemIds.PRISMARINE_STAIRS.block())
                .add(BlockItemIds.PRISMARINE_WALL.block())
        ;

        tag(QUARTZ_BRICKS)
                .add(BlockItemIds.CHISELED_QUARTZ_BLOCK.block())
                .add(BlockItemIds.QUARTZ_PILLAR.block())
                .add(BlockItemIds.QUARTZ_BRICKS.block())
                .add(BlockItemIds.PRISMARINE_BRICKS.block())
                .add(BlockItemIds.PRISMARINE_BRICK_SLAB.block())
                .add(BlockItemIds.PRISMARINE_BRICK_STAIRS.block())
                .add(BlockItemIds.DARK_PRISMARINE.block())
                .add(BlockItemIds.DARK_PRISMARINE_SLAB.block())
                .add(BlockItemIds.DARK_PRISMARINE_STAIRS.block())
                .add(BlockItemIds.PURPUR_BLOCK.block())
                .add(BlockItemIds.PURPUR_SLAB.block())
                .add(BlockItemIds.PURPUR_STAIRS.block())
                .add(BlockItemIds.PURPUR_PILLAR.block())
                .add(BlockItemIds.SEA_LANTERN.block())
        ;

        tag(GRASS_BLOCKS)
                .add(BlockItemIds.GRASS_BLOCK.block())
                .add(BlockItemIds.PODZOL.block())
                .add(BlockItemIds.MYCELIUM.block())
                .add(BlockItemIds.DIRT_PATH.block())
        ;

        tag(HANGING_ROOTS)
                .add(BlockItemIds.SHORT_GRASS.block())
                .add(BlockItemIds.TALL_GRASS.block())
                .add(BlockItemIds.FERN.block())
                .add(BlockItemIds.LARGE_FERN.block())
                .add(BlockItemIds.DANDELION.block())
                .add(BlockItemIds.POPPY.block())
                .add(BlockItemIds.BLUE_ORCHID.block())
                .add(BlockItemIds.ALLIUM.block())
                .add(BlockItemIds.AZURE_BLUET.block())
                .add(BlockItemIds.RED_TULIP.block())
                .add(BlockItemIds.ORANGE_TULIP.block())
                .add(BlockItemIds.WHITE_TULIP.block())
                .add(BlockItemIds.PINK_TULIP.block())
                .add(BlockItemIds.OXEYE_DAISY.block())
                .add(BlockItemIds.LILY_OF_THE_VALLEY.block())
                .add(BlockItemIds.WITHER_ROSE.block())
                .add(BlockItemIds.BROWN_MUSHROOM.block())
                .add(BlockItemIds.RED_MUSHROOM.block())
                .add(BlockItemIds.CLOSED_EYEBLOSSOM.block())
                .add(BlockItemIds.OPEN_EYEBLOSSOM.block())
        ;

        tag(VINE)
                .add(BlockItemIds.COBWEB.block())
                .add(BlockItemIds.GLOW_LICHEN.block())
        ;

        tag(TERRACOTTA)
                .addTag(BlockTags.TERRACOTTA)
                .add(BlockItemIds.TERRACOTTA.block())
                .add(BlockItemIds.CONDUIT.block())
        ;

        tag(STONE_BRICKS)
                .add(BlockItemIds.STONE_BRICK_SLAB.block())
                .add(BlockItemIds.INFESTED_STONE_BRICKS.block())
                .add(BlockItemIds.INFESTED_MOSSY_STONE_BRICKS.block())
                .add(BlockItemIds.INFESTED_CHISELED_STONE_BRICKS.block())
                .add(BlockItemIds.STONE_BRICKS.block())
                .add(BlockItemIds.MOSSY_STONE_BRICKS.block())
                .add(BlockItemIds.CRACKED_STONE_BRICKS.block())
                .add(BlockItemIds.CHISELED_STONE_BRICKS.block())
                .add(BlockItemIds.STONE_BRICK_STAIRS.block())
                .add(BlockItemIds.MOSSY_STONE_BRICK_WALL.block())
                .add(BlockItemIds.STONE_BRICK_WALL.block())
                .add(BlockItemIds.MOSSY_STONE_BRICK_STAIRS.block())
                .add(BlockItemIds.MOSSY_STONE_BRICK_SLAB.block())
        ;

        tag(CLAY_BRICKS)
                .add(BlockItemIds.BRICK_SLAB.block())
                .add(BlockItemIds.BRICKS.block())
                .add(BlockItemIds.BRICK_STAIRS.block())
                .add(BlockItemIds.BRICK_WALL.block())
        ;

        tag(NETHERITE_BLOCKS)
                .add(BlockItemIds.GOLD_BLOCK.block())
                .add(BlockItemIds.DIAMOND_BLOCK.block())
                .add(BlockItemIds.IRON_BARS.block())
                .add(BlockItemIds.IRON_DOOR.block())
                .add(BlockItemIds.IRON_BLOCK.block())
                .add(BlockItemIds.OBSERVER.block())
                .add(BlockItemIds.DROPPER.block())
                .add(BlockItemIds.DISPENSER.block())
        ;

        tag(CRYSTALLS)
                .add(BlockItemIds.EMERALD_BLOCK.block())
        ;

        tag(CORALS)
                .add(BlockItemIds.DEAD_BRAIN_CORAL.block())
                .add(BlockItemIds.DEAD_HORN_CORAL.block())
                .add(BlockItemIds.DEAD_FIRE_CORAL.block())
                .add(BlockItemIds.DEAD_TUBE_CORAL.block())
                .add(BlockItemIds.DEAD_BUBBLE_CORAL.block())
                .add(BlockItemIds.DEAD_BRAIN_CORAL_FAN.block())
                .add(BlockItemIds.DEAD_HORN_CORAL_FAN.block())
                .add(BlockItemIds.DEAD_FIRE_CORAL_FAN.block())
                .add(BlockItemIds.DEAD_TUBE_CORAL_FAN.block())
                .add(BlockItemIds.DEAD_BUBBLE_CORAL_FAN.block())
                .add(BlockItemIds.DEAD_BRAIN_CORAL_BLOCK.block())
                .add(BlockItemIds.DEAD_HORN_CORAL_BLOCK.block())
                .add(BlockItemIds.DEAD_FIRE_CORAL_BLOCK.block())
                .add(BlockItemIds.DEAD_TUBE_CORAL_BLOCK.block())
                .add(BlockItemIds.DEAD_BUBBLE_CORAL_BLOCK.block())
        ;

        tag(ROOTED_DIRT)
                .add(BlockItemIds.GRAVEL.block())
                .add(BlockItemIds.DIRT.block())
                .add(BlockItemIds.COARSE_DIRT.block())
        ;

        tag(WART)
                .add(BlockItemIds.ROOTED_DIRT.block())
                .add(BlockItemIds.RED_MUSHROOM_BLOCK.block())
                .add(BlockItemIds.BROWN_MUSHROOM_BLOCK.block())
                .add(BlockItemIds.MUSHROOM_STEM.block())
        ;

        tag(STEMS)
                .add(BlockItemIds.CHORUS_PLANT.block())
                .add(BlockItemIds.CHORUS_FLOWER.block())
        ;

        tag(CROP)
                .add(BlockItemIds.ROSE_BUSH.block())
                .add(BlockItemIds.PEONY.block())
                .add(BlockItemIds.LILAC.block())
                .add(BlockItemIds.SUNFLOWER.block())
                .add(BlockItemIds.CACTUS.block())
                .add(BlockItemIds.SUGAR_CANE.block())
                .add(BlockItemIds.TORCHFLOWER.block())
        ;

        tag(SMALL_OBJECTS)
                .add(BlockItemIds.FLOWER_POT.block())
                .add(BlockItemIds.TORCH.block())
                .add(BlockItemIds.SOUL_TORCH.block())
                .add(BlockItemIds.REDSTONE_TORCH.block())
                .add(BlockIds.WALL_TORCH)
                .add(BlockIds.SOUL_WALL_TORCH)
                .add(BlockIds.REDSTONE_WALL_TORCH)
        ;
    }
}
