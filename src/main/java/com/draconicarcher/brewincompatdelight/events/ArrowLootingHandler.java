package com.draconicarcher.brewincompatdelight.events;

import com.draconicarcher.brewincompatdelight.registries.BCDEffectRegistry;
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
        if (event.getDamageSource() != null && event.getDamageSource().getDirectEntity() instanceof AbstractArrow arrow && arrow.getOwner() instanceof ServerPlayer player) {
            int lootingLevel = arrow.getPersistentData().getInt(ARROW_LOOTING_LEVEL_KEY);
            if (lootingLevel > 0) {
                event.setLootingLevel(event.getLootingLevel() + lootingLevel);

                if (arrow.getPersistentData().contains(WEAPON_DAMAGE_KEY)) {
                    int damageAmount = arrow.getPersistentData().getInt(WEAPON_DAMAGE_KEY);

                    if (player.getServer() != null) {
                        player.getServer().execute(() -> {
                            BCDEffectRegistry.applyArrowLootingEffect(player);
                        });
                    }

                    arrow.getPersistentData().remove(WEAPON_DAMAGE_KEY);
                }
            }
        }
    }
}
