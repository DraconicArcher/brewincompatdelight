package com.draconicarcher.brewincompatdelight.items;

import com.draconicarcher.brewincompatdelight.blocks.BCDBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.FoodValues;

import static vectorwing.farmersdelight.common.registry.ModItems.foodItem;

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
    public static RegistryObject<Item> WHISKEY;
    public static RegistryObject<Item> MARGARITA;
    public static RegistryObject<Item> SALTED_MARGARITA;
    public static RegistryObject<Item> BOILERMAKER;
    public static RegistryObject<Item> TEQUILA_SUNRISE;
    public static RegistryObject<Item> KRAKEN_RUM;
    public static RegistryObject<Item> JUNIPER_BERRIES;
    public static RegistryObject<Item> GIN;
    public static RegistryObject<Item> BLUE_CURACAO;
    public static RegistryObject<Item> TONIC_WATER;
    public static RegistryObject<Item> GRENADINE;
    public static RegistryObject<Item> WHISKEY_SOUR;
    public static RegistryObject<Item> CHINA_BLUE;
    public static RegistryObject<Item> SINGAPORE_SLING;
    public static RegistryObject<Item> AQUA_VELVA;
    public static RegistryObject<Item> GIN_AND_TONIC;
    public static RegistryObject<Item> MERMAID_LEMONADE;
    public static RegistryObject<Item> BEES_KNEES;
    public static RegistryObject<Item> GIMLET;
    public static RegistryObject<Item> BRASS_MONKEY;
    public static RegistryObject<Item> VODKA_TONIC;
    public static RegistryObject<Item> GIN_AND_JUICE;
    public static RegistryObject<Item> SOY_WAX;
    public static RegistryObject<Item> JOHNNY_SILVERHAND;
    public static RegistryObject<Item> MEDINA;
    public static RegistryObject<Item> CRANBERRY_JUICE;
    public static RegistryObject<Item> RED_GRAPES;
    public static RegistryObject<Item> WHITE_GRAPES;
    public static RegistryObject<Item> WHITE_GRAPE_SEEDS;
    public static RegistryObject<Item> RED_GRAPE_SEEDS;

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
            return new BoozeItem((Fluid)BCDFluids.NUT_BROWN_ALE.get(), (new Properties()).stacksTo(64).craftRemainder(BnCItems.TANKARD.get()).food(BCDFood.NUT_BROWN_ALE));
        });
        HARD_CIDER = ITEMS.register("hard_cider", () -> {
            return new BoozeItem((Fluid)BCDFluids.HARD_CIDER.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.HARD_CIDER));
        });
        HARD_LEMONADE = ITEMS.register("hard_lemonade", () -> {
            return new BoozeItem((Fluid)BCDFluids.HARD_LEMONADE.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.HARD_LEMONADE));
        });
        RUM = ITEMS.register("rum", () -> {
            return new BoozeItem((Fluid)BCDFluids.RUM.get(), (new Properties()).stacksTo(64).craftRemainder(BnCItems.TANKARD.get()).food(BCDFood.RUM));
        });
        GIN = ITEMS.register("gin", () -> {
            return new BoozeItem((Fluid)BCDFluids.GIN.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.GIN));
        });
        BLUE_CURACAO = ITEMS.register("blue_curacao", () -> {
            return new BoozeItem((Fluid)BCDFluids.BLUE_CURACAO.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.BLUE_CURACAO));
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
        WHISKEY = ITEMS.register("whiskey", () -> {
            return new BoozeItem((Fluid)BCDFluids.WHISKEY.get(), (new Properties()).stacksTo(64).craftRemainder(Items.GLASS_BOTTLE).food(BCDFood.WHISKEY));
        });

        BOILERMAKER = ITEMS.register("boilermaker", () -> {
            return new BCDDrinkableItemT((new Properties()).stacksTo(64).food(BCDFood.BOILERMAKER));
        });
        MARGARITA = ITEMS.register("margarita", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.MARGARITA));
        });
        SALTED_MARGARITA = ITEMS.register("salted_margarita", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.SALTED_MARGARITA));
        });
        TEQUILA_SUNRISE = ITEMS.register("tequila_sunrise", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.TEQUILA_SUNRISE));
        });
        KRAKEN_RUM = ITEMS.register("kraken_rum", () -> {
            return new BoozeItem((Fluid)BCDFluids.KRAKEN_RUM.get(), (new Properties()).stacksTo(64).craftRemainder(BnCItems.TANKARD.get()).food(BCDFood.KRAKEN_RUM));
        });
        WHISKEY_SOUR = ITEMS.register("whiskey_sour", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.WHISKEY_SOUR));
        });
        CHINA_BLUE = ITEMS.register("china_blue", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.CHINA_BLUE));
        });
        SINGAPORE_SLING = ITEMS.register("singapore_sling", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.SINGAPORE_SLING));
        });
        AQUA_VELVA = ITEMS.register("aqua_velva", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.AQUA_VELVA));
        });
        GIN_AND_TONIC = ITEMS.register("gin_and_tonic", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.GIN_AND_TONIC));
        });
        GIN_AND_JUICE = ITEMS.register("gin_and_juice", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.GIN_AND_JUICE));
        });
        MERMAID_LEMONADE = ITEMS.register("mermaid_lemonade", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.MERMAID_LEMONADE));
        });
        BEES_KNEES = ITEMS.register("bees_knees", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.BEES_KNEES));
        });
        GIMLET = ITEMS.register("gimlet", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.GIMLET));
        });
        BRASS_MONKEY = ITEMS.register("brass_monkey", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.BRASS_MONKEY));
        });
        VODKA_TONIC = ITEMS.register("vodka_tonic", () -> {
            return new BCDDrinkableItemT((new Properties()).stacksTo(64).food(BCDFood.VODKA_TONIC));
        });
        JOHNNY_SILVERHAND = ITEMS.register("johnny_silverhand", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.JOHNNY_SILVERHAND));
        });
        CRANBERRY_JUICE = ITEMS.register("cranberry_juice", () -> {
            return new BCDDrinkableItem((new Properties()).stacksTo(64).food(BCDFood.CRANBERRY_JUICE));
        });
        MEDINA = ITEMS.register("medina", () -> {
            return new BCDDrinkableItemT((new Properties()).stacksTo(64).food(BCDFood.MEDINA));
        });

        JUNIPER_BERRIES = ITEMS.register("juniper_berries",
                () -> new Item(new Item.Properties().food(BCDFood.JUNIPER_BERRIES)));

        RED_GRAPES = ITEMS.register("red_grapes",
                () -> new Item(new Item.Properties().food(BCDFood.RED_GRAPES)));

        WHITE_GRAPES = ITEMS.register("white_grapes",
                () -> new Item(new Item.Properties().food(BCDFood.WHITE_GRAPES)));

        SOY_WAX = ITEMS.register("soy_wax",
                () -> new Item(new Item.Properties()));

        TONIC_WATER = ITEMS.register("tonic_water",
                () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

        GRENADINE = ITEMS.register("grenadine",
                () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

        RED_GRAPE_SEEDS = ITEMS.register("red_grape_seeds",
                () -> new ItemNameBlockItem(BCDBlocks.RED_GRAPE_CROP.get(), new Item.Properties()));

        WHITE_GRAPE_SEEDS = ITEMS.register("white_grape_seeds",
                () -> new ItemNameBlockItem(BCDBlocks.WHITE_GRAPE_CROP.get(), new Item.Properties()));




    }



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "brewincompatdelight");
    }
}
