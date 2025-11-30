package com.draconicarcher.brewincompatdelight.events;

import com.draconicarcher.brewincompatdelight.registries.BCDModEffects;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;

public class ExpBoostHandler {

    public ExpBoostHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onXpPickup(PlayerXpEvent.PickupXp event) {
        Player player = event.getEntity();
        ExperienceOrb xpOrb = event.getOrb(); // Get the XP orb

        // Check if the player has the effect
        MobEffectInstance effectInstance = player.getEffect(BCDModEffects.EXP_BOOST.get());
        if (effectInstance != null) {
            int level = effectInstance.getAmplifier() + 1; // Level 1 = Wisdom I, Level 2 = Wisdom II, etc.

            // Calculate bonus XP (20% per level)
            int baseExp = xpOrb.getValue();
            int bonusExp = (int) (baseExp * (0.2 * level)); // Scales with level

            // Apply bonus XP
            player.giveExperiencePoints(bonusExp);
        }
    }
}
