package com.draconicarcher.brewincompatdelight.registries;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import com.draconicarcher.brewincompatdelight.effects.ArrowLootingEffect;
import com.draconicarcher.brewincompatdelight.effects.ProjectileDamageEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BCDModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Brewincompatdelight.MODID);

    public static final RegistryObject<MobEffect> PROJECTILE_DAMAGE =
            MOB_EFFECTS.register("overdraw", ProjectileDamageEffect::new);

    public static final RegistryObject<MobEffect> ARROW_LOOTING =
            MOB_EFFECTS.register("arrow_looting", ArrowLootingEffect::new);

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
