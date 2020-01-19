package com.alexincube.differentthings.Items.EvilEmeraldSeries;




import net.minecraft.item.ItemAxe;

import static com.alexincube.differentthings.DifferentThings.CTAB;


public class ItemEvilEmeraldAxe extends ItemAxe
{
    public ItemEvilEmeraldAxe(ToolMaterial material)
    {
        super(material, 9, -3.2F);
        this.setRegistryName("evilemeraldaxe");
        this.setUnlocalizedName("evilemeraldaxe");
        this.setCreativeTab(CTAB);

    }
}
