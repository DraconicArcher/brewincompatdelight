package com.draconicarcher.brewincompatdelight.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import com.mojang.datafixers.util.Pair;

import java.util.List;

public class TooltipUtil {

    public static void appendDrinkTooltip(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        if (stack.getItem().getFoodProperties() != null) {
            for (Pair<MobEffectInstance, Float> effectEntry : stack.getItem().getFoodProperties().getEffects()) {
                MobEffectInstance effectInstance = effectEntry.getFirst();
                Component effectName = effectInstance.getEffect().getDisplayName();

                // Format duration in minutes
                int durationSeconds = effectInstance.getDuration() / 20;
                int durationMinutes = durationSeconds / 60;
                int remainingSeconds = durationSeconds % 60;
                String durationString = String.format("%d:%02d", durationMinutes, remainingSeconds); // Format as MM:SS

                Component effectDuration = Component.literal(" (" + durationString + ")");

                // Color based on effect type
                Component effectLine = Component.literal(""); // Start with an empty line
                if (effectInstance.getEffect().isBeneficial()) {
                    effectLine = effectName.copy().withStyle(ChatFormatting.BLUE); // Beneficial in blue
                } else {
                    effectLine = effectName.copy().withStyle(ChatFormatting.RED); // Harmful in red
                }
                effectLine = effectLine.copy().append(effectDuration); // Corrected Append

                tooltip.add(Component.translatable("effect.brewincompatdelight.tooltip", effectLine)); // Use the formatted line
            }
        }
    }
}