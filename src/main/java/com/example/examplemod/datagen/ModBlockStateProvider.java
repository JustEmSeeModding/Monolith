package com.example.examplemod.datagen;


import com.example.examplemod.ExampleMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public final class ModBlockStateProvider extends BlockStateProvider {

    ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExampleMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(ModBlocks.DUNGEON_PORTAL_F, TheDungeon.defaultResourceLocation("block/dungeon_portal"));
        //blockWithItem(ModBlocks.DUNGEON_PORTAL_UNSTABLE);

        //semiTransparentBlockWithItem(ModBlocks.INFUSED_GLASS);

    }

    private void crossBlockTest(DeferredBlock<?> deferredBlock, String modelName, String textureName) {
        simpleBlockWithItem(deferredBlock.get(), models().cross(modelName, ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "block/" + textureName)).renderType("cutout"));
    }

    private void crossBlock(DeferredBlock<?> deferredBlock, String modelName, String textureName) {
        simpleBlock(deferredBlock.get(), models().cross(modelName, ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "block/" + textureName)).renderType("cutout"));
    }

    private void semiTransparentBlockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), models().cubeAll(deferredBlock.getId().getPath(), ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "block/" + deferredBlock.getId().getPath())).renderType("translucent"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock, ResourceLocation texture) {
        simpleBlockWithItem(deferredBlock.get(), this.models().cubeAll(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), texture));
    }

    private void blockWithItemCopyFromOtherBlock(DeferredBlock<?> deferredBlock, DeferredBlock<?> copyDeferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(copyDeferredBlock.get()));
    }
}
