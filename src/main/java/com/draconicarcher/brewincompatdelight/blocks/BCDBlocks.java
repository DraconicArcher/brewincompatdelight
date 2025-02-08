package com.draconicarcher.brewincompatdelight.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item; // Import Item
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.draconicarcher.brewincompatdelight.Brewincompatdelight.MODID;
import static com.draconicarcher.brewincompatdelight.Brewincompatdelight.ITEMS; // Make sure ITEMS is defined

public class BCDBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    // ... (Your other block registrations)

    public static final RegistryObject<Block> STRAWBERRY_CRATE = registerBlock("strawberry_crate", () -> new Block(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RASPBERRY_CRATE = registerBlock("raspberry_crate", () -> new Block(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BLUEBERRY_CRATE = registerBlock("blueberry_crate", () -> new Block(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GREEN_GRAPES_CRATE = registerBlock("green_grapes_crate", () -> new Block(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BLACK_GRAPES_CRATE = registerBlock("black_grapes_crate", () -> new Block(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHERRY_CRATE = registerBlock("cherry_crate", () -> new Block(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));


    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> blockRegistryObject = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties())); // Corrected line
        return blockRegistryObject;
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}