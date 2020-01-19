package com.alexincube.differentthings.Blocks.FunctionalBlocks.Repairer;

import com.alexincube.differentthings.Blocks.FunctionalBlocks.EvilEmeraldChest.ContainerEvilEmeraldChest;
import com.alexincube.differentthings.DifferentThings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nullable;


public class TileEntityRepairer extends TileEntityLockableLoot implements ITickable  {
    private NonNullList<ItemStack> chestContents = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);
    public int numPlayerUsing, ticksSinceSync;
    public float lidAngle, prevLidAngle;
    public static final int MAX_POWER = 10000;
    public static final int RF_PER_TICK = 1000;
    public static final int RF_PER_TICK_INPUT = 10000;

    @Override
    public int getSizeInventory(){
        return 1;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack: this.chestContents){
            if (!stack.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName:"container.repairer";
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.chestContents=NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

        if(!this.checkLootAndRead(compound)) ItemStackHelper.loadAllItems(compound, chestContents);
        if(compound.hasKey("CustomHame",8)) this.customName = compound.getString("CustomName");
        energyStorage.setEnergy(compound.getInteger("energy"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        if (!this.checkLootAndWrite(compound)) ItemStackHelper.saveAllItems(compound, chestContents);
        if (compound.hasKey("CustomName", 8)) compound.setString("CustomName", this.customName);
        compound.setInteger("energy", energyStorage.getEnergyStored());

        return compound;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerRepairer(playerInventory, this, playerIn);
    }

    @Override
    public String getGuiID() {
        return String.valueOf(DifferentThings.GUI_REPAIRER);
    }

    @Override
    protected NonNullList<ItemStack> getItems(){
        return this.chestContents;
    }

    @Override
    public void update()
    {
        if (!this.world.isRemote) {

            if (energyStorage.getEnergyStored()>= RF_PER_TICK) {

                ItemStack itemstack = this.chestContents.get(0);
                if (!itemstack.isEmpty()) {

                    int itemdamage = itemstack.getItemDamage();
                    if (itemstack.getItemDamage() != 0) {
                        energyStorage.consumerPower(RF_PER_TICK);
                        itemstack.setItemDamage(itemdamage - 1);

                    }


                }
            }
        }
    }

    @Override
    public void openInventory(EntityPlayer player) {
        ++this.numPlayerUsing;
        this.world.addBlockEvent(pos, this.getBlockType(),1, this.numPlayerUsing);
        this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(),false);
    }

    @Override
    public void closeInventory(EntityPlayer player) {
        --this.numPlayerUsing;
        this.world.addBlockEvent(pos, this.getBlockType(),1, this.numPlayerUsing);
        this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(),false);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityEnergy.ENERGY) return true;
        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityEnergy.ENERGY){
            return CapabilityEnergy.ENERGY.cast(energyStorage);
        }
        return super.getCapability(capability, facing);
    }

    private MyEnergyStorage energyStorage = new MyEnergyStorage(MAX_POWER, RF_PER_TICK_INPUT);

    public int getClientEnergy() {
        return energyStorage.getEnergyStored();
    }

    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.energyStorage.getEnergyStored();
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.energyStorage.setEnergy(value);
                break;

        }
    }

    public int getFieldCount()
    {
        return 0;
    }
}
