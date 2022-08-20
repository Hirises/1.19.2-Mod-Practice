package com.hirises.satisfactorymod.blocks;

import com.hirises.satisfactorymod.SatisfactoryMod;
import com.hirises.satisfactorymod.blocks.custom.BerylNutBush;
import com.hirises.satisfactorymod.blocks.custom.conveyor.block.ConveyorMk1;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SatisfactoryMod.MODID);

    public static final RegistryObject<Block> FOUNDATION = BLOCKS.register("foundation",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).destroyTime(3f)));
    public static final RegistryObject<Block> CONVEYOR_MK1 = BLOCKS.register("conveyor_mk1",
            () -> new ConveyorMk1(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().destroyTime(1f)));
    public static final RegistryObject<Block> BERYL_NUT_BUSH = BLOCKS.register("beryl_nut_bush",
            () -> new BerylNutBush(BlockBehaviour.Properties.of(Material.WOOD).randomTicks().noOcclusion().destroyTime(2f)));

    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
}
