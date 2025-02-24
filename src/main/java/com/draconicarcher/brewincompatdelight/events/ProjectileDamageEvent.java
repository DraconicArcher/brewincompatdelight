package com.draconicarcher.brewincompatdelight.events;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import com.draconicarcher.brewincompatdelight.registries.BCDEffectRegistry;
import com.draconicarcher.brewincompatdelight.registries.BCDModEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
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

    private static final TagKey<Item> BOWS_TAG = ItemTags.create(new ResourceLocation("forge", "tools/bows"));
    private static final TagKey<Item> CROSSBOWS_TAG = ItemTags.create(new ResourceLocation("forge", "tools/crossbows"));
    private static final TagKey<Item> C_BOWS_TAG = ItemTags.create(new ResourceLocation("c", "tools/bow"));
    private static final TagKey<Item> C_CROSSBOWS_TAG = ItemTags.create(new ResourceLocation("c", "tools/crossbow"));

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource() != null && event.getSource().getDirectEntity() instanceof AbstractArrow arrow) {
            Entity shooter = arrow.getOwner();
            if (shooter instanceof ServerPlayer player) {
                if (player.hasEffect(BCDModEffects.PROJECTILE_DAMAGE.get())) {
                    int effectLevel = player.getEffect(BCDModEffects.PROJECTILE_DAMAGE.get()).getAmplifier() + 1;
                    event.setAmount(event.getAmount() * (1 + 0.25f * effectLevel));
                }
            }
        }
    }

    @SubscribeEvent
    public static void onArrowSpawn(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof AbstractArrow arrow && arrow.getOwner() instanceof ServerPlayer player) {
            if (player.hasEffect(BCDModEffects.PROJECTILE_DAMAGE.get())) {
                int effectLevel = player.getEffect(BCDModEffects.PROJECTILE_DAMAGE.get()).getAmplifier() + 1;
                int damageAmount = effectLevel * 2;

                if (player.getServer() != null) {
                    player.getServer().execute(() -> {
                        BCDEffectRegistry.applyProjectileDamageEffect(player);
                    });
                }
            }
        }
    }
}
