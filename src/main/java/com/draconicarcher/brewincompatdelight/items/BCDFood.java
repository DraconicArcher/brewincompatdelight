package com.draconicarcher.brewincompatdelight.items;

import com.draconicarcher.brewincompatdelight.registries.BCDModEffects;
import dev.xkmc.fruitsdelight.init.registrate.FDEffects;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import umpaz.brewinandchewin.common.registry.BnCEffects;
import umpaz.farmersrespite.common.registry.FREffects;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class BCDFood {

    // No DeferredRegister needed here for FoodProperties

    public static final FoodProperties MOONSHINE = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 1), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 3000, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties WHITE_WINE = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BCDModEffects.ARROW_LOOTING.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties RED_WINE = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BCDModEffects.ARROW_LOOTING.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties SWEET_RED_WINE = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.SWEET_HEART.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BCDModEffects.PROJECTILE_DAMAGE.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties HALF_AND_HALF = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(FREffects.CAFFEINATED.get(), 600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 600, 0), 1.0F) // Correct usage
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties BLACK_RUSSIAN = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(FREffects.CAFFEINATED.get(), 6000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties WHITE_RUSSIAN = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(FREffects.CAFFEINATED.get(), 6000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 600, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties SCREWDRIVER = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(FDEffects.LEAF_PIERCING.get(), 600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties TEQUILA = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 1), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties NUT_BROWN_ALE = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 600, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties MULLED_WINE = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BCDModEffects.ARROW_LOOTING.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BCDModEffects.PROJECTILE_DAMAGE.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties PEACH_WINE = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 1800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(FDEffects.HEAL_AURA.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties HARD_CIDER = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 900, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties HARD_LEMONADE = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
            .alwaysEat().build();

    public static final FoodProperties LEMON_LIME = (new FoodProperties.Builder())
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F)
            .effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 1200, 0), 1.0F)
            .alwaysEat().build();

    public static void initialize() {
        // No action needed here. FoodProperties are initialized when they are declared.
    }
}