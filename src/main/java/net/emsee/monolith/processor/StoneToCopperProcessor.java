package net.emsee.monolith.processor;

import com.mojang.serialization.MapCodec;
import net.emsee.monolith.WeightedMap;
import net.minecraft.Util;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class StoneToCopperProcessor extends AbstractProcessor {
    public static final StoneToCopperProcessor INSTANCE = new StoneToCopperProcessor();
    public static final MapCodec<StoneToCopperProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    protected @NotNull Map<Block, WeightedMap.Int<ReplaceInstance>> createReplacements() {
        return Util.make(new HashMap<>(), map -> {
            map.put(Blocks.STONE, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.OXIDIZED_COPPER.defaultBlockState()), 1)));
            map.put(Blocks.STONE_SLAB, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.OXIDIZED_CUT_COPPER_SLAB.defaultBlockState()), 1)));
            map.put(Blocks.STONE_STAIRS, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.OXIDIZED_CUT_COPPER_STAIRS.defaultBlockState()), 1)));
            map.put(Blocks.STONE_BRICKS, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.OXIDIZED_CUT_COPPER.defaultBlockState()), 1)));
            map.put(Blocks.STONE_BRICK_SLAB, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.OXIDIZED_CUT_COPPER_SLAB.defaultBlockState()), 1)));
            map.put(Blocks.STONE_BRICK_STAIRS, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.OXIDIZED_CUT_COPPER_STAIRS.defaultBlockState()), 1)));
            map.put(Blocks.CHISELED_STONE_BRICKS, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.OXIDIZED_CHISELED_COPPER.defaultBlockState()), 1)));
            map.put(Blocks.SMOOTH_STONE, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.OXIDIZED_COPPER_BULB.defaultBlockState()), 1)));
            map.put(Blocks.SMOOTH_STONE_SLAB, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.OXIDIZED_CUT_COPPER_SLAB.defaultBlockState()), 1)));
            map.put(Blocks.COBBLESTONE_WALL, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.OXIDIZED_COPPER_GRATE.defaultBlockState()), 1)));
            map.put(Blocks.STONE_BRICK_WALL, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.OXIDIZED_COPPER_GRATE.defaultBlockState()), 1)));
        });
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return ModProcessors.COPPER_STATUE_FROM_STONE.get();
    }
}
