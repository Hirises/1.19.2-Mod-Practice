package com.hirises.satisfactorymod.blocks.custom.conveyor.entity;

import com.google.common.collect.ImmutableList;
import com.hirises.satisfactorymod.blocks.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class ConveyorLikeBaseEntity extends BlockEntity implements MenuProvider {
    protected final ItemStackHandler storage;
    protected LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected int tick;

    public final int itemFlowTick;
    public final int itemFlowCount;
    public final int storageAmount;

    public ConveyorLikeBaseEntity(BlockPos pos, BlockState state){
        this(pos, state, 20, 1, 1);
    }

    public ConveyorLikeBaseEntity(BlockPos pos, BlockState state, int itemFlowTick, int itemFlowCount, int storageAmount) {
        super(ModBlockEntities.CONVEYOR_MK1.get(), pos, state);
        this.itemFlowCount = itemFlowCount;
        this.itemFlowTick = itemFlowTick;
        this.storageAmount = storageAmount;
        storage = new ItemStackHandler(storageAmount){
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> storage);
        super.invalidateCaps();
    }

    @Override
    public void invalidateCaps() {
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("storage", storage.serializeNBT());
        tag.put("tick", IntTag.valueOf(tick));
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        storage.deserializeNBT(tag.getCompound("storage"));
        tick = tag.getInt("tick");
    }

    public void dropStorageItems(){
        SimpleContainer inventory = new SimpleContainer(storage.getSlots());
        for(int i = 0; i < storage.getSlots(); i++){
            inventory.setItem(i, storage.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public boolean isEmpty(){
        for(int i = 0; i < storage.getSlots(); i++){
            if(storage.getStackInSlot(i).isEmpty()){
                return true;
            }
        }
        return false;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ConveyorBaseEntity self){
        if(self.isEmpty()){
            self.tick = 0;
        }else{
            self.flowItem(level, pos, state);
        }
    }

    public void flowItem(Level level, BlockPos pos, BlockState state){
        tick++;
        if(tick % itemFlowTick == 0){
            if(!storage.getStackInSlot(0).isEmpty()){
                flowOutItem(level, pos, state);
                moveItem();
            }
            tick = 0;
        }
    }

    public void flowOutItem(Level level, BlockPos pos, BlockState state){
//        for(Direction dir : getOutputDirections()){
//            BlockEntity target = level.getBlockEntity(pos.relative(dir));
//            if(target != null && target instanceof ConveyorLikeBaseEntity){
//
//            }
//        }
    }

    public void moveItem(){
        for(int i = 1; i < storage.getSlots(); i++){
            ItemStack item = storage.getStackInSlot(i);
            if(storage.getStackInSlot(i - 1).isEmpty()){
                storage.setStackInSlot(i - 1, item);
                storage.setStackInSlot(i, ItemStack.EMPTY);
            }
        }
    }
}
