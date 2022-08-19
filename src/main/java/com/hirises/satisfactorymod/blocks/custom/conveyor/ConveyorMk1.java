package com.hirises.satisfactorymod.blocks.custom.conveyor;

import com.hirises.satisfactorymod.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;

public class ConveyorMk1 extends ConveyorBlockBase {
    public ConveyorMk1(Properties properties) {
        super(properties);
    }

    @Override
    public int getItemPerMinute() {
        return 60;
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.CONVEYOR_MK1.get());
    }
}