package com.pengegg.journeys.block;

import com.pengegg.journeys.Journeys;
import com.pengegg.journeys.block.custom.SunBlastedSandBlock;
import com.pengegg.journeys.item.ModItems;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Journeys.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends  Block> RegistryObject<T> registerBlock (String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static final RegistryObject<Block> FIRST_STONE = registerBlock("first_stone",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.SAND)
                    .strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SUN_BLASTED_SAND = registerBlock("sun_blasted_sand",
            () -> new SunBlastedSandBlock(BlockBehaviour.Properties.of().sound(SoundType.SAND)
                    .strength(5f)));

}
