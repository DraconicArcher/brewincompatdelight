package com.draconicarcher.brewincompatdelight.events;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import com.draconicarcher.brewincompatdelight.registries.BCDModEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Brewincompatdelight.MODID)
public class ArrowLootingHandler {

    // Define a tag for ranged weapons
    private static final TagKey<Item> RANGED_WEAPONS_TAG = ItemTags.create(new ResourceLocation("brewincompatdelight", "ranged_weapons"));

    @SubscribeEvent
    public static void onArrowSpawn(EntityJoinLevelEvent event) {
        // Check if the entity is an arrow
        if (event.getEntity() instanceof AbstractArrow arrow) {
            // Check if the shooter is a player
            Entity shooter = arrow.getOwner();
            if (shooter instanceof Player player) {
                // Check if the player has the Arrow Looting effect
                if (player.hasEffect(BCDModEffects.ARROW_LOOTING.get())) {
                    int effectLevel = player.getEffect(BCDModEffects.ARROW_LOOTING.get()).getAmplifier() + 1;

                    // Store the looting level in the arrow's NBT data
                    arrow.getPersistentData().putInt("ArrowLootingLevel", effectLevel);

                    // Calculate durability loss scaling with effect level
                    int durabilityLoss = 2 * effectLevel;

                    // Reduce the durability of the weapon
                    damageWeapon(player, durabilityLoss);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLootingLevel(LootingLevelEvent event) {
        // Check if the damage source is from an arrow
        if (event.getDamageSource().getDirectEntity() instanceof AbstractArrow arrow) {
            // Get the stored looting level from the arrow
            int lootingLevel = arrow.getPersistentData().getInt("ArrowLootingLevel");

            // Apply the looting level if it exists
            if (lootingLevel > 0) {
                // Set the event's looting level
                event.setLootingLevel(event.getLootingLevel() + lootingLevel);
            }
        }
    }

    // Helper method to reduce weapon durability
    private static void damageWeapon(Player player, int damageAmount) {
        ItemStack weapon = player.getUseItem();

        // Check if the weapon is a ranged weapon
        if (isRangedWeapon(weapon.getItem())) {
            weapon.hurtAndBreak(damageAmount, player, (entity) -> {
                entity.broadcastBreakEvent(player.getUsedItemHand());
            });
        } else {
            // If not currently using (pulling back) the weapon, check main and off-hand
            weapon = player.getMainHandItem();
            if (isRangedWeapon(weapon.getItem())) {
                weapon.hurtAndBreak(damageAmount, player, (entity) -> {
                    entity.broadcastBreakEvent(player.getUsedItemHand());
                });
            } else {
                weapon = player.getOffhandItem();
                if (isRangedWeapon(weapon.getItem())) {
                    weapon.hurtAndBreak(damageAmount, player, (entity) -> {
                        entity.broadcastBreakEvent(player.getUsedItemHand());
                    });
                }
            }
        }
    }

    // Method to check if an item is a ranged weapon
    private static boolean isRangedWeapon(Item item) {
        return item instanceof ProjectileWeaponItem;
    }
}