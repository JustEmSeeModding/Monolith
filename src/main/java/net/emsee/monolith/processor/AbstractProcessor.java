package net.emsee.monolith.processor;


import net.emsee.monolith.WeightedMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractProcessor extends StructureProcessor {

    @Override
    public StructureTemplate.StructureBlockInfo process(@NotNull LevelReader level, @NotNull BlockPos offset, @NotNull BlockPos pos,
                                                        StructureTemplate.@NotNull StructureBlockInfo blockInfo, StructureTemplate.StructureBlockInfo relativeBlockInfo,
                                                        @NotNull StructurePlaceSettings settings, @Nullable StructureTemplate template) {

        if (hasNoReplacementFor(relativeBlockInfo.state().getBlock()))
            return relativeBlockInfo;

        RandomSource random = settings.getRandom(relativeBlockInfo.pos());
        WeightedMap.Int<ReplaceInstance> options = this.getReplacements(level, offset, pos, blockInfo, relativeBlockInfo, settings, template).get(relativeBlockInfo.state().getBlock());

        if (options == null || options.isEmpty() || options.totalWeight() <= 0) return relativeBlockInfo;

        BlockState newBlockstate = options.getRandom(random).newState;
        if (newBlockstate == null) return relativeBlockInfo;

        BlockState oldBlockstate = relativeBlockInfo.state();
        newBlockstate = copyAllProperties(oldBlockstate, newBlockstate);

        return new StructureTemplate.StructureBlockInfo(relativeBlockInfo.pos(), newBlockstate, relativeBlockInfo.nbt());
    }
    private final Map<Block, WeightedMap.Int<ReplaceInstance>> replacements = Util.make(this::createReplacements);

    protected AbstractProcessor() {
        super();
    }



    /**
     * Return a copy of the replacements map filtered to only include ReplaceInstances
     * whose predicates succeed for the provided context. The returned map preserves
     * insertion order and contains new WeightedMap.Int instances so callers may safely
     * mutate the returned structure if desired.
     */
    protected final Map<Block, WeightedMap.Int<ReplaceInstance>> getReplacements(LevelReader level, BlockPos offset, BlockPos pos,
                                                                                 StructureTemplate.StructureBlockInfo blockInfo, StructureTemplate.StructureBlockInfo relativeBlockInfo,
                                                                                 StructurePlaceSettings settings, @Nullable StructureTemplate template) {
        Map<Block, WeightedMap.Int<ReplaceInstance>> filtered = new LinkedHashMap<>();
        for (Map.Entry<Block, WeightedMap.Int<ReplaceInstance>> entry : this.replacements.entrySet()) {
            Block blockKey = entry.getKey();
            WeightedMap.Int<ReplaceInstance> originalList = entry.getValue();
            WeightedMap.Int<ReplaceInstance> copyList = new WeightedMap.Int<>();

            for (Map.Entry<ReplaceInstance, Integer> replaceEntry : originalList.entrySet()) {
                ReplaceInstance instance = replaceEntry.getKey();
                int weight = replaceEntry.getValue();

                // Test the predicate with the provided context
                copyList.put(instance, weight);
            }

            if (!copyList.isEmpty()) {
                filtered.put(blockKey, copyList);
            }
        }

        return filtered;
    }

    protected final Map<Block, WeightedMap.Int<ReplaceInstance>> getRawReplacements() {
        return replacements;
    }

    protected final boolean hasNoReplacementFor(Block block) {
        return !replacements.containsKey(block) || replacements.get(block) == null || replacements.get(block).isEmpty();
    }

    @NotNull
    protected abstract Map<Block, WeightedMap.Int<ReplaceInstance>> createReplacements();

    protected BlockState copyAllProperties(BlockState from, BlockState to) {
        to = copyProperty(from, to, StairBlock.FACING);
        to = copyProperty(from, to, StairBlock.HALF);
        to = copyProperty(from, to, StairBlock.SHAPE);
        to = copyProperty(from, to, SlabBlock.TYPE);
        to = copyProperty(from, to, RotatedPillarBlock.AXIS);
        to = copyProperty(from, to, HorizontalDirectionalBlock.FACING);
        to = copyProperty(from, to, WaterloggedTransparentBlock.WATERLOGGED);
        to = copyProperty(from, to, WallBlock.NORTH_WALL);
        to = copyProperty(from, to, WallBlock.EAST_WALL);
        to = copyProperty(from, to, WallBlock.SOUTH_WALL);
        to = copyProperty(from, to, WallBlock.WEST_WALL);
        to = copyProperty(from, to, WallBlock.UP);
        return to;
    }

    protected <T extends Comparable<T>> BlockState copyProperty(BlockState from, BlockState to, Property<T> property) {
        if (from.hasProperty(property)) {
            return to.trySetValue(property, from.getValue(property));
        }
        return to;
    }

    protected static class ReplaceInstance {
        public final BlockState newState;
        //Predicate<PredicateInfo> predicate = predicateInfo -> true;
        final int separationID;

        public ReplaceInstance(BlockState state) {
            this.newState = state;
            separationID = 0;
        }

        public ReplaceInstance(BlockState state, int separationID) {
            this.newState = state;
            this.separationID = separationID;
        }

        /*public ReplaceInstance withPredicate(Predicate<PredicateInfo> newPredicate) {
            predicate = predicate.and(newPredicate);
            return this;
        }*/

        /*public boolean test(LevelReader level, BlockPos offset, BlockPos pos,
                            StructureTemplate.StructureBlockInfo blockInfo, StructureTemplate.StructureBlockInfo relativeBlockInfo, StructurePlaceSettings settings, @Nullable StructureTemplate template) {
            PredicateInfo pInfo = new PredicateInfo(level, offset, pos, blockInfo, relativeBlockInfo, settings, template);
            return predicate.test(pInfo);
        }*/

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReplaceInstance that = (ReplaceInstance) o;
            return separationID == that.separationID && Objects.equals(newState, that.newState);
        }

        @Override
        public int hashCode() {
            return Objects.hash(newState, separationID);
        }
    }
}
