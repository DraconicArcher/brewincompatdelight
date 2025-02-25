package com.draconicarcher.brewincompatdelight.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.item.BoozeItem;

@EventBusSubscriber(
        modid = "brewincompatdelight",
        bus = Bus.MOD
)
public class BCDItems {
    public static final DeferredRegister<Item> ITEMS;
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
    public static RegistryObject<Item> NUT_BROWN_ALE;
    public static RegistryObject<Item> HARD_CIDER;
    public static RegistryObject<Item> HARD_LEMONADE;
    public static RegistryObject<Item> LEMON_LIME;
    public static RegistryObject<Item> RUM;
    public static RegistryObject<Item> MOJITO;
    public static RegistryObject<Item> PINA_COLADA;

    public static void initialize() {
        WHITE_WINE = ITEMS.register("white_wine", () -> {
            return new BoozeItem((Fluid)BCDFluids.WHITE_WINE.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.WHITE_WINE));
        });
        RED_WINE = ITEMS.register("red_wine", () -> {
            return new BoozeItem((Fluid)BCDFluids.RED_WINE.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.RED_WINE));
        });
        SWEET_RED_WINE = ITEMS.register("sweet_red_wine", () -> {
            return new BoozeItem((Fluid)BCDFluids.SWEET_RED_WINE.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.SWEET_RED_WINE));
        });
        MULLED_WINE = ITEMS.register("mulled_wine", () -> {
            return new BoozeItem((Fluid)BCDFluids.MULLED_WINE.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.MULLED_WINE));
        });
        PEACH_WINE = ITEMS.register("peach_wine", () -> {
            return new BoozeItem((Fluid)BCDFluids.PEACH_WINE.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.PEACH_WINE));
        });
        TEQUILA = ITEMS.register("tequila", () -> {
            return new BoozeItem((Fluid)BCDFluids.TEQUILA.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.TEQUILA));
        });
        MOONSHINE = ITEMS.register("moonshine", () -> {
            return new BoozeItem((Fluid)BCDFluids.MOONSHINE.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.MOONSHINE));
        });
        NUT_BROWN_ALE = ITEMS.register("nut_brown_ale", () -> {
            return new BoozeItem((Fluid)BCDFluids.NUT_BROWN_ALE.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.NUT_BROWN_ALE));
        });
        HARD_CIDER = ITEMS.register("hard_cider", () -> {
            return new BoozeItem((Fluid)BCDFluids.HARD_CIDER.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.HARD_CIDER));
        });
        HARD_LEMONADE = ITEMS.register("hard_lemonade", () -> {
            return new BoozeItem((Fluid)BCDFluids.HARD_LEMONADE.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.HARD_LEMONADE));
        });
        RUM = ITEMS.register("rum", () -> {
            return new BoozeItem((Fluid)BCDFluids.RUM.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.RUM));
        });
        BLACK_RUSSIAN = ITEMS.register("black_russian", () -> {
            return new BCDDrinkableItemT((new Properties()).stacksTo(64).food(BCDFood.BLACK_RUSSIAN));
        });
        SCREWDRIVER = ITEMS.register("screwdriver", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.SCREWDRIVER));
        });
        LEMON_LIME = ITEMS.register("lemon_lime", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.LEMON_LIME));
        });
        WHITE_RUSSIAN = ITEMS.register("white_russian", () -> {
            return new BCDDrinkableItemT((new Properties()).stacksTo(64).food(BCDFood.WHITE_RUSSIAN));
        });
        HALF_AND_HALF = ITEMS.register("half_and_half", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.HALF_AND_HALF));
        });
        MOJITO = ITEMS.register("mojito", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.MOJITO));
        });
        PINA_COLADA = ITEMS.register("pina_colada", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.PINA_COLADA));
        });
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "brewincompatdelight");
    }
}
