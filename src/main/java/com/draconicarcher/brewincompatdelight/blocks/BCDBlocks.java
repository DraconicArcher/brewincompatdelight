package com.draconicarcher.brewincompatdelight.blocks;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import com.draconicarcher.brewincompatdelight.blocks.custom.RedGrapeCropBlock;
import com.draconicarcher.brewincompatdelight.blocks.custom.WhiteGrapeCropBlock;
import com.draconicarcher.brewincompatdelight.blocks.custom.WildRedGrapeBush;
import com.draconicarcher.brewincompatdelight.blocks.custom.WildWhiteGrapeBush;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BCDBlocks {
    // Deferred register for blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Brewincompatdelight.MODID);
    // Deferred register for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Brewincompatdelight.MODID);

    // Block registry object for 'juniper_berries_crate'
    public static final RegistryObject<Block> JUNIPER_BERRIES_CRATE = BLOCKS.register(
            "juniper_berries_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD))
    );

    public static final RegistryObject<Block> RED_GRAPES_CRATE = BLOCKS.register(
            "red_grapes_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD))
    );

    public static final RegistryObject<Block> WHITE_GRAPES_CRATE = BLOCKS.register(
            "white_grapes_crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD))
    );


    public static final RegistryObject<Block> RED_GRAPE_CROP = BLOCKS.register("red_grape_crop",
            () -> new RedGrapeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> WHITE_GRAPE_CROP = BLOCKS.register("white_grape_crop",
            () -> new WhiteGrapeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> WILD_RED_GRAPES = BLOCKS.register("wild_red_grapes",
            () -> new WildRedGrapeBush(Block.Properties.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> WILD_WHITE_GRAPE = BLOCKS.register("wild_white_grape",
            () -> new WildWhiteGrapeBush(Block.Properties.copy(Blocks.SWEET_BERRY_BUSH)));

    // Helper method for registering blocks and their associated items
    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        return BLOCKS.register(name, block);
    }

    // Register the blocks and items
    public static void register(IEventBus eventBus) {
        // Register blocks
        BLOCKS.register(eventBus);
        // Register items
        ITEMS.register(eventBus);

        // Now register the BlockItem for JUNIPER_BERRIES_CRATE
        ITEMS.register("juniper_berries_crate", () -> new BlockItem(JUNIPER_BERRIES_CRATE.get(), new Item.Properties()));
        ITEMS.register("red_grapes_crate", () -> new BlockItem(RED_GRAPES_CRATE.get(), new Item.Properties()));
        ITEMS.register("white_grapes_crate", () -> new BlockItem(WHITE_GRAPES_CRATE.get(), new Item.Properties()));
    }
}
