package com.hirises.satisfactorymod.blocks.custom.conveyor.entity;

import com.hirises.satisfactorymod.screen.custom.comveyor.menu.ConveyorBaseMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ConveyorMk1Entity extends ConveyorBaseEntity{
    public ConveyorMk1Entity(BlockPos pos, BlockState state) {
        super(pos, state, 20, 1, 4);
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
