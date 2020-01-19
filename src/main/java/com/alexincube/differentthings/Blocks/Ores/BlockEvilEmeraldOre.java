package com.alexincube.differentthings.Blocks.Ores;

import com.alexincube.differentthings.ItemsRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

import static com.alexincube.differentthings.DifferentThings.CTAB;

public class BlockEvilEmeraldOre extends Block {
    public BlockEvilEmeraldOre(String name)
    {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CTAB);
        this.setHardness(5.0F);
        this.setHarvestLevel("pickaxe", 2);

    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return ItemsRegister.EVILEMERALD;
    }

    @Override
    public int quantityDropped(Random rand){
        int max = 4;
        int min = 1;
        return rand.nextInt(max) + min;
    }






}
