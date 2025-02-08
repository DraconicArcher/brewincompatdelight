package com.draconicarcher.brewincompatdelight.items;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BnCItems;
import java.util.function.Supplier; // Import Supplier

@Mod.EventBusSubscriber(modid = Brewincompatdelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class BCDItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Brewincompatdelight.MODID);

    public static RegistryObject<Item> MOONSHINE;
    public static RegistryObject<Item> WHITE_WINE;
    public static RegistryObject<Item> RED_WINE;
    public static RegistryObject<Item> SWEET_RED_WINE;
    public static RegistryObject<Item> HALF_AND_HALF;
    public static RegistryObject<Item> BLACK_RUSSIAN;
    public static RegistryObject<Item> WHITE_RUSSIAN;
    public static RegistryObject<Item> SCREWDRIVER;
    public static RegistryObject<Item> MULLED_WINE;
    public static RegistryObject<Item> PEACH_WINE;
    public static RegistryObject<Item> TEQUILA;
    public static RegistryObject<Item> NUT_BROWN_ALE; // Declare without initialization
    public static RegistryObject<Item> HARD_CIDER;
    public static RegistryObject<Item> HARD_LEMONADE;
    public static RegistryObject<Item> LEMON_LIME;

    public static void initialize() {
        WHITE_WINE = ITEMS.register("white_wine",
                () -> new BoozeItem(BCDFluids.WHITE_WINE.get(),
                        new Item.Properties().stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.WHITE_WINE)));

        RED_WINE = ITEMS.register("red_wine",
                () -> new BoozeItem(BCDFluids.RED_WINE.get(),
                        new Item.Properties().stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.RED_WINE)));

        SWEET_RED_WINE = ITEMS.register("sweet_red_wine",
                () -> new BoozeItem(BCDFluids.SWEET_RED_WINE.get(),
                        new Item.Properties().stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.SWEET_RED_WINE)));

        MULLED_WINE = ITEMS.register("mulled_wine",
                () -> new BoozeItem(BCDFluids.MULLED_WINE.get(),
                        new Item.Properties().stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.MULLED_WINE)));

        PEACH_WINE = ITEMS.register("peach_wine",
                () -> new BoozeItem(BCDFluids.PEACH_WINE.get(),
                        new Item.Properties().stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.PEACH_WINE)));

        TEQUILA = ITEMS.register("tequila",
                () -> new BoozeItem(BCDFluids.TEQUILA.get(),
                        new Item.Properties().stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.TEQUILA)));

        MOONSHINE = ITEMS.register("moonshine",
                () -> new BoozeItem(BCDFluids.MOONSHINE.get(),
                        new Item.Properties().stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.MOONSHINE)));

        NUT_BROWN_ALE = ITEMS.register("nut_brown_ale",
                () -> new BoozeItem(BCDFluids.NUT_BROWN_ALE.get(),
                        new Item.Properties().stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.NUT_BROWN_ALE)));

        HARD_CIDER = ITEMS.register("hard_cider",
                () -> new BoozeItem(BCDFluids.HARD_CIDER.get(),
                        new Item.Properties().stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.HARD_CIDER)));

        HARD_LEMONADE = ITEMS.register("hard_lemonade",
                () -> new BoozeItem(BCDFluids.HARD_LEMONADE.get(),
                        new Item.Properties().stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.HARD_LEMONADE)));


        BLACK_RUSSIAN = ITEMS.register("black_russian",
                () -> new BCDDrinkableItemT(new Item.Properties().stacksTo(64).food(BCDFood.BLACK_RUSSIAN)));

        SCREWDRIVER = ITEMS.register("screwdriver",
                () -> new BCDDrinkableItem(new Item.Properties().stacksTo(64).food(BCDFood.SCREWDRIVER)));

        LEMON_LIME = ITEMS.register("lemon_lime",
                () -> new BCDDrinkableItem(new Item.Properties().stacksTo(64).food(BCDFood.LEMON_LIME)));

        WHITE_RUSSIAN = ITEMS.register("white_russian",
                () -> new BCDDrinkableItemT(new Item.Properties().stacksTo(64).food(BCDFood.WHITE_RUSSIAN)));

        HALF_AND_HALF = ITEMS.register("half_and_half",
                () -> new BCDDrinkableItem(new Item.Properties().stacksTo(64).food(BCDFood.HALF_AND_HALF)));
    }
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}