package com.alexincube.differentthings.Items.Misc.FurnaceUpgrades;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static com.alexincube.differentthings.DifferentThings.CTAB;


public class ItemFurnaceCookTimeUpgrade extends Item
{
    public static double cooktimemultiplier=0.1;
    public ItemFurnaceCookTimeUpgrade(String name)
    {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CTAB);
        this.setMaxStackSize(1);

    }
    public double getcooktimemultiplier(){
        return this.cooktimemultiplier;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Reduces smelt time by 10%");
    }
}