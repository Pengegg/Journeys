package com.pengegg.journeys;

import com.mojang.logging.LogUtils;
import com.pengegg.journeys.block.ModBlocks;
import com.pengegg.journeys.item.ModItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Journeys.MOD_ID)
public class Journeys {
    public static final String MOD_ID = "journeys";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Journeys()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PENGEGG");
        LOGGER.info("HOW'D ALL THIS DIRT GET IN HERE??!");

    }

}
