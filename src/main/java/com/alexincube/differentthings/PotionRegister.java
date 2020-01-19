package com.alexincube.differentthings;

import com.alexincube.differentthings.Items.Potions.CustomPotion;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionRegister {
    public static final Potion YOUR_POTION_EFFECT = new CustomPotion("your_potion",false,13791173,0,0).registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, MathHelper.getRandomUUID().toString(),3,2).registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, MathHelper.getRandomUUID().toString(),3,2);

    public static  final PotionType YOUR_POTION = new PotionType("your_potion", new PotionEffect[] {new PotionEffect(YOUR_POTION_EFFECT,2400)}).setRegistryName("your_potion");

    public  static void  registerPotions(){
        registerPotion(YOUR_POTION, YOUR_POTION_EFFECT);

        registerPotionMixes();
    }

    public  static void registerPotion(PotionType defaultPotion, Potion effect){
        ForgeRegistries.POTIONS.register(effect);
        ForgeRegistries.POTION_TYPES.register(defaultPotion);
    }

    private static void registerPotionMixes(){
        PotionHelper.addMix(YOUR_POTION, Items.REDSTONE, YOUR_POTION);
        PotionHelper.addMix(PotionTypes.AWKWARD, ItemsRegister.ROLTON, YOUR_POTION);
    }
}
