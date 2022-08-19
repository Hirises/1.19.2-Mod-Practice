package com.hirises.satisfactorymod.items;

import com.hirises.satisfactorymod.SatisfactoryMod;
import com.hirises.satisfactorymod.blocks.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SatisfactoryMod.MODID);

    public static final RegistryObject<Item> IRON_ROD = ITEMS.register("iron_rod", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.BASIC_MATERIAL)));
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate", () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.BASIC_MATERIAL)));

    public static final RegistryObject<Item> CONVEYOR_MK1 = ITEMS.register("conveyor_mk1",
            () -> new ItemNameBlockItem(ModBlocks.CONVEYOR_MK1.get(), new Item.Properties().tab(ModCreativeModeTabs.ORGANIZING).food(ModFoods.BERYL_NUT)));

    public static final RegistryObject<Item> FOUNDATION = ITEMS.register("foundation", () -> new BlockItem(ModBlocks.FOUNDATION.get(),
            new Item.Properties().tab(ModCreativeModeTabs.STRUCTURING)));

    public static final RegistryObject<Item> BERYL_NUT = ITEMS.register("beryl_nut",
            () -> new ItemNameBlockItem(ModBlocks.BERYL_NUT_BUSH.get(), new Item.Properties().tab(ModCreativeModeTabs.ENVIRONMENT).food(ModFoods.BERYL_NUT)));

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
