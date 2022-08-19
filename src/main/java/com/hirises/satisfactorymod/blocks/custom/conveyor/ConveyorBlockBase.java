package com.hirises.satisfactorymod.blocks.custom.conveyor;

import com.hirises.satisfactorymod.SatisfactoryMod;
import com.hirises.satisfactorymod.items.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class ConveyorBlockBase extends ConveyorLikeBlockBase {
    public static final EnumProperty<Direction> INPUT = EnumProperty.create("input", Direction.class, Direction.Plane.HORIZONTAL);
    public static final EnumProperty<Direction> OUTPUT = EnumProperty.create("output", Direction.class, Direction.Plane.HORIZONTAL);

    //3,8 나의x에게
    protected static final VoxelShape NORTH = Block.box(2, 3, 0, 14, 8, 14);
    protected static final VoxelShape SOUTH = Block.box(2, 3, 2, 14, 8, 16);
    protected static final VoxelShape EAST = Block.box(2, 3, 2, 16, 8, 14);
    protected static final VoxelShape WEST = Block.box(0, 3, 2, 14, 8, 14);

    protected static final VoxelShape NORTH_SOUTH = Shapes.or(NORTH, SOUTH);
    protected static final VoxelShape EAST_WEST = Shapes.or(EAST, WEST);
    protected static final VoxelShape SOUTH_EAST = Shapes.or(SOUTH, EAST);
    protected static final VoxelShape SOUTH_WEST = Shapes.or(SOUTH, WEST);
    protected static final VoxelShape NORTH_WEST = Shapes.or(NORTH, WEST);
    protected static final VoxelShape NORTH_EAST = Shapes.or(NORTH, EAST);

    public ConveyorBlockBase(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(INPUT, Direction.NORTH).setValue(OUTPUT, Direction.SOUTH));
    }

    public abstract int getItemPerMinute();

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
        return this.defaultBlockState().setValue(OUTPUT, direction).setValue(INPUT, direction.getOpposite());
    }

    protected VoxelShape getVoxelShape(BlockState state){
        Direction input = state.getValue(INPUT);
        Direction output = state.getValue(OUTPUT);

        if(input.equals(Direction.NORTH) && output.equals(Direction.SOUTH) || output.equals(Direction.NORTH) && input.equals(Direction.SOUTH)){
            return NORTH_SOUTH;
        }else if(input.equals(Direction.EAST) && output.equals(Direction.WEST) || output.equals(Direction.EAST) && input.equals(Direction.WEST)){
            return EAST_WEST;
        }else if(input.equals(Direction.SOUTH) && output.equals(Direction.EAST) || output.equals(Direction.SOUTH) && input.equals(Direction.EAST)){
            return SOUTH_EAST;
        }else if(input.equals(Direction.SOUTH) && output.equals(Direction.WEST) || output.equals(Direction.SOUTH) && input.equals(Direction.WEST)){
            return SOUTH_WEST;
        }else if(input.equals(Direction.NORTH) && output.equals(Direction.WEST) || output.equals(Direction.NORTH) && input.equals(Direction.WEST)){
            return NORTH_WEST;
        }else{
            return NORTH_EAST;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(INPUT, OUTPUT);
    }
}
