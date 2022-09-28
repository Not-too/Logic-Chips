package com.ichphilipp.logicchips.allblocks;

import com.ichphilipp.logicchips.LogicChips;
import com.ichphilipp.logicchips.allitems.AllItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class AllBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, LogicChips.MOD_ID);
    // -------------------------------------------------------------------------------------------------------
    public static final RegistryObject<Block> GATE_FRAME = registerBlock("gate_frame",() -> new ChipFrame(AbstractBlock.Properties.copy(Blocks.REPEATER)));
    // -------------------------------------------------------------------------------------------------------
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        AllItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties().tab(LogicChips.ITEM_GROUP)));
    }
    // -------------------------------------------------------------------------------------------------------
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}