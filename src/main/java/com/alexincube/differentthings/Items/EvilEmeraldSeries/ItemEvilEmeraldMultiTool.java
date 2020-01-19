package com.alexincube.differentthings.Items.EvilEmeraldSeries;


import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Collections;

import static com.alexincube.differentthings.DifferentThings.CTAB;

public class ItemEvilEmeraldMultiTool extends ItemTool {

    public Item repairItem;
    public static float attack_speed = -2.8F;
    public static float base_damage = 3.0F;

    public ItemEvilEmeraldMultiTool(ToolMaterial material, Item repairItem) {
        super(base_damage, attack_speed, material, Collections.emptySet());
        this.setHarvestLevel("pickaxe", material.getHarvestLevel());
        this.setHarvestLevel("axe", material.getHarvestLevel());
        this.setHarvestLevel("shovel", material.getHarvestLevel());
        this.setRegistryName("evilemeraldmultitool");
        this.setUnlocalizedName("evilemeraldmultitool");
        this.setCreativeTab(CTAB);
        this.repairItem = repairItem;
        this.setMaxDamage(3000);
    }

    protected void func_185071_a(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, IBlockState state) {
        worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

        if (!worldIn.isRemote) {
            worldIn.setBlockState(pos, state, 11);
            stack.damageItem(1, player);
        }
    }




    @Override
    public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
        if (!(state.getMaterial() == Material.AIR) && !(state.getMaterial() == Material.BARRIER)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == repairItem ? true : super.getIsRepairable(toRepair, repair);
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {
        // Only take one damage like a sword instead of 2
        itemStack.damageItem(1, attacker);
        return true;
    }

}
