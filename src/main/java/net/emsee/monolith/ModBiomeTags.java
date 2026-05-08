package net.emsee.monolith;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModBiomeTags {

    public static final TagKey<Biome> STONE_STATUES = createTag("has_structure/stone_statues_biomes");
    public static final TagKey<Biome> SAND_STATUES = createTag("has_structure/sand_statues_biomes");
    public static final TagKey<Biome> ICE_STATUES = createTag("has_structure/ice_statues_biomes");
    private static TagKey<Biome> createTag(String name) {
        return TagKey.create(Registries.BIOME, Monolith.defaultLocation(name));

    }

}
