package com.hirises.satisfactorymod.blocks.custom.conveyor.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public abstract class ConveyorBaseEntity extends ConveyorLikeBaseEntity {

    public ConveyorBaseEntity(BlockPos pos, BlockState state){
        super(pos, state);
    }

    public ConveyorBaseEntity(BlockPos pos, BlockState state, int itemFlowTick, int itemFlowCount, int storageAmount){
        super(pos, state, itemFlowTick, itemFlowCount, storageAmount);
    }
}
