package com.alexincube.differentthings.Items.Misc.FurnaceUpgrades;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static com.alexincube.differentthings.DifferentThings.CTAB;


public class ItemFurnaceFuelUpgrade extends Item
{
    public static float fuelcostmultiplier=0.4f;
    public ItemFurnaceFuelUpgrade(String name)
    {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CTAB);
        this.setMaxStackSize(1);
    }

    public float getfuelcost(){
        return this.fuelcostmultiplier;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Increase fuel burn time by 40%");
    }
}