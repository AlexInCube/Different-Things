package com.alexincube.differentthings.Items.EvilEmeraldSeries;


import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;


import static com.alexincube.differentthings.DifferentThings.CTAB;

public class ItemEvilEmeraldArmor extends ItemArmor
{
    public ItemEvilEmeraldArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
    {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CTAB);
    }
}
