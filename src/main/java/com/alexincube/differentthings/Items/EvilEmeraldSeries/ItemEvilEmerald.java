package com.alexincube.differentthings.Items.EvilEmeraldSeries;



import net.minecraft.item.Item;


import static com.alexincube.differentthings.DifferentThings.CTAB;


public class ItemEvilEmerald extends Item
{
    public ItemEvilEmerald(String name)
    {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CTAB);
        this.setMaxStackSize(64);

    }


}
