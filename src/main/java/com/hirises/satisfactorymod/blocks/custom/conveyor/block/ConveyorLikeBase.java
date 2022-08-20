package com.hirises.satisfactorymod.blocks.custom.conveyor.block;

import com.hirises.satisfactorymod.blocks.ModBlockEntities;
import com.hirises.satisfactorymod.blocks.custom.conveyor.entity.ConveyorBaseEntity;
import com.hirises.satisfactorymod.blocks.custom.conveyor.entity.ConveyorLikeBaseEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;

/**
 * 컨베이어처럼 동작하는 블럭 베이스 (ex 컨베이어, 분배기등등
 */
public abstract class ConveyorLikeBase extends BaseEntityBlock {
    private final ItemStackHandler container = new ItemStackHandler(1);

    protected ConveyorLikeBase(Properties properties) {
        super(properties);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if(state.getBlock() != newState.getBlock()){
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity != null && entity instanceof ConveyorLikeBaseEntity){
                ((ConveyorLikeBaseEntity)entity).dropStorageItems();
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(!level.isClientSide){
            BlockEntity entity = level.getBlockEntity(pos);
            if(entity instanceof ConveyorLikeBaseEntity){
                NetworkHooks.openScreen(((ServerPlayer) player), (ConveyorLikeBaseEntity)entity, pos);
            }else{
                throw new IllegalStateException("illegal block entity type! expected: ConveyorLikeBaseEntity provided: " + entity.getClass().getSimpleName());
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }
}
