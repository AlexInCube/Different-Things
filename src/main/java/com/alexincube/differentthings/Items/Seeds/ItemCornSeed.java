package com.alexincube.differentthings.Items.Seeds;

import com.alexincube.differentthings.BlocksRegister;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.alexincube.differentthings.DifferentThings.CTAB;

public class ItemCornSeed extends ItemSeeds {

    public ItemCornSeed(String name) {

        super(BlocksRegister.CROP_CORN, Blocks.FARMLAND);

        setUnlocalizedName(name);
        setRegistryName(name);
        this.setCreativeTab(CTAB);
    }

    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos position, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        ItemStack itemStack = player.getHeldItem(hand);

        IBlockState blockState = world.getBlockState(position);

        if (facing == EnumFacing.UP && player.canPlayerEdit(position.offset(facing), facing, itemStack) && blockState.getBlock() == Blocks.FARMLAND && world.isAirBlock(position.up())) {

            world.setBlockState(position.up(), this.getPlant(world, position));

            if (player instanceof EntityPlayerMP) {

                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, position.up(), itemStack);
            }

            itemStack.shrink(1);

            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.FAIL;
    }
}
