package com.alexincube.differentthings.Items.Food;


import net.minecraft.item.ItemFood;

import static com.alexincube.differentthings.DifferentThings.CTAB;

public class ItemRolton extends ItemFood {
    public ItemRolton( int amount, float saturation, boolean isWolfFood)
    {
        super(amount, saturation, isWolfFood);
        this.setAlwaysEdible();
        this.setCreativeTab(CTAB);
        this.setRegistryName("rolton");
        this.setUnlocalizedName("rolton");
    }
}
