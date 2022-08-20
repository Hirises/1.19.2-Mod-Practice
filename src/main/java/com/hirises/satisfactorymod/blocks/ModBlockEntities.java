package com.hirises.satisfactorymod.blocks;

import com.hirises.satisfactorymod.SatisfactoryMod;
import com.hirises.satisfactorymod.blocks.custom.conveyor.entity.ConveyorMk1Entity;
import com.hirises.satisfactorymod.blocks.custom.conveyor.entity.ConveyorMk2Entity;
import com.hirises.satisfactorymod.blocks.custom.conveyor.entity.ConveyorMk3Entity;
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
    public static final RegistryObject<BlockEntityType<ConveyorMk2Entity>> CONVEYOR_MK2 = BLOCK_ENTITIES.register("conveyor_mk2_entity",
            () -> BlockEntityType.Builder
                    .of(ConveyorMk2Entity::new, ModBlocks.CONVEYOR_MK2.get())
                    .build(null)
    );
    public static final RegistryObject<BlockEntityType<ConveyorMk3Entity>> CONVEYOR_MK3 = BLOCK_ENTITIES.register("conveyor_mk3_entity",
            () -> BlockEntityType.Builder
                    .of(ConveyorMk3Entity::new, ModBlocks.CONVEYOR_MK3.get())
                    .build(null)
    );

    public static void register(IEventBus bus){
        BLOCK_ENTITIES.register(bus);
    }
}
