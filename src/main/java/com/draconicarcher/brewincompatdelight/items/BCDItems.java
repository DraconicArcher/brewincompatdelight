package com.draconicarcher.brewincompatdelight.items;


import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BCDItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Brewincompatdelight.MODID);



    public static final RegistryObject<Item> MOONSHINE = ITEMS.register("moonshine",
            () -> new Item(new Item.Properties().food(com.draconicarcher.brewincompatdelight.items.BCDFood.MOONSHINE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
