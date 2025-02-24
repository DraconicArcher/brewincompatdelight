package com.draconicarcher.brewincompatdelight.items;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.fluid.AlcoholFluidType;

import java.util.function.Supplier;

public class BCDFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Brewincompatdelight.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Brewincompatdelight.MODID);

    public static RegistryObject<FluidType> MOONSHINE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> MOONSHINE;
    public static RegistryObject<FlowingFluid> FLOWING_MOONSHINE;
    public static Supplier<ForgeFlowingFluid.Properties> MOONSHINE_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> WHITE_WINE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> WHITE_WINE;
    public static RegistryObject<FlowingFluid> FLOWING_WHITE_WINE;
    public static Supplier<ForgeFlowingFluid.Properties> WHITE_WINE_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> RED_WINE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> RED_WINE;
    public static RegistryObject<FlowingFluid> FLOWING_RED_WINE;
    public static Supplier<ForgeFlowingFluid.Properties> RED_WINE_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> SWEET_RED_WINE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> SWEET_RED_WINE;
    public static RegistryObject<FlowingFluid> FLOWING_SWEET_RED_WINE;
    public static Supplier<ForgeFlowingFluid.Properties> SWEET_RED_WINE_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> NUT_BROWN_ALE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> NUT_BROWN_ALE;
    public static RegistryObject<FlowingFluid> FLOWING_NUT_BROWN_ALE;
    public static Supplier<ForgeFlowingFluid.Properties> NUT_BROWN_ALE_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> MULLED_WINE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> MULLED_WINE;
    public static RegistryObject<FlowingFluid> FLOWING_MULLED_WINE;
    public static Supplier<ForgeFlowingFluid.Properties> MULLED_WINE_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> PEACH_WINE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> PEACH_WINE;
    public static RegistryObject<FlowingFluid> FLOWING_PEACH_WINE;
    public static Supplier<ForgeFlowingFluid.Properties> PEACH_WINE_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> TEQUILA_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> TEQUILA;
    public static RegistryObject<FlowingFluid> FLOWING_TEQUILA;
    public static Supplier<ForgeFlowingFluid.Properties> TEQUILA_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> APPLE_CIDER_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> APPLE_CIDER;
    public static RegistryObject<FlowingFluid> FLOWING_APPLE_CIDER;
    public static Supplier<ForgeFlowingFluid.Properties> APPLE_CIDER_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> HARD_CIDER_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> HARD_CIDER;
    public static RegistryObject<FlowingFluid> FLOWING_HARD_CIDER;
    public static Supplier<ForgeFlowingFluid.Properties> HARD_CIDER_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> LEMONADE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> LEMONADE;
    public static RegistryObject<FlowingFluid> FLOWING_LEMONADE;
    public static Supplier<ForgeFlowingFluid.Properties> LEMONADE_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> HARD_LEMONADE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> HARD_LEMONADE;
    public static RegistryObject<FlowingFluid> FLOWING_HARD_LEMONADE;
    public static Supplier<ForgeFlowingFluid.Properties> HARD_LEMONADE_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> RUM_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> RUM;
    public static RegistryObject<FlowingFluid> FLOWING_RUM;
    public static Supplier<ForgeFlowingFluid.Properties> RUM_FLUID_PROPERTIES;


    public static void register(IEventBus eventBus) {
            MOONSHINE_FLUID_TYPE = FLUID_TYPES.register("moonshine_type", () -> new AlcoholFluidType(-1573386));
            MOONSHINE = FLUIDS.register("moonshine", () -> new ForgeFlowingFluid.Source(MOONSHINE_FLUID_PROPERTIES.get()));
            FLOWING_MOONSHINE = FLUIDS.register("flowing_moonshine", () -> new ForgeFlowingFluid.Flowing(MOONSHINE_FLUID_PROPERTIES.get()));
            MOONSHINE_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(MOONSHINE_FLUID_TYPE, MOONSHINE, FLOWING_MOONSHINE);


            WHITE_WINE_FLUID_TYPE = FLUID_TYPES.register("white_wine_type", () -> new AlcoholFluidType(-3147461));
            WHITE_WINE = FLUIDS.register("white_wine", () -> new ForgeFlowingFluid.Source(WHITE_WINE_FLUID_PROPERTIES.get()));
            FLOWING_WHITE_WINE = FLUIDS.register("flowing_white_wine", () -> new ForgeFlowingFluid.Flowing(WHITE_WINE_FLUID_PROPERTIES.get()));
            WHITE_WINE_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(WHITE_WINE_FLUID_TYPE, WHITE_WINE, FLOWING_WHITE_WINE);

            RED_WINE_FLUID_TYPE = FLUID_TYPES.register("red_wine_type", () -> new AlcoholFluidType(-5689110));
            RED_WINE = FLUIDS.register("red_wine", () -> new ForgeFlowingFluid.Source(RED_WINE_FLUID_PROPERTIES.get()));
            FLOWING_RED_WINE = FLUIDS.register("flowing_red_wine", () -> new ForgeFlowingFluid.Flowing(RED_WINE_FLUID_PROPERTIES.get()));
            RED_WINE_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(RED_WINE_FLUID_TYPE, RED_WINE, FLOWING_RED_WINE);

            SWEET_RED_WINE_FLUID_TYPE = FLUID_TYPES.register("sweet_red_wine_type", () -> new AlcoholFluidType(-9105950));
            SWEET_RED_WINE = FLUIDS.register("sweet_red_wine", () -> new ForgeFlowingFluid.Source(SWEET_RED_WINE_FLUID_PROPERTIES.get()));
            FLOWING_SWEET_RED_WINE = FLUIDS.register("flowing_sweet_red_wine", () -> new ForgeFlowingFluid.Flowing(SWEET_RED_WINE_FLUID_PROPERTIES.get()));
            SWEET_RED_WINE_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(SWEET_RED_WINE_FLUID_TYPE, SWEET_RED_WINE, FLOWING_SWEET_RED_WINE);

        NUT_BROWN_ALE_FLUID_TYPE = FLUID_TYPES.register("nut_brown_ale_type", () -> new AlcoholFluidType( -14239));
        NUT_BROWN_ALE = FLUIDS.register("nut_brown_ale", () -> new ForgeFlowingFluid.Source(NUT_BROWN_ALE_FLUID_PROPERTIES.get()));
        FLOWING_NUT_BROWN_ALE = FLUIDS.register("flowing_nut_brown_ale", () -> new ForgeFlowingFluid.Flowing(NUT_BROWN_ALE_FLUID_PROPERTIES.get()));
        NUT_BROWN_ALE_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(NUT_BROWN_ALE_FLUID_TYPE, NUT_BROWN_ALE, FLOWING_NUT_BROWN_ALE);

        MULLED_WINE_FLUID_TYPE = FLUID_TYPES.register("mulled_wine_type", () -> new AlcoholFluidType(-4325370));
        MULLED_WINE = FLUIDS.register("mulled_wine", () -> new ForgeFlowingFluid.Source(MULLED_WINE_FLUID_PROPERTIES.get()));
        FLOWING_MULLED_WINE = FLUIDS.register("flowing_mulled_wine", () -> new ForgeFlowingFluid.Flowing(MULLED_WINE_FLUID_PROPERTIES.get()));
        MULLED_WINE_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(MULLED_WINE_FLUID_TYPE, MULLED_WINE, FLOWING_MULLED_WINE);

        PEACH_WINE_FLUID_TYPE = FLUID_TYPES.register("peach_wine_type", () -> new AlcoholFluidType(-1346616));
        PEACH_WINE = FLUIDS.register("peach_wine", () -> new ForgeFlowingFluid.Source(PEACH_WINE_FLUID_PROPERTIES.get()));
        FLOWING_PEACH_WINE = FLUIDS.register("flowing_peach_wine", () -> new ForgeFlowingFluid.Flowing(PEACH_WINE_FLUID_PROPERTIES.get()));
        PEACH_WINE_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(PEACH_WINE_FLUID_TYPE, PEACH_WINE, FLOWING_PEACH_WINE);

        TEQUILA_FLUID_TYPE = FLUID_TYPES.register("tequila_type", () -> new AlcoholFluidType(-1573386));
        TEQUILA = FLUIDS.register("tequila", () -> new ForgeFlowingFluid.Source(TEQUILA_FLUID_PROPERTIES.get()));
        FLOWING_TEQUILA = FLUIDS.register("flowing_tequila", () -> new ForgeFlowingFluid.Flowing(TEQUILA_FLUID_PROPERTIES.get()));
        TEQUILA_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(TEQUILA_FLUID_TYPE, TEQUILA, FLOWING_TEQUILA);

        APPLE_CIDER_FLUID_TYPE = FLUID_TYPES.register("apple_cider_type", () -> new AlcoholFluidType(-14236));
        APPLE_CIDER = FLUIDS.register("apple_cider", () -> new ForgeFlowingFluid.Source(APPLE_CIDER_FLUID_PROPERTIES.get()));
        FLOWING_APPLE_CIDER = FLUIDS.register("flowing_apple_cider", () -> new ForgeFlowingFluid.Flowing(APPLE_CIDER_FLUID_PROPERTIES.get()));
        APPLE_CIDER_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(APPLE_CIDER_FLUID_TYPE, APPLE_CIDER, FLOWING_APPLE_CIDER);

        HARD_CIDER_FLUID_TYPE = FLUID_TYPES.register("hard_cider_type", () -> new AlcoholFluidType(-14234));
        HARD_CIDER = FLUIDS.register("hard_cider", () -> new ForgeFlowingFluid.Source(HARD_CIDER_FLUID_PROPERTIES.get()));
        FLOWING_HARD_CIDER = FLUIDS.register("flowing_hard_cider", () -> new ForgeFlowingFluid.Flowing(HARD_CIDER_FLUID_PROPERTIES.get()));
        HARD_CIDER_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(HARD_CIDER_FLUID_TYPE, HARD_CIDER, FLOWING_HARD_CIDER);

        LEMONADE_FLUID_TYPE = FLUID_TYPES.register("lemonade_type", () -> new AlcoholFluidType(-1442306));
        LEMONADE = FLUIDS.register("lemonade", () -> new ForgeFlowingFluid.Source(LEMONADE_FLUID_PROPERTIES.get()));
        FLOWING_LEMONADE = FLUIDS.register("flowing_lemonade", () -> new ForgeFlowingFluid.Flowing(LEMONADE_FLUID_PROPERTIES.get()));
        LEMONADE_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(LEMONADE_FLUID_TYPE, LEMONADE, FLOWING_LEMONADE);

        HARD_LEMONADE_FLUID_TYPE = FLUID_TYPES.register("hard_lemonade_type", () -> new AlcoholFluidType(-1442309));
        HARD_LEMONADE = FLUIDS.register("hard_lemonade", () -> new ForgeFlowingFluid.Source(HARD_LEMONADE_FLUID_PROPERTIES.get()));
        FLOWING_HARD_LEMONADE = FLUIDS.register("flowing_hard_lemonade", () -> new ForgeFlowingFluid.Flowing(HARD_LEMONADE_FLUID_PROPERTIES.get()));
        HARD_LEMONADE_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(HARD_LEMONADE_FLUID_TYPE, HARD_LEMONADE, FLOWING_HARD_LEMONADE);

        RUM_FLUID_TYPE = FLUID_TYPES.register("rum_type", () -> new AlcoholFluidType(-1573388));
        RUM = FLUIDS.register("rum", () -> new ForgeFlowingFluid.Source(RUM_FLUID_PROPERTIES.get()));
        FLOWING_RUM = FLUIDS.register("flowing_rum", () -> new ForgeFlowingFluid.Flowing(RUM_FLUID_PROPERTIES.get()));
        RUM_FLUID_PROPERTIES = () -> new ForgeFlowingFluid.Properties(RUM_FLUID_TYPE, RUM, FLOWING_RUM);

        FLUID_TYPES.register(eventBus);
        FLUIDS.register(eventBus);
    }
}
