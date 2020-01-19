package com.alexincube.differentthings.Items.EvilEmeraldSeries;


import net.minecraft.item.ItemHoe;

import static com.alexincube.differentthings.DifferentThings.CTAB;


public class ItemEvilEmeraldHoe extends ItemHoe {
    public ItemEvilEmeraldHoe(ToolMaterial material)
    {
        super(material);
        this.setRegistryName("evilemeraldhoe");
        this.setUnlocalizedName("evilemeraldhoe");
        this.setCreativeTab(CTAB);
    }
}
