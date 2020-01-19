package com.alexincube.differentthings.Items.Food;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;


import static com.alexincube.differentthings.DifferentThings.CTAB;

public class ItemCorn extends ItemFood {

    public ItemCorn(String name, int hungerPointsRestoration, float saturationPointsRestoration, boolean isSuitableForWolves) {

        super(hungerPointsRestoration, saturationPointsRestoration, isSuitableForWolves);

        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(CTAB);
    }

    @Override
    public int getItemBurnTime(ItemStack itemStack) { // Переопределение времени горения.
        return 200; //200 - это кол-во тиков за 1 предмет. 400 - это 2 предмета, 600 - это 3 и так далее!
    }
}
