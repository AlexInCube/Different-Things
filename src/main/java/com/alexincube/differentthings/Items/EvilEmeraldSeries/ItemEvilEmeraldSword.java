package com.alexincube.differentthings.Items.EvilEmeraldSeries;


import com.alexincube.differentthings.PotionRegister;
import com.alexincube.differentthings.Sounds;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import static com.alexincube.differentthings.DifferentThings.CTAB;


public class ItemEvilEmeraldSword extends ItemSword {
    public ItemEvilEmeraldSword(ToolMaterial material)
    {
        super(material);
        this.setRegistryName("evilemeraldsword");
        this.setUnlocalizedName("evilemeraldsword");
        this.setCreativeTab(CTAB);

    }
}
