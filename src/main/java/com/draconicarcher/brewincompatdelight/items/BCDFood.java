package com.draconicarcher.brewincompatdelight.items;

import com.draconicarcher.brewincompatdelight.registries.BCDModEffects;
import dev.xkmc.fruitsdelight.init.registrate.FDEffects;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraftforge.fml.ModList;
import umpaz.brewinandchewin.common.registry.BnCEffects;
import umpaz.farmersrespite.common.registry.FREffects;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.function.Supplier;

public class BCDFood {
    public static final FoodProperties MOONSHINE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 1);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 3000, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties WHISKEY = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 1);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 3000, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties WHITE_WINE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BCDModEffects.ARROW_LOOTING.get(), 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties RED_WINE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BCDModEffects.ARROW_LOOTING.get(), 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.LUCK, 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties SWEET_RED_WINE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.SWEET_HEART.get(), 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BCDModEffects.PROJECTILE_DAMAGE.get(), 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties BOILERMAKER = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 4000, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 3600, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties CRANBERRY_JUICE = (new Builder()).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0);
    }, 1.0F).nutrition(2).saturationMod(1).build();

    public static final FoodProperties HALF_AND_HALF = createConditionalFood(
            (new Builder())
                    .effect(() -> ModList.get().isLoaded("farmersrespite") ? new MobEffectInstance(FREffects.CAFFEINATED.get(), 600, 0) : new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0), 1.0F)
                    .nutrition(3).saturationMod(1).alwaysEat(),
            "farmersdelight"
    );

    public static final FoodProperties BLACK_RUSSIAN = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("farmersrespite") ? new MobEffectInstance(FREffects.CAFFEINATED.get(), 6000, 0) : new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
                    .alwaysEat()
    );
    public static final FoodProperties WHITE_RUSSIAN = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("farmersrespite") ? new MobEffectInstance(FREffects.CAFFEINATED.get(), 6000, 0) : new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 600, 0), 1.0F)
                    .alwaysEat()
    );
    public static final FoodProperties SCREWDRIVER = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("fruitsdelight") ? new MobEffectInstance(FDEffects.LEAF_PIERCING.get(), 600, 0) : new MobEffectInstance(MobEffects.LUCK, 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
                    .nutrition(2).saturationMod(1).alwaysEat(),
            "fruitsdelight"
    );
    public static final FoodProperties JOHNNY_SILVERHAND = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("fruitsdelight") ? new MobEffectInstance(FDEffects.LEAF_PIERCING.get(), 600, 0) : new MobEffectInstance(MobEffects.LUCK, 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0F)
                    .nutrition(2).saturationMod(1).alwaysEat(),
            "fruitsdelight"
    );
    public static final FoodProperties TEQUILA = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 1);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties MEDINA = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 1);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BCDModEffects.HURRICANE.get(), 2400, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties NUT_BROWN_ALE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 600, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties MULLED_WINE = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BCDModEffects.ARROW_LOOTING.get(), 1200, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BCDModEffects.PROJECTILE_DAMAGE.get(), 1200, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
                    .alwaysEat()
    );

    public static final FoodProperties PEACH_WINE = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 1800, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("fruitsdelight") ? new MobEffectInstance(FDEffects.HEAL_AURA.get(), 1200, 0) : new MobEffectInstance(MobEffects.REGENERATION, 1200, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BCDModEffects.ARROW_LOOTING.get(), 1200, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0), 1.0F)
                    .alwaysEat()
    );

    public static final FoodProperties HARD_CIDER = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.ABSORPTION, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 900, 0);
    }, 1.0F).nutrition(2).saturationMod(1).alwaysEat().build();

    public static final FoodProperties TEQUILA_SUNRISE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.REGENERATION, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0);
    }, 1.0F).nutrition(2).saturationMod(1).alwaysEat().build();


    public static final FoodProperties RUM = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1800, 1);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties KRAKEN_RUM = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 1);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties MOJITO = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.CORROSION.get(), 300, 0) : new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 900, 0), 1.0F)
                    .alwaysEat(),
            "collectorsreap"
    );

    public static final FoodProperties MARGARITA = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.CORROSION.get(), 1200, 0) : new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3200, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0), 1.0F)
                    .nutrition(2).saturationMod(1).alwaysEat(),
            "collectorsreap"
    );

    public static final FoodProperties SALTED_MARGARITA = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.CORROSION.get(), 1800, 0) : new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3200, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0), 1.0F)
                    .nutrition(2).saturationMod(1).alwaysEat(),
            "collectorsreap"
    );

    public static final FoodProperties PINA_COLADA = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 900, 0);
    }, 1.0F).nutrition(2).saturationMod(1).alwaysEat().build();

    public static final FoodProperties GIN = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 1);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BCDModEffects.EXP_BOOST.get(), 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties GIN_AND_TONIC = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 800, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BCDModEffects.EXP_BOOST.get(), 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties GIN_AND_JUICE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 800, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BCDModEffects.EXP_BOOST.get(), 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.REGENERATION, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties VODKA_TONIC = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 800, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties BLUE_CURACAO = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 800, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BCDModEffects.HURRICANE.get(), 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties HOT_TODDY = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 100, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties MULLED_CIDER = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1800, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.ABSORPTION, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0);
    }, 1.0F).nutrition(2).saturationMod(1).alwaysEat().build();

    public static final FoodProperties MINT_JULEP = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1800, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties BLACK_CUBAN = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1800, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 800, 0);
    }, 1.0F).alwaysEat().build();


    public static final FoodProperties WHISKEY_SOUR = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 800, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0);
    }, 1.0F).nutrition(2).saturationMod(1).alwaysEat().build();

    public static final FoodProperties BEES_KNEES = (new Builder()).effect(() -> {
        return new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0);
    }, 1.0F).nutrition(2).saturationMod(1).alwaysEat().build();

    public static final FoodProperties BRASS_MONKEY = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 800, 2);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.REGENERATION, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0);
    }, 1.0F).nutrition(2).saturationMod(1).alwaysEat().build();

    public static final FoodProperties MERMAID_LEMONADE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 800, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BCDModEffects.HURRICANE.get(), 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1200, 0);
    }, 1.0F).nutrition(2).saturationMod(1).alwaysEat().build();

    public static final FoodProperties CHINA_BLUE = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0) : new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3200, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BCDModEffects.HURRICANE.get(), 2400, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 2), 1.0F)

                    .nutrition(2).saturationMod(1).alwaysEat(),
            "collectorsreap"
    );

    public static final FoodProperties AQUA_VELVA = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0) : new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.CORROSION.get(), 600, 0) : new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BCDModEffects.EXP_BOOST.get(), 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0F)
                    .nutrition(2).saturationMod(1).alwaysEat(),
            "collectorsreap"
    );

    public static final FoodProperties GIMLET = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.CORROSION.get(), 600, 0) : new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BCDModEffects.EXP_BOOST.get(), 600, 0), 1.0F)
                    .nutrition(2).saturationMod(1).alwaysEat(),
            "collectorsreap"
    );

    public static final FoodProperties SINGAPORE_SLING = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 1800, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.VOLATILITY.get(), 600, 0) : new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.CORROSION.get(), 600, 0) : new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BCDModEffects.HURRICANE.get(), 2400, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1.0F)
                    .nutrition(2).saturationMod(1).alwaysEat(),
            "collectorsreap"
    );


    public static final FoodProperties HARD_LEMONADE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0);
    }, 1.0F).nutrition(2).saturationMod(1).alwaysEat().build();

    public static final FoodProperties LEMON_LIME = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.CORROSION.get(), 1200, 0) : new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1.0F)
                    .nutrition(3).saturationMod(1).alwaysEat(),
            "collectorsreap"
    );
    public static final FoodProperties JUNIPER_BERRIES = (new Builder()).nutrition(1).saturationMod(1).build();

    public static final FoodProperties RED_GRAPES = (new Builder()).nutrition(1).saturationMod(1).build();

    public static final FoodProperties WHITE_GRAPES = (new Builder()).nutrition(1).saturationMod(1).build();



    private static FoodProperties createConditionalFood(Builder builder, String... modids) {
        return new ConditionalFoodPropertiesBuilder(builder, modids).build();
    }

    private static class ConditionalFoodPropertiesBuilder {
        private final Builder builder;
        private final String[] modids;

        public ConditionalFoodPropertiesBuilder(Builder builder, String... modids) {
            this.builder = builder;
            this.modids = modids;
        }

        public Builder effect(Supplier<MobEffectInstance> effectSupplier, float probability) {
            boolean shouldApply = true;
            for (String modid : modids) {
                if (!ModList.get().isLoaded(modid)) {
                    shouldApply = false;
                    break;
                }
            }
            if (shouldApply) {
                this.builder.effect(effectSupplier, probability);
            }
            return this.builder;
        }

        public FoodProperties build() {
            return builder.alwaysEat().build();
        }
    }

    public static void initialize() {
    }}