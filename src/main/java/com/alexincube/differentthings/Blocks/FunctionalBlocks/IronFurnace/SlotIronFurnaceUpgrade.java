package com.alexincube.differentthings.Blocks.FunctionalBlocks.IronFurnace;

import com.alexincube.differentthings.ItemsRegister;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotIronFurnaceUpgrade extends Slot
{
    public SlotIronFurnaceUpgrade(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    public boolean isItemValid(ItemStack stack)
    {
        return TileEntityIronFurnace.isItemFuel(stack) || isBucket(stack);
    }

    public int getItemStackLimit(ItemStack stack)
    {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack)
    {
        return (stack.getItem() == ItemsRegister.UPGRADEFURNACEFUEL) || (stack.getItem() == ItemsRegister.UPGRADEFURNACECOOKTIME);
    }
}
