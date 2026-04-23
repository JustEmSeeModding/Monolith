package com.example.examplemod.datagen;

import com.example.examplemod.ExampleMod;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public final class ModItemModelProvider extends ItemModelProvider {
    ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //basicItem(ModItems.PORTAL_CORE.asItem());=
        //basicBlockItemOtherTexturePath(ModBlocks.INFUSED_THREAD, "thedungeon", "item/infused_thread");
        //basicItemOtherTexturePath(ModItems.DUNGEON_DEBUG_TOOL, "minecraft", "item/stick");

        //withExistingParent(ModItems.INFUSED_DAGGER.getId().getPath(), TheDungeon.defaultResourceLocation("item/dagger")).texture("0", TheDungeon.defaultResourceLocation("item/infused_dagger"));

        //withExistingParent(ModBlocks.INFUSED_GRASS_BLOCK.getId().getPath(), TheDungeon.defaultResourceLocation("block/infused_grass_block"));

        //withExistingParent(ModSpawnEggs.DEATH_KNIGHT_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

    }

    private void basicSingleTextureBlockItem(DeferredBlock<?> block) {
        withExistingParent(block.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath(ResourceLocation.DEFAULT_NAMESPACE, "item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, "block/" + block.getId().getPath()));
    }

    private void basicBlockItemOtherTexturePath(DeferredBlock<?> block, String TextureNamespace, String TexturePath) {
        withExistingParent(block.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath(ResourceLocation.DEFAULT_NAMESPACE, "item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TextureNamespace, TexturePath));
    }

    private void basicItemOtherTexturePath(DeferredItem<?> item, String TextureNamespace, String TexturePath) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath(ResourceLocation.DEFAULT_NAMESPACE, "item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TextureNamespace, TexturePath));
    }
}
