package com.example.examplemod.datagen;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public final class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {

    }

    private static void smithing(ItemLike template, ItemLike item, ItemLike ingredient, Item resultItem, RecipeCategory category, RecipeOutput recipeOutput) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(item), Ingredient.of(ingredient), category, resultItem)
                .unlocks("has_"+getItemName(ingredient), has(ingredient)).save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID,getItemName(resultItem) + "_smithing"));

    }

    private static void oreSmeltingAndBlasting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, int blastingTime, String group) {
        oreSmelting(recipeOutput, ingredients, category, result, experience, cookingTime, group);
        oreBlasting(recipeOutput, ingredients, category, result, experience, blastingTime, group);
    }

    private static void oreSmeltingAndSmoking(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, int smokingTime, String group) {
        oreSmelting(recipeOutput, ingredients, category, result, experience, cookingTime, group);
        oreSmoking(recipeOutput, ingredients, category, result, experience, smokingTime, group);
    }

    private static void oreSmeltingAndSmokingAndCampfire(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, int smokingTime, int campfireTime, String group) {
        oreSmelting(recipeOutput, ingredients, category, result, experience, cookingTime, group);
        oreSmoking(recipeOutput, ingredients, category, result, experience, smokingTime, group);
        oreCampfire(recipeOutput, ingredients, category, result, experience, campfireTime, group);
    }

    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    private static void oreCampfire(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_campfire");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(@NotNull RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.@NotNull Factory<T> factory, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup, String pRecipeName) {
        for (ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, ExampleMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }

    private static void simpleArmor(ItemLike ingredient, ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots, RecipeOutput recipeOutput) {
        if (helmet != null)
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet, 1)
                    .pattern("###")
                    .pattern("# #")
                    .define('#', ingredient)
                    .unlockedBy("has_"+getItemName(ingredient), has(ingredient)).save(recipeOutput);
        if (chestplate != null)
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate, 1)
                    .pattern("# #")
                    .pattern("###")
                    .pattern("###")
                    .define('#', ingredient)
                    .unlockedBy("has_"+getItemName(ingredient), has(ingredient)).save(recipeOutput);
        if (leggings != null)
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings, 1)
                    .pattern("###")
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ingredient)
                    .unlockedBy("has_"+getItemName(ingredient), has(ingredient)).save(recipeOutput);
        if (boots != null)
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots, 1)
                    .pattern("# #")
                    .pattern("# #")
                    .define('#', ingredient)
                    .unlockedBy("has_"+getItemName(ingredient), has(ingredient)).save(recipeOutput);
    }
}
