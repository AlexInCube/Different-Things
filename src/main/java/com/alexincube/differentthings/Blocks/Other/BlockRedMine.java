package com.alexincube.differentthings.Blocks.Other;



import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static com.alexincube.differentthings.DifferentThings.CTAB;

public class BlockRedMine extends Block {
    public static AxisAlignedBB MODEL_AABB;

    public BlockRedMine(String name, double x1, double y1, double z1, double x2, double y2, double z2)
    {
        super(Material.ROCK);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CTAB);
        this.setHardness(0.0F);
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

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        worldIn.createExplosion(entityIn, entityIn.posX, entityIn.posY , entityIn.posZ, 6.0F, true);
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosionIn) {
        return false;
    }
}
