package net.emsee.monolith.processor;

import com.mojang.serialization.MapCodec;
import net.emsee.monolith.WeightedMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class StoneProcessor extends AbstractProcessor {
    public static final StoneProcessor INSTANCE = new StoneProcessor();
    public static final MapCodec<StoneProcessor> CODEC = MapCodec.unit(() -> INSTANCE);


    @Override
    protected @NotNull Map<Block, WeightedMap.Int<ReplaceInstance>> createReplacements() {
        return Map.of(
                Blocks.COBBLESTONE,
                new WeightedMap.Int<>(Map.of(
                        new ReplaceInstance(Blocks.COBBLESTONE.defaultBlockState()),3,
                        new ReplaceInstance(Blocks.MOSSY_COBBLESTONE.defaultBlockState()),2
                        //new ReplaceInstance(Blocks.ANDESITE.defaultBlockState()),2
                        //new ReplaceInstance(Blocks.TUFF.defaultBlockState()),1
                        )),
                Blocks.COBBLESTONE_SLAB,
                new WeightedMap.Int<>(Map.of(
                        new ReplaceInstance(Blocks.COBBLESTONE_SLAB.defaultBlockState()),4,
                        new ReplaceInstance(Blocks.MOSSY_COBBLESTONE_SLAB.defaultBlockState()),2
                        //new ReplaceInstance(Blocks.ANDESITE_SLAB.defaultBlockState()),2
                        //new ReplaceInstance(Blocks.TUFF_SLAB.defaultBlockState()),1
                        )),
                Blocks.COBBLESTONE_STAIRS,
                new WeightedMap.Int<>(Map.of(
                        new ReplaceInstance(Blocks.COBBLESTONE_STAIRS.defaultBlockState()),4,
                        new ReplaceInstance(Blocks.MOSSY_COBBLESTONE_STAIRS.defaultBlockState()),2
                        //new ReplaceInstance(Blocks.ANDESITE_STAIRS.defaultBlockState()),2
                        //new ReplaceInstance(Blocks.TUFF_STAIRS.defaultBlockState()),1
                )),
                Blocks.COBBLESTONE_WALL,
                new WeightedMap.Int<>(Map.of(
                        new ReplaceInstance(Blocks.COBBLESTONE_WALL.defaultBlockState()),4,
                        new ReplaceInstance(Blocks.MOSSY_COBBLESTONE_WALL.defaultBlockState()),2
                        //new ReplaceInstance(Blocks.ANDESITE_WALL.defaultBlockState()),2
                        //new ReplaceInstance(Blocks.TUFF_WALL.defaultBlockState()),1
                )),
                Blocks.STONE_BRICKS,
                new WeightedMap.Int<>(Map.of(
                        new ReplaceInstance(Blocks.STONE_BRICKS.defaultBlockState()),2,
                        new ReplaceInstance(Blocks.MOSSY_STONE_BRICKS.defaultBlockState()),1,
                        new ReplaceInstance(Blocks.CRACKED_STONE_BRICKS.defaultBlockState()),1)),
                Blocks.STONE_BRICK_SLAB,
                new WeightedMap.Int<>(Map.of(
                        new ReplaceInstance(Blocks.STONE_BRICK_SLAB.defaultBlockState()),3,
                        new ReplaceInstance(Blocks.MOSSY_STONE_BRICK_SLAB.defaultBlockState()),1)),
                Blocks.STONE_BRICK_STAIRS,
                new WeightedMap.Int<>(Map.of(
                        new ReplaceInstance(Blocks.STONE_BRICK_STAIRS.defaultBlockState()),3,
                        new ReplaceInstance(Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState()),1)),
                Blocks.STONE_BRICK_WALL,
                new WeightedMap.Int<>(Map.of(
                        new ReplaceInstance(Blocks.STONE_BRICK_WALL.defaultBlockState()),3,
                        new ReplaceInstance(Blocks.MOSSY_STONE_BRICK_WALL.defaultBlockState()),1))
        );
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return ModProcessors.STONE_STATUE.get();
    }
}
