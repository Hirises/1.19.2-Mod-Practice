package com.hirises.satisfactorymod.blocks.custom.conveyor.block;

import com.hirises.satisfactorymod.blocks.ModBlockEntities;
import com.hirises.satisfactorymod.blocks.custom.conveyor.entity.ConveyorLikeBaseEntity;
import com.hirises.satisfactorymod.blocks.custom.conveyor.entity.ConveyorMk1Entity;
import com.hirises.satisfactorymod.blocks.custom.conveyor.entity.ConveyorMk2Entity;
import com.hirises.satisfactorymod.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

public class ConveyorMk2 extends ConveyorBase {
    public ConveyorMk2(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.CONVEYOR_MK2.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ConveyorMk2Entity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.CONVEYOR_MK2.get(), ConveyorLikeBaseEntity::tick);
    }
}
