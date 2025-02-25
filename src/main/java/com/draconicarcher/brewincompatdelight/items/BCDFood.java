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
import umpaz.farmersrespite.common.registry.FREffects; // Removed import to prevent direct access
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.function.Supplier;

public class BCDFood {
    public static final FoodProperties MOONSHINE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 1);
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

    public static final FoodProperties HALF_AND_HALF = createConditionalFood(
            (new Builder())
                    .effect(() -> ModList.get().isLoaded("farmersrespite") ? new MobEffectInstance(FREffects.CAFFEINATED.get(), 600, 0) : new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 600, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0F)
                    .alwaysEat(),
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
                    .alwaysEat(),
            "fruitsdelight"
    );
    public static final FoodProperties TEQUILA = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 3600, 1);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 2400, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties NUT_BROWN_ALE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0);
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
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties RUM = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 1);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties MOJITO = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.CORROSION.get(), 300, 0) : new MobEffectInstance(MobEffects.POISON, 300, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION.get(), 900, 0), 1.0F)
                    .alwaysEat(),
            "collectorsreap"
    );

    public static final FoodProperties PINA_COLADA = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 900, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties HARD_LEMONADE = (new Builder()).effect(() -> {
        return new MobEffectInstance(BnCEffects.TIPSY.get(), 2400, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(BnCEffects.INTOXICATION.get(), 1800, 0);
    }, 1.0F).alwaysEat().build();

    public static final FoodProperties LEMON_LIME = createConditionalFood(
            (new Builder()).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0F)
                    .effect(() -> ModList.get().isLoaded("collectorsreap") ? new MobEffectInstance(CREffects.CORROSION.get(), 1200, 0) : new MobEffectInstance(MobEffects.POISON, 1200, 0), 1.0F)
                    .alwaysEat(),
            "collectorsreap"
    );

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