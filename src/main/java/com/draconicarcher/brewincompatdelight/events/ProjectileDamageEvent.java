package com.draconicarcher.brewincompatdelight.events;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import com.draconicarcher.brewincompatdelight.registries.BCDModEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Brewincompatdelight.MODID)
public class ProjectileDamageEvent {

    // Define a tag for ranged weapons
    private static final TagKey<Item> RANGED_WEAPONS_TAG = ItemTags.create(new ResourceLocation("brewincompatdelight", "ranged_weapons"));

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        // Get the direct entity causing the damage
        if (event.getSource().getDirectEntity() instanceof AbstractArrow arrow) {
            // Check if the shooter is a player
            Entity shooter = arrow.getOwner();
            if (shooter instanceof ServerPlayer player) {
                // Check if the player has the custom effect
                if (player.hasEffect(BCDModEffects.PROJECTILE_DAMAGE.get())) {
                    int effectLevel = player.getEffect(BCDModEffects.PROJECTILE_DAMAGE.get()).getAmplifier() + 1;

                    // Increase damage by 25% per effect level
                    event.setAmount(event.getAmount() * (1 + 0.25f * effectLevel));
                }
            }
        }
    }

    @SubscribeEvent
    public static void onArrowSpawn(EntityJoinLevelEvent event) {
        // Check if the entity is an arrow
        if (event.getEntity() instanceof AbstractArrow arrow) {
            // Check if the shooter is a player
            Entity shooter = arrow.getOwner();
            if (shooter instanceof ServerPlayer player) {
                // Check if the player has the PROJECTILE_DAMAGE effect
                if (player.hasEffect(BCDModEffects.PROJECTILE_DAMAGE.get())) {
                    int effectLevel = player.getEffect(BCDModEffects.PROJECTILE_DAMAGE.get()).getAmplifier() + 1;

                    // Reduce the durability of the weapon
                    damageWeapon(player, effectLevel * 2); // Durability loss scales with effect level
                }
            }
        }
    }

    // Helper method to reduce weapon durability
    private static void damageWeapon(ServerPlayer player, int damageAmount) {
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