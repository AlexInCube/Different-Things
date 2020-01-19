package com.alexincube.differentthings.Items.Misc;


import com.alexincube.differentthings.PotionRegister;
import com.alexincube.differentthings.Sounds;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import static com.alexincube.differentthings.DifferentThings.CTAB;


public class ItemLightningStaff extends Item {
    public ItemLightningStaff(String name)
    {

        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CTAB);
        this.setMaxDamage(749);
        this.setMaxStackSize(1);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        RayTraceResult result = playerIn.rayTrace(500, 1F);
        int x = result.getBlockPos().getX();
        int y = result.getBlockPos().getY();
        int z = result.getBlockPos().getZ();

        EntityLightningBolt lightning = new EntityLightningBolt(worldIn, x, y, z, false);
        worldIn.addWeatherEffect(lightning);
        itemstack.damageItem(1,playerIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);

    }
}
