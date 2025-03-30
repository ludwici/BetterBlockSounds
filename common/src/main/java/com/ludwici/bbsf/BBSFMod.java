package com.ludwici.bbsf;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class BBSFMod {
    public static final String MOD_ID = "bbsf";

    public static final TagKey<Block> STONE_ORES = TagKey.create(Registries.BLOCK, loadRes("stone_ores"));
    public static final TagKey<Block> OBSIDIAN = TagKey.create(Registries.BLOCK, loadRes("obsidian"));
    public static final TagKey<Block> COPPER = TagKey.create(Registries.BLOCK, loadRes("glass"));
    public static final TagKey<Block> GLASS = TagKey.create(Registries.BLOCK, loadRes("copper"));
    public static final TagKey<Block> HEAVY_METAL = TagKey.create(Registries.BLOCK, loadRes("heavy_metal"));
    public static final TagKey<Block> SMALL_OBJECTS = TagKey.create(Registries.BLOCK, loadRes("small_objects"));
    public static final TagKey<Block> CLAY_BRICKS = TagKey.create(Registries.BLOCK, loadRes("clay_bricks"));
    public static final TagKey<Block> GRASS_BLOCKS = TagKey.create(Registries.BLOCK, loadRes("grass_blocks"));
    public static final TagKey<Block> BLACKSTONE = TagKey.create(Registries.BLOCK, loadRes("blackstone"));
    public static final TagKey<Block> POLISHED_BLACKSTONE = TagKey.create(Registries.BLOCK, loadRes("polished_blackstone"));
    public static final TagKey<Block> BLACKSTONE_BRICKS = TagKey.create(Registries.BLOCK, loadRes("blackstone_bricks"));
    public static final TagKey<Block> BASALT = TagKey.create(Registries.BLOCK, loadRes("basalt"));
    public static final TagKey<Block> END_STONE_BRICKS = TagKey.create(Registries.BLOCK, loadRes("end_stone_bricksw"));

    private static ResourceLocation loadRes(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
    
    public static void init() {

    }
}
