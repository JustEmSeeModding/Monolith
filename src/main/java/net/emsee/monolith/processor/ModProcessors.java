package net.emsee.monolith.processor;

import net.emsee.monolith.Monolith;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModProcessors {
    public static final DeferredRegister<StructureProcessorType<?>> PROCESSORS =
            DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, Monolith.MOD_ID);

    public static final Supplier<StructureProcessorType<StoneProcessor>> STONE_STATUE =
            PROCESSORS.register(
                    "stone_statue",
                    () -> () -> StoneProcessor.CODEC
            );

    public static final Supplier<StructureProcessorType<StoneProcessor>> COPPER_STATUE_FROM_STONE =
            PROCESSORS.register(
                    "stone_to_copper_statue",
                    () -> () -> StoneProcessor.CODEC
            );

    public static final Supplier<StructureProcessorType<StoneProcessor>> SAND_STATUE_FROM_STONE =
            PROCESSORS.register(
                    "sand_to_copper_statue",
                    () -> () -> StoneProcessor.CODEC
            );

    public static void register(IEventBus eventBus) {
        PROCESSORS.register(eventBus);
    }
}
