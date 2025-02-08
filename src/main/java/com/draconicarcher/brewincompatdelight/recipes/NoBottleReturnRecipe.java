package com.draconicarcher.brewincompatdelight.recipes;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NoBottleReturnRecipe implements Recipe<net.minecraft.world.inventory.CraftingContainer> {
    private final ResourceLocation id;
    private final String group;
    private final ItemStack result;
    private final NonNullList<Ingredient> ingredients;

    public NoBottleReturnRecipe(ResourceLocation id, String group, ItemStack result, NonNullList<Ingredient> ingredients) {
        this.id = id;
        this.group = group;
        this.result = result;
        this.ingredients = ingredients;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Brewincompatdelight.getNoBottleReturnRecipeSerializer(); // Use a static method to get the serializer
    }

    @Override
    public RecipeType<?> getType() {
        return Brewincompatdelight.getNoBottleReturnRecipeType(); // Use a static method to get the recipe type
    }

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return result.copy(); // Important: Return a copy!
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public boolean matches(net.minecraft.world.inventory.CraftingContainer inv, net.minecraft.world.level.Level level) {
        java.util.List<ItemStack> items = new java.util.ArrayList<>();
        for (int i = 0; i < inv.getContainerSize(); ++i) {
            ItemStack itemstack = inv.getItem(i);
            if (!itemstack.isEmpty()) {
                items.add(itemstack);
            }
        }

        if (items.isEmpty()) {
            return false;
        } else {
            java.util.List<Ingredient> ingredients = this.getIngredients();
            java.util.List<Ingredient> ingredientsCopy = new java.util.ArrayList<>(ingredients); // Create a mutable copy

            for (ItemStack item : items) {
                boolean foundMatch = false;
                for (int j = 0; j < ingredientsCopy.size(); j++) {
                    Ingredient ingredient = ingredientsCopy.get(j);
                    if (ingredient.test(item)) {
                        ingredientsCopy.remove(j);
                        foundMatch = true;
                        break;
                    }
                }
                if (!foundMatch) {
                    return false;
                }
            }
            return ingredientsCopy.isEmpty(); // All ingredients matched
        }
    }

    @Override
    public ItemStack assemble(net.minecraft.world.inventory.CraftingContainer inv, RegistryAccess registryAccess) {
        return getResultItem(registryAccess);
    }

    @Override
    public boolean isSpecial() {
        return true; // This is what prevents the bottle return
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.getIngredients().size(); // Adjust as needed
    }

    public static class Serializer implements RecipeSerializer<NoBottleReturnRecipe> {

        @Override
        public NoBottleReturnRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");

            NonNullList<Ingredient> ingredients = NonNullList.create();
            JsonArray ingredientsJson = GsonHelper.getAsJsonArray(json, "ingredients");
            for (JsonElement ingredient : ingredientsJson) {
                Ingredient parsedIngredient = Ingredient.fromJson(ingredient);
                ingredients.add(parsedIngredient);
            }

            ItemStack result = net.minecraft.world.item.crafting.ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));

            return new NoBottleReturnRecipe(recipeId, group, result, ingredients);
        }

        @Override
        public NoBottleReturnRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String group = buffer.readUtf();

            NonNullList<Ingredient> ingredients = NonNullList.create();
            int ingredientCount = buffer.readVarInt();
            for (int i = 0; i < ingredientCount; i++) {
                ingredients.add(Ingredient.fromNetwork(buffer));
            }

            ItemStack result = buffer.readItem();

            return new NoBottleReturnRecipe(recipeId, group, result, ingredients);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, NoBottleReturnRecipe recipe) {
            buffer.writeUtf(recipe.getGroup());

            buffer.writeVarInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeItem(recipe.getResultItem(net.minecraft.core.RegistryAccess.EMPTY)); // Provide an EMPTY RegistryAccess
        }
    }
}
