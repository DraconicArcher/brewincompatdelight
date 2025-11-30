package com.draconicarcher.brewincompatdelight.registries;

import com.draconicarcher.brewincompatdelight.registries.BCDModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class BCDEffectRegistry {
    public static void applyArrowLootingEffect(LivingEntity entity) {
        if (BCDModEffects.ARROW_LOOTING.isPresent()) {
            MobEffectInstance effectInstance = new MobEffectInstance(BCDModEffects.ARROW_LOOTING.get(), 200, 1);
            entity.addEffect(effectInstance);
        } else {
            // Handle the case where the effect is not present
            System.out.println("Arrow looting effect is not present!");
        }
    }

    public static void applyProjectileDamageEffect(LivingEntity entity) {
        if (BCDModEffects.PROJECTILE_DAMAGE.isPresent()) {
            MobEffectInstance effectInstance = new MobEffectInstance(BCDModEffects.PROJECTILE_DAMAGE.get(), 200, 1);
            entity.addEffect(effectInstance);
        } else {
            // Handle the case where the effect is not present
            System.out.println("Overdraw effect is not present!");
        }
    }

    public static void applyExpBoostEffect(LivingEntity entity) {
        if (BCDModEffects.EXP_BOOST.isPresent()) {
            MobEffectInstance effectInstance = new MobEffectInstance(BCDModEffects.EXP_BOOST.get(), 200, 1);
            entity.addEffect(effectInstance);
        } else {
            // Handle the case where the effect is not present
            System.out.println("Wisdom effect is not present!");
        }
    }

    public static void applyHurricaneEffect(LivingEntity entity) {
        if (BCDModEffects.HURRICANE.isPresent()) {
            MobEffectInstance effectInstance = new MobEffectInstance(BCDModEffects.HURRICANE.get(), 200, 1);
            entity.addEffect(effectInstance);
        } else {
            // Handle the case where the effect is not present
            System.out.println("Hurricane effect is not present!");
        }
    }
}
