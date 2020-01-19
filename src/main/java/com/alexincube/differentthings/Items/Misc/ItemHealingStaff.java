package com.alexincube.differentthings.Items.Misc;


import com.alexincube.differentthings.ItemsRegister;
import com.alexincube.differentthings.PotionRegister;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Collections;

import static com.alexincube.differentthings.DifferentThings.CTAB;


public class ItemHealingStaff extends ItemTool {


    public ItemHealingStaff(String name)
    {
        super(-3, -3, ToolMaterial.DIAMOND, Collections.emptySet());
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CTAB);
        this.setMaxDamage(749);
        this.setMaxStackSize(1);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);


        playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 1));
        itemstack.damageItem(1,playerIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase target, EntityLivingBase attacker) {
        target.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 1));
        itemStack.damageItem(1, attacker);
        return true;
    }
}
