package com.hirises.satisfactorymod;

import com.hirises.satisfactorymod.blocks.ModBlockEntities;
import com.hirises.satisfactorymod.blocks.ModBlocks;
import com.hirises.satisfactorymod.items.ModItems;
import com.hirises.satisfactorymod.screen.ModMenuTypes;
import com.hirises.satisfactorymod.screen.custom.comveyor.screen.ConveyorBaseScreen;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SatisfactoryMod.MODID)
public class SatisfactoryMod
{
    public static final String MODID = "satisfactorymod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SatisfactoryMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::onCommonSetup);
        modEventBus.addListener(this::onClientSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event)
    {

    }

    public void onClientSetup(FMLClientSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BERYL_NUT_BUSH.get(), RenderType.cutout());

        MenuScreens.register(ModMenuTypes.CONVEYOR_BASE_MENU.get(), ConveyorBaseScreen::new);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }
}
