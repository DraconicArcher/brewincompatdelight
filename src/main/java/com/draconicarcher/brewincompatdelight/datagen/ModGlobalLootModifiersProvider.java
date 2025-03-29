package com.draconicarcher.brewincompatdelight.datagen;

import com.draconicarcher.brewincompatdelight.Brewincompatdelight;
import com.draconicarcher.brewincompatdelight.items.BCDItems;
import com.draconicarcher.brewincompatdelight.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Brewincompatdelight.MODID);
    }

    @Override
    protected void start() {
        add("juniper_berries", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SPRUCE_LEAVES).build(),
                LootItemRandomChanceCondition.randomChance(0.025f).build()}, BCDItems.JUNIPER_BERRIES.get()));




    }
}