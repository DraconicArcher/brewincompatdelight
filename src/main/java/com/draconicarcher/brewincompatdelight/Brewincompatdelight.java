package com.draconicarcher.brewincompatdelight;

import com.draconicarcher.brewincompatdelight.items.BCDFluids;
import com.draconicarcher.brewincompatdelight.blocks.BCDBlocks;
import com.draconicarcher.brewincompatdelight.items.BCDItems;
import com.draconicarcher.brewincompatdelight.items.BCDFood;
import com.draconicarcher.brewincompatdelight.recipes.NoBottleReturnRecipe;
import com.draconicarcher.brewincompatdelight.registries.BCDModEffects;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(Brewincompatdelight.MODID)
public class Brewincompatdelight {

    public static final String MODID = "brewincompatdelight";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MODID);
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID);

    public static final RegistryObject<RecipeType<NoBottleReturnRecipe>> NO_BOTTLE_RETURN_TYPE = RECIPE_TYPES.register("no_bottle_return",
            () -> new RecipeType<NoBottleReturnRecipe>() {
                @Override
                public String toString() {
                    return "brewincompatdelight:no_bottle_return";
                }
            });

    public static final RegistryObject<RecipeSerializer<NoBottleReturnRecipe>> NO_BOTTLE_RETURN_RECIPE = SERIALIZERS.register("no_bottle_return", NoBottleReturnRecipe.Serializer::new);

    public static RecipeType<NoBottleReturnRecipe> getNoBottleReturnRecipeType() {
        return NO_BOTTLE_RETURN_TYPE.get();
    }

    public static RecipeSerializer<NoBottleReturnRecipe> getNoBottleReturnRecipeSerializer() {
        return NO_BOTTLE_RETURN_RECIPE.get();

    }

    public Brewincompatdelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // 1. Register ALL DeferredRegisters FIRST - ORDER MATTERS!
        BCDFluids.register(modEventBus);     // Fluids MUST be registered first
        BCDModEffects.register(modEventBus); // Or BCDModEffects if that's the correct name
        BCDItems.register(modEventBus);
        BCDBlocks.register(modEventBus);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        RECIPE_TYPES.register(modEventBus);
        SERIALIZERS.register(modEventBus);



        BCDFood.initialize();
        BCDItems.initialize();

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            addItemToTab(event, BCDItems.MOONSHINE);
            addItemToTab(event, BCDItems.WHITE_WINE);
            addItemToTab(event, BCDItems.RED_WINE);
            addItemToTab(event, BCDItems.SWEET_RED_WINE);
            addItemToTab(event, BCDItems.HALF_AND_HALF);
            addItemToTab(event, BCDItems.BLACK_RUSSIAN);
            addItemToTab(event, BCDItems.WHITE_RUSSIAN);
            addItemToTab(event, BCDItems.SCREWDRIVER);
            addItemToTab(event, BCDItems.TEQUILA);
            addItemToTab(event, BCDItems.MULLED_WINE);
            addItemToTab(event, BCDItems.PEACH_WINE);
            addItemToTab(event, BCDItems.NUT_BROWN_ALE);
            addItemToTab(event, BCDItems.LEMON_LIME);
            addItemToTab(event, BCDItems.HARD_CIDER);
            addItemToTab(event, BCDItems.HARD_LEMONADE);
        }


        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) { // Or your custom tab
            event.accept(BCDBlocks.STRAWBERRY_CRATE.get().asItem()); // Add the block item
            event.accept(BCDBlocks.RASPBERRY_CRATE.get().asItem());
            event.accept(BCDBlocks.BLUEBERRY_CRATE.get().asItem());
            event.accept(BCDBlocks.CHERRY_CRATE.get().asItem());
            event.accept(BCDBlocks.GREEN_GRAPES_CRATE.get().asItem()); // Add the block item
            event.accept(BCDBlocks.BLACK_GRAPES_CRATE.get().asItem());
        }
    }

    private void addItemToTab(BuildCreativeModeTabContentsEvent event, RegistryObject<Item> item) {
        if (item != null && item.get() != null) {
            event.accept(item.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}