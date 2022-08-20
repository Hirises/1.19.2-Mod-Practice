package com.hirises.satisfactorymod.blocks.custom.conveyor.entity;

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

public class ConveyorMk1Entity extends ConveyorBaseEntity{
    public ConveyorMk1Entity(BlockPos pos, BlockState state) {
        super(pos, state, 10, 1, 5);
    }

    @Override
    public List<Direction> getOutputDirections(BlockState state) {
        return Arrays.asList(state.getValue(ConveyorBase.OUTPUT));
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("gui.satisfactorymod.conveyor_mk1");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new ConveyorBaseMenu(containerId, inventory, this);
    }
}
