package com.hirises.satisfactorymod.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab BASIC_MATERIAL = new CreativeModeTab("basic_material"){
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.IRON_ROD.get());
        }
    };

    public static final CreativeModeTab ORGANIZING = new CreativeModeTab("organizing"){
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CONVEYOR_MK1.get());
        }
    };

    public static final CreativeModeTab STRUCTURING = new CreativeModeTab("structuring"){
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FOUNDATION.get());
        }
    };

    public static final CreativeModeTab ENVIRONMENT = new CreativeModeTab("environment"){
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BERYL_NUT.get());
        }
    };
}
