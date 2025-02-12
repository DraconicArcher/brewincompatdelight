package com.draconicarcher.brewincompatdelight.events;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import com.draconicarcher.brewincompatdelight.registries.BCDModEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
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

    private static final String ARROW_LOOTING_LEVEL_KEY = "ArrowLootingLevel";
    private static final String WEAPON_DAMAGE_KEY = "WeaponDamage";

    private static final TagKey<Item> BOWS_TAG = ItemTags.create(new ResourceLocation("forge", "tools/bows"));
    private static final TagKey<Item> CROSSBOWS_TAG = ItemTags.create(new ResourceLocation("forge", "tools/crossbows"));
    private static final TagKey<Item> C_BOWS_TAG = ItemTags.create(new ResourceLocation("c", "tools/bow"));
    private static final TagKey<Item> C_CROSSBOWS_TAG = ItemTags.create(new ResourceLocation("c", "tools/crossbow"));

    @SubscribeEvent
    public static void onArrowSpawn(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof AbstractArrow arrow) {
            Entity shooter = arrow.getOwner();
            if (shooter instanceof Player player) {
                if (player.hasEffect(BCDModEffects.ARROW_LOOTING.get())) {
                    int effectLevel = player.getEffect(BCDModEffects.ARROW_LOOTING.get()).getAmplifier() + 1;
                    arrow.getPersistentData().putInt(ARROW_LOOTING_LEVEL_KEY, effectLevel);

                    int durabilityLoss = 2 * effectLevel;
                    arrow.getPersistentData().putInt(WEAPON_DAMAGE_KEY, durabilityLoss);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLootingLevel(LootingLevelEvent event) {
        if (event.getDamageSource().getDirectEntity() instanceof AbstractArrow arrow && arrow.getOwner() instanceof ServerPlayer player) { // Check for ServerPlayer
            int lootingLevel = arrow.getPersistentData().getInt(ARROW_LOOTING_LEVEL_KEY);
            if (lootingLevel > 0) {
                event.setLootingLevel(event.getLootingLevel() + lootingLevel);

                if (arrow.getPersistentData().contains(WEAPON_DAMAGE_KEY)) {
                    int damageAmount = arrow.getPersistentData().getInt(WEAPON_DAMAGE_KEY);

                    // Schedule the damage on the server thread
                    if (player.getServer() != null) {
                        player.getServer().execute(() -> { // Use server.execute
                            damageWeapon(player, damageAmount);
                        });
                    }

                    arrow.getPersistentData().remove(WEAPON_DAMAGE_KEY);
                }
            }
        }
    }


    private static void damageWeapon(Player player, int damageAmount) {
        ItemStack weapon = player.getUseItem();
        if (weapon.isEmpty() || !isRangedWeapon(weapon.getItem())) {
            weapon = player.getMainHandItem();
        }
        if (weapon.isEmpty() || !isRangedWeapon(weapon.getItem())) {
            weapon = player.getOffhandItem();
        }

        if (!weapon.isEmpty() && isRangedWeapon(weapon.getItem())) {
            weapon.hurtAndBreak(damageAmount, player, (entity) -> {
                entity.broadcastBreakEvent(player.getUsedItemHand());
            });
        }
    }

    private static boolean isRangedWeapon(Item item) {
        if (item instanceof ProjectileWeaponItem) {
            return true;
        }

        ItemStack stack = new ItemStack(item);

        return stack.getTags().anyMatch(tag ->
                tag.location().equals(BOWS_TAG.location()) ||
                        tag.location().equals(CROSSBOWS_TAG.location()) ||
                        tag.location().equals(C_BOWS_TAG.location()) ||
                        tag.location().equals(C_CROSSBOWS_TAG.location())
        );
    }
}