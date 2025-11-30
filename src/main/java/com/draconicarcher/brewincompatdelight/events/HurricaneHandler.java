package com.draconicarcher.brewincompatdelight.events;

import com.draconicarcher.brewincompatdelight.registries.BCDModEffects;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.Level;

public class HurricaneHandler {

    public HurricaneHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            // Check if player has the Hurricane effect
            MobEffectInstance effectInstance = player.getEffect(BCDModEffects.HURRICANE.get());
            if (effectInstance != null) {
                Level world = player.level();
                int level = effectInstance.getAmplifier() + 1; // Effect level (I = 1, II = 2, etc.)

                // Base increase: 5% per level
                float multiplier = 1.05f + (level - 1) * 0.05f;

                // Increase bonus in rain and thunderstorms
                if (world.isRaining()) {
                    multiplier = 1.10f + (level - 1) * 0.10f; // 10% per level in rain
                }
                if (world.isThundering()) {
                    multiplier = 1.25f + (level - 1) * 0.25f; // 25% per level in thunderstorms
                }

                // Apply damage boost
                float newDamage = event.getAmount() * multiplier;
                event.setAmount(newDamage);
            }
        }
    }
}
