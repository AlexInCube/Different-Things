package com.alexincube.differentthings.Blocks.Other;



import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import static com.alexincube.differentthings.DifferentThings.CTAB;

public class BlockStaffTable extends Block {
    public static AxisAlignedBB MODEL_AABB;

    public BlockStaffTable(String name, double x1, double y1, double z1, double x2, double y2, double z2)
    {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CTAB);
        this.setHardness(2.0F);
        this.setHarvestLevel("pickaxe", 0);
        MODEL_AABB = new AxisAlignedBB(x1, y1, z1, x2, y2, z2);
    }



    @Override
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return MODEL_AABB;
    }
}
