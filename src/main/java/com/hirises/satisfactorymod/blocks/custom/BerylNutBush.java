package com.hirises.satisfactorymod.blocks.custom;

import com.hirises.satisfactorymod.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BerylNutBush extends BushBlock implements BonemealableBlock {
    public static final BooleanProperty RIPE = BooleanProperty.create("ripe");
    private static final  VoxelShape NORMAL_SHAPE = Block.box(2.0D, 2.0D, 2.0D, 14.0D, 14.0D, 14.0D);

    public BerylNutBush(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(RIPE, Boolean.valueOf(false)));
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(ModItems.BERYL_NUT.get());
    }

    public VoxelShape getShape(BlockState p_57291_, BlockGetter p_57292_, BlockPos p_57293_, CollisionContext p_57294_) {
        return NORMAL_SHAPE;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(RIPE).booleanValue();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos blockPos, RandomSource random) {
        if (!state.getValue(RIPE).booleanValue() && level.getRawBrightness(blockPos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, blockPos, state, random.nextInt(5) == 0)) {
            BlockState newState = state.setValue(RIPE, Boolean.valueOf(true));
            level.setBlock(blockPos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(newState));
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, blockPos, state);
        }
    }

    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult result) {
        if (state.getValue(RIPE).booleanValue()) {
            int j = 3 + level.random.nextInt(3);
            popResource(level, blockPos, new ItemStack(ModItems.BERYL_NUT.get(), j));
            level.playSound((Player)null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState newState = state.setValue(RIPE, Boolean.valueOf(false));
            level.setBlock(blockPos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, newState));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(state, level, blockPos, player, hand, result);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(RIPE);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter p_50897_, BlockPos p_50898_, BlockState state, boolean p_50900_) {
        return !state.getValue(RIPE).booleanValue();
    }

    @Override
    public boolean isBonemealSuccess(Level p_220878_, RandomSource p_220879_, BlockPos p_220880_, BlockState p_220881_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos blockPos, BlockState state) {
        if (!state.getValue(RIPE).booleanValue()) {
            BlockState newState = state.setValue(RIPE, Boolean.valueOf(true));
            level.setBlock(blockPos, newState, 2);
        }
    }
}
