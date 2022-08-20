package com.hirises.satisfactorymod.blocks.custom.conveyor.entity;

import com.hirises.satisfactorymod.blocks.ModBlockEntities;
import com.hirises.satisfactorymod.blocks.custom.conveyor.block.ConveyorBase;
import com.hirises.satisfactorymod.screen.custom.comveyor.menu.ConveyorBaseMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class ConveyorMk3Entity extends ConveyorBaseEntity{
    public ConveyorMk3Entity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CONVEYOR_MK3.get(), pos, state, 5, 1, 5);
    }

    @Override
    public List<Direction> getOutputDirections(BlockState state) {
        return Arrays.asList(state.getValue(ConveyorBase.OUTPUT));
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("gui.satisfactorymod.conveyor_mk3");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new ConveyorBaseMenu(containerId, inventory, this);
    }
}
