package com.hirises.satisfactorymod.screen;

import com.hirises.satisfactorymod.SatisfactoryMod;
import com.hirises.satisfactorymod.screen.custom.comveyor.menu.ConveyorBaseMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SatisfactoryMod.MODID);

    public static final RegistryObject<MenuType<ConveyorBaseMenu>> CONVEYOR_BASE_MENU = registerMenuType(ConveyorBaseMenu::new, "conveyor_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name){
        return MENU_TYPES.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus bus){
        MENU_TYPES.register(bus);
    }
}
