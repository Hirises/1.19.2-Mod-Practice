package com.hirises.satisfactorymod.blocks.custom.conveyor.block;

import com.hirises.satisfactorymod.blocks.custom.conveyor.entity.ConveyorMk1Entity;
import com.hirises.satisfactorymod.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class ConveyorMk1 extends ConveyorBase {
    public ConveyorMk1(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.CONVEYOR_MK1.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ConveyorMk1Entity(pos, state);
    }
}
