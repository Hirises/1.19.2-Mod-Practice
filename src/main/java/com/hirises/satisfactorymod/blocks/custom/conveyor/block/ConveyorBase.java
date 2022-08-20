package com.hirises.satisfactorymod.blocks.custom.conveyor.block;

import com.hirises.satisfactorymod.blocks.custom.conveyor.entity.ConveyorBaseEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 컨베이어 클래스
 */
public abstract class ConveyorBase extends ConveyorLikeBase {
    public static final EnumProperty<Direction> OUTPUT = EnumProperty.create("output", Direction.class, Direction.Plane.HORIZONTAL);

    protected static final VoxelShape NORTH_SOUTH = Block.box(2, 3, 0, 14, 8, 16);
    protected static final VoxelShape EAST_WEST = Block.box(0, 3, 2, 16, 8, 14);

    public ConveyorBase(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(OUTPUT, Direction.SOUTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return getVoxelShape(state);
    }

    @Override
    public VoxelShape getInteractionShape(BlockState state, BlockGetter p_60548_, BlockPos p_60549_) {
        return getVoxelShape(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection();
        return this.defaultBlockState().setValue(OUTPUT, direction);
    }

    protected VoxelShape getVoxelShape(BlockState state){
        Direction output = state.getValue(OUTPUT);

        if(output.equals(Direction.NORTH) || output.equals(Direction.SOUTH)){
            return NORTH_SOUTH;
        }else{
            return EAST_WEST;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(OUTPUT);
    }
}
