package com.alexincube.differentthings.Blocks.FunctionalBlocks.BlockBreaker;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotRepairItem extends Slot
{
    public SlotRepairItem(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    public boolean isItemValid(ItemStack stack)
    {
        return stack.getItem().isDamageable();
    }

    public int getItemStackLimit(ItemStack stack)
    {
         return super.getItemStackLimit(stack);
    }
}
