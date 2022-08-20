package com.hirises.satisfactorymod.blocks;

import com.hirises.satisfactorymod.SatisfactoryMod;
import com.hirises.satisfactorymod.blocks.custom.conveyor.entity.ConveyorMk1Entity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SatisfactoryMod.MODID);

    public static final RegistryObject<BlockEntityType<ConveyorMk1Entity>> CONVEYOR_MK1 = BLOCK_ENTITIES.register("conveyor_mk1_entity",
            () -> BlockEntityType.Builder
                    .of(ConveyorMk1Entity::new, ModBlocks.CONVEYOR_MK1.get())
                    .build(null)
    );

    public static void register(IEventBus bus){
        BLOCK_ENTITIES.register(bus);
    }
}
