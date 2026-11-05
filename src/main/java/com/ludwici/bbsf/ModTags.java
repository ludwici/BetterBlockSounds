package com.ludwici.bbsf;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static com.ludwici.bbsf.BetterBlockSoundsFork.MODID;

public class ModTags {
    public static final TagKey<Block> STONE_ORES = TagKey.create(Registries.BLOCK, loadRes("stone_ores"));
    public static final TagKey<Block> RAW_ORES = TagKey.create(Registries.BLOCK, loadRes("raw_ores"));
    public static final TagKey<Block> LEAVES = TagKey.create(Registries.BLOCK, loadRes("leaves"));
    public static final TagKey<Block> SAPLINGS = TagKey.create(Registries.BLOCK, loadRes("saplings"));
    public static final TagKey<Block> LILIES = TagKey.create(Registries.BLOCK, loadRes("lilies"));
    public static final TagKey<Block> BELLS = TagKey.create(Registries.BLOCK, loadRes("bells"));
    public static final TagKey<Block> BONES = TagKey.create(Registries.BLOCK, loadRes("bones"));
    public static final TagKey<Block> WET = TagKey.create(Registries.BLOCK, loadRes("wet"));
    public static final TagKey<Block> SHROOMS = TagKey.create(Registries.BLOCK, loadRes("shrooms"));
    public static final TagKey<Block> NETHERRACKS = TagKey.create(Registries.BLOCK, loadRes("netherracks"));
    public static final TagKey<Block> BLACKSTONES = TagKey.create(Registries.BLOCK, loadRes("blackstones"));
    public static final TagKey<Block> POLISHED_BLACKSTONES = TagKey.create(Registries.BLOCK, loadRes("polished_blackstones"));
    public static final TagKey<Block> POLISHED_BLACKSTONES_BRICKS = TagKey.create(Registries.BLOCK, loadRes("polished_blackstones_bricks"));
    public static final TagKey<Block> BASALT = TagKey.create(Registries.BLOCK, loadRes("basalt"));
    public static final TagKey<Block> TUFF = TagKey.create(Registries.BLOCK, loadRes("tuff"));
    public static final TagKey<Block> END_STONE_BRICKS = TagKey.create(Registries.BLOCK, loadRes("end_stone_bricksw"));
    public static final TagKey<Block> OBSIDIAN = TagKey.create(Registries.BLOCK, loadRes("obsidian"));
    public static final TagKey<Block> QUARTZ = TagKey.create(Registries.BLOCK, loadRes("quartz"));
    public static final TagKey<Block> QUARTZ_BRICKS = TagKey.create(Registries.BLOCK, loadRes("quartz_bricks"));
    public static final TagKey<Block> GRASS_BLOCKS = TagKey.create(Registries.BLOCK, loadRes("grass_blocks"));
    public static final TagKey<Block> HANGING_ROOTS = TagKey.create(Registries.BLOCK, loadRes("hanging_roots"));
    public static final TagKey<Block> VINE = TagKey.create(Registries.BLOCK, loadRes("vine"));
    public static final TagKey<Block> TERRACOTTA = TagKey.create(Registries.BLOCK, loadRes("terracotta"));
    public static final TagKey<Block> STONE_BRICKS = TagKey.create(Registries.BLOCK, loadRes("stone_bricks"));
    public static final TagKey<Block> CLAY_BRICKS = TagKey.create(Registries.BLOCK, loadRes("clay_bricks"));
    public static final TagKey<Block> NETHERITE_BLOCKS = TagKey.create(Registries.BLOCK, loadRes("netherite_blocks"));
    public static final TagKey<Block> CRYSTALLS = TagKey.create(Registries.BLOCK, loadRes("crystalls"));
    public static final TagKey<Block> CORALS = TagKey.create(Registries.BLOCK, loadRes("coralls"));
    public static final TagKey<Block> ROOTED_DIRT = TagKey.create(Registries.BLOCK, loadRes("rooted_dirt"));
    public static final TagKey<Block> WART = TagKey.create(Registries.BLOCK, loadRes("wart"));
    public static final TagKey<Block> STEMS = TagKey.create(Registries.BLOCK, loadRes("stems"));
    public static final TagKey<Block> CROP = TagKey.create(Registries.BLOCK, loadRes("crop"));
    public static final TagKey<Block> SMALL_OBJECTS = TagKey.create(Registries.BLOCK, loadRes("small_objects"));

    public static final TagKey<Block> COPPER = TagKey.create(Registries.BLOCK, loadRes("copper"));
    public static final TagKey<Block> GLASS = TagKey.create(Registries.BLOCK, loadRes("glass"));
    public static final TagKey<Block> HEAVY_METAL = TagKey.create(Registries.BLOCK, loadRes("heavy_metal"));
    public static final TagKey<Block> BLACKSTONE_BRICKS = TagKey.create(Registries.BLOCK, loadRes("blackstone_bricks"));

    private static ResourceLocation loadRes(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name);
    }
}
