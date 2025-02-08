package com.draconicarcher.brewincompatdelight.items;

import com.draconicarcher.brewincompatdelight.util.TooltipUtil;
import com.mojang.datafixers.util.Pair;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.List;

public class BCDDrinkableItem extends DrinkableItem {

    public BCDDrinkableItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide && entity instanceof Player && stack.getItem() != Items.GLASS_BOTTLE) {
            ItemStack glassBottle = new ItemStack(Items.GLASS_BOTTLE);
            Player player = (Player) entity;

            if (!player.getInventory().add(glassBottle)) {
                entity.spawnAtLocation(glassBottle);
            }
        }
        return result;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag); // KEEP THIS LINE

        TooltipUtil.appendDrinkTooltip(stack, level, tooltip, flag); // Correct call to the static method
    }
}
