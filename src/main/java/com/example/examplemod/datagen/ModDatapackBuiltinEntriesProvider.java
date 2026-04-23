package com.example.examplemod.datagen;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

// world gen and damage types

public final class ModDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {
    static RegistrySetBuilder BUILDER = new RegistrySetBuilder();
            //.add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
            //.add(Registries.BIOME, ModBiomes::bootstrap)
            //.add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem)
            //.add(Registries.DAMAGE_TYPE, ModDamageTypes::bootstrap);

    ModDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ExampleMod.MOD_ID));
    }
}
