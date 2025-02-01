package com.draconicarcher.brewincompatdelight.items;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class BCDFood {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Brewincompatdelight.MODID);

    public static final FoodProperties MOONSHINE = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance((MobEffect) MobEffects.DAMAGE_BOOST, 3600, 1);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance((MobEffect) MobEffects.MOVEMENT_SPEED, 3000, 0);
    }, 1.0F).alwaysEat().build();
}
