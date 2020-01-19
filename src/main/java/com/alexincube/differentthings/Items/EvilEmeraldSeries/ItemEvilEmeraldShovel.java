package com.alexincube.differentthings.Items.EvilEmeraldSeries;



import net.minecraft.item.ItemSpade;

import static com.alexincube.differentthings.DifferentThings.CTAB;

public class ItemEvilEmeraldShovel extends ItemSpade{
    public ItemEvilEmeraldShovel(ToolMaterial material)
    {
        super(material);
        this.setRegistryName("evilemeraldshovel");
        this.setUnlocalizedName("evilemeraldshovel");
        this.setCreativeTab(CTAB);
    }
}


