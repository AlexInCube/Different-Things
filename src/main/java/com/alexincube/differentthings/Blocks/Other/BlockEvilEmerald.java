package com.alexincube.differentthings.Blocks.Other;



import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import static com.alexincube.differentthings.DifferentThings.CTAB;

public class BlockEvilEmerald extends Block {
    public BlockEvilEmerald(String name)
    {
        super(Material.IRON);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CTAB);
        this.setHardness(3.0F);
        this.setHarvestLevel("pickaxe", 2);

    }



}
