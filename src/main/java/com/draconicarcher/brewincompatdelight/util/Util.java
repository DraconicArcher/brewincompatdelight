package com.draconicarcher.brewincompatdelight.util;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Util {

    public static final String EMPTY_STR = "";

    // ResourceLocation creation methods
    public static ResourceLocation rl(@NotNull String modid, @NotNull String path) {
        return new ResourceLocation(modid, path);
    }

    public static ResourceLocation rl(@NotNull String separated) {
        return new ResourceLocation(separated);
    }

    public static ResourceLocation rl(ItemLike itemLike) {
        if (itemLike instanceof Item item) {
            IForgeRegistry<Item> reg = ForgeRegistries.ITEMS;
            if (reg.containsValue(item)) return reg.getKey(item);
        } else if (itemLike instanceof Block block) {
            IForgeRegistry<Block> reg = ForgeRegistries.BLOCKS;
            if (reg.containsValue(block)) return reg.getKey(block);
        }
        return rl(EMPTY_STR, EMPTY_STR);
    }

    public static ResourceLocation brewincompatdelight(String path) {
        return rl(Brewincompatdelight.MODID, path);
    }





    // Add an item stack to a list
    public static ObjectArrayList<ItemStack> with(ObjectArrayList<ItemStack> before, ItemStack addition) {
        before.add(addition);
        return before.clone();
    }

    // Add an item with a specific count to a list
    public static ObjectArrayList<ItemStack> with(ObjectArrayList<ItemStack> before, Item addition, int count) {
        return (count < 1) ? before : with(before, new ItemStack(addition, count));
    }

    // Add an item with a random count within a specified range to a list
    public static ObjectArrayList<ItemStack> with(ObjectArrayList<ItemStack> before, Item addition, RandomSource rand, int min, int max) {
        if (max < min) {
            return before;
        }
        return with(before, addition, (max == min) ? min : rand.nextIntBetweenInclusive(min, max));
    }



    // Get item by resource location
    @Nullable
    public static Item item(ResourceLocation rl) {
        return ForgeRegistries.ITEMS.getValue(rl);
    }

    // Get item by mod id and path
    @Nullable
    public static Item item(String id, String path) {
        return item(rl(id, path));
    }

    // Get block by mod id and path
    @Nullable
    public static Block block(String id, String path) {
        return block(rl(id, path));
    }

    // Get block by resource location
    @Nullable
    public static Block block(ResourceLocation rl) {
        return ForgeRegistries.BLOCKS.getValue(rl);
    }



}
