package com.draconicarcher.brewincompatdelight.items;

import com.draconicarcher.brewincompatdelight.util.TooltipUtil;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import javax.annotation.Nullable;
import java.util.List;

public class BCDDrinkableItemT extends DrinkableItem {

    public BCDDrinkableItemT(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide && entity instanceof Player) {
            Item returnItem = null;

            if (ModList.get().isLoaded("brewinandchewin")) {
                Item tankard = BnCItems.TANKARD.get();
                if (tankard != null) {
                    returnItem = tankard;
                }
            }

            if (returnItem == null) {
                returnItem = Items.GLASS_BOTTLE;
            }

            ItemStack returnStack = new ItemStack(returnItem);
            Player player = (Player) entity;

            if (!player.getInventory().add(returnStack)) {
                entity.spawnAtLocation(returnStack);
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
