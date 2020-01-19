package com.alexincube.differentthings;


import net.minecraft.block.BlockSapling;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.Random;


@Mod(modid = DifferentThings.MODID, name = DifferentThings.NAME, version = DifferentThings.VERSION, acceptedMinecraftVersions = DifferentThings.ACCEPTED_MINECRAFT_VERSION)
public class DifferentThings
{
    @Mod.Instance("differentthings")
    public static DifferentThings instance;

    public static final String MODID = "differentthings";
    public static final String NAME = "Different Things";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_MINECRAFT_VERSION = "1.12.2";

    @SidedProxy(clientSide = "com.alexincube.differentthings.ClientProxy", serverSide = "com.alexincube.differentthings.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);

    }



    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }

    public static final CreativeTabs CTAB = new CreativeTabs("differentthings")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(ItemsRegister.EVILEMERALD);
        }
    };

    public static final int GUI_EVILEMERALD_CHEST = 1;
    public static final int GUI_IRON_FURNACE = 2;
    public static final int GUI_GOLD_FURNACE = 3;
    public static final int GUI_DIAMOND_FURNACE = 4;
    public static final int GUI_REPAIRER = 5;
    public static final int GUI_BREAKER = 6;

    static {
        FluidRegistry.enableUniversalBucket();
    }
}





