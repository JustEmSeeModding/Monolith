package com.example.examplemod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;

import java.util.stream.Stream;

public class ModEntityLootProvider extends EntityLootSubProvider {
    protected ModEntityLootProvider(HolderLookup.Provider registries) {
        super(FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    public void generate() {
        /*this.add(ModEntities.CAVE_GOBLIN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem
                                        .lootTableItem(ModItems.GOBLIN_MEAT)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 3.0f)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f)))))
        );
        this.add(ModEntities.SHADOW_GOBLIN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem
                                        .lootTableItem(ModItems.GOBLIN_MEAT)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 3.0f)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f)))))
        );
        this.add(ModEntities.HOB_GOBLIN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem
                                        .lootTableItem(ModItems.GOBLIN_MEAT)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 3.0f)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem
                                        .lootTableItem(ModItems.RAW_KOBALT)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f))))
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.05f, 0.02f)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem
                                        .lootTableItem(Items.RAW_IRON)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f))))
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.25f, 0.05f)))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem
                                        .lootTableItem(ModItems.PYRITE)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f))))
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.25f, 0.05f)))
        );
        this.add(ModEntities.SKELETON_KNIGHT.get(), LootTable.lootTable());
        this.add(ModEntities.DEATH_KNIGHT.get(), LootTable.lootTable());
        */
    }

    /*@Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return ModEntities.ENTITY_TYPES.getEntries().stream().map(Holder::value);
    }*/
}
