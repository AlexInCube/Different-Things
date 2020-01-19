package com.alexincube.differentthings.Blocks.Other;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import static com.alexincube.differentthings.DifferentThings.CTAB;

public class BlockRedPlanks extends Block {
    public BlockRedPlanks(String name)
    {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CTAB);
        this.setHardness(3.0F);
        this.setHarvestLevel("axe", 0);

    }
}
