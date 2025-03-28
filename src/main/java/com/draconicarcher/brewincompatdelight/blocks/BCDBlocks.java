



package com.draconicarcher.brewincompatdelight.blocks;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight; // Import your main mod class
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.draconicarcher.brewincompatdelight.Brewincompatdelight.MODID;

public class BCDBlocks extends Block {
    public BCDBlocks(Properties properties) {
        super(properties);
    }
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID); // Define and initialize ITEMS here


    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> block) {
        RegistryObject<Block> blockRegistryObject = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties()));
        return blockRegistryObject;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus); // Register ITEMS with the event bus! This is the critical missing line.
    }
}