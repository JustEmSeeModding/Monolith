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

public class StoneToSandProcessor extends AbstractProcessor {
    public static final StoneToSandProcessor INSTANCE = new StoneToSandProcessor();
    public static final MapCodec<StoneToSandProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    protected @NotNull Map<Block, WeightedMap.Int<ReplaceInstance>> createReplacements() {
        return Util.make(new HashMap<>(), map -> {
            map.put(Blocks.STONE, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.SANDSTONE.defaultBlockState()), 1,
                            new ReplaceInstance(Blocks.SMOOTH_SANDSTONE.defaultBlockState()), 1)));
            map.put(Blocks.STONE_SLAB, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.SANDSTONE_SLAB.defaultBlockState()), 1,
                            new ReplaceInstance(Blocks.SMOOTH_STONE.defaultBlockState()), 1)));
            map.put(Blocks.STONE_STAIRS, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.SANDSTONE_STAIRS.defaultBlockState()), 1,
                            new ReplaceInstance(Blocks.SMOOTH_SANDSTONE_STAIRS.defaultBlockState()), 1)));
            map.put(Blocks.COBBLESTONE_WALL, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.SANDSTONE_WALL.defaultBlockState()), 1)));
            map.put(Blocks.STONE_BRICKS, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.CUT_SANDSTONE.defaultBlockState()), 1)));
            map.put(Blocks.STONE_BRICK_SLAB, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.CUT_SANDSTONE_SLAB.defaultBlockState()), 1)));
            map.put(Blocks.STONE_BRICK_STAIRS, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.SMOOTH_SANDSTONE_STAIRS.defaultBlockState()), 1)));
            map.put(Blocks.STONE_BRICK_WALL, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.SANDSTONE_WALL.defaultBlockState()), 1)));
            map.put(Blocks.CHISELED_STONE_BRICKS, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.CHISELED_SANDSTONE.defaultBlockState()), 1)));
            map.put(Blocks.SMOOTH_STONE, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.CUT_SANDSTONE.defaultBlockState()), 1)));
            map.put(Blocks.SMOOTH_STONE_SLAB, new WeightedMap.Int<>(Map.of(
                            new ReplaceInstance(Blocks.CUT_SANDSTONE_SLAB.defaultBlockState()), 1)));
        });
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return ModProcessors.STONE_STATUE.get();
    }
}
