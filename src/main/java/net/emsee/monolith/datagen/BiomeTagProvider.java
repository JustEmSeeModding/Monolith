package net.emsee.monolith.datagen;

import net.emsee.monolith.ModBiomeTags;
import net.emsee.monolith.Monolith;
import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.internal.NeoForgeBiomeTagsProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public final class BiomeTagProvider extends BiomeTagsProvider {

    BiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, Monolith.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            tag(ModBiomeTags.STONE_STATUES)
                    .addTag(BiomeTags.IS_JUNGLE)
                    .addTag(BiomeTags.IS_FOREST)
                    .addTag(BiomeTags.IS_TAIGA)
                    .addTag(BiomeTags.IS_OCEAN)
                    .addTag(BiomeTags.IS_DEEP_OCEAN)
                    .add(Biomes.PLAINS)
                    .add(Biomes.SNOWY_PLAINS)
                    .add(Biomes.SUNFLOWER_PLAINS)
                    .add(Biomes.SAVANNA)
                    .add(Biomes.SAVANNA_PLATEAU)
                    .add(Biomes.WINDSWEPT_SAVANNA)
                    .add(Biomes.SWAMP)
                    .add(Biomes.WINDSWEPT_HILLS)
                    .addOptionalTag(Tags.Biomes.IS_JUNGLE)
                    .addOptionalTag(Tags.Biomes.IS_FOREST)
                    .addOptionalTag(Tags.Biomes.IS_TAIGA)
                    .addOptionalTag(Tags.Biomes.IS_PLAINS)
                    .addOptionalTag(Tags.Biomes.IS_SNOWY_PLAINS)
                    .addOptionalTag(Tags.Biomes.IS_SAVANNA)
                    .addOptionalTag(Tags.Biomes.IS_OCEAN)
                    .addOptionalTag(Tags.Biomes.IS_AQUATIC);

            tag(ModBiomeTags.SAND_STATUES)
                    .addTag(BiomeTags.IS_OCEAN)
                    .addTag(BiomeTags.IS_DEEP_OCEAN)
                    .add(Biomes.DESERT)
                    .addOptionalTag(Tags.Biomes.IS_DESERT)
                    .addOptionalTag(Tags.Biomes.IS_OCEAN)
                    .addOptionalTag(Tags.Biomes.IS_AQUATIC);

            tag(ModBiomeTags.ICE_STATUES)
                    .add(Biomes.FROZEN_PEAKS)
                    .add(Biomes.SNOWY_PLAINS)
                    .add(Biomes.SNOWY_SLOPES)
                    .add(Biomes.SNOWY_TAIGA)
                    .add(Biomes.ICE_SPIKES)
                    .addOptionalTag(Tags.Biomes.IS_SNOWY)
                    .addOptionalTag(Tags.Biomes.IS_ICY);


        }
}
