package com.alexincube.differentthings;

import com.alexincube.differentthings.Blocks.Agriculture.Plants.BlockCropCorn;
import com.alexincube.differentthings.Blocks.Agriculture.Plants.BlockVegetableBush;
import com.alexincube.differentthings.Blocks.Agriculture.Trees.BlockRedLeaves;
import com.alexincube.differentthings.Blocks.Agriculture.Trees.BlockRedLogs;
import com.alexincube.differentthings.Blocks.Agriculture.Trees.BlockRedSapling;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.BlockBreaker.BlockBreaker;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.DiamondFurnace.BlockDiamondFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.EvilEmeraldChest.BlockEvilEmeraldChest;


import com.alexincube.differentthings.Blocks.FunctionalBlocks.GoldFurnace.BlockGoldFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.IronFurnace.BlockIronFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.Repairer.BlockRepairer;
import com.alexincube.differentthings.Blocks.Ores.BlockEvilEmeraldOre;
import com.alexincube.differentthings.Blocks.Other.BlockEvilEmerald;
import com.alexincube.differentthings.Blocks.Other.BlockRedMine;
import com.alexincube.differentthings.Blocks.Other.BlockRedPlanks;
import com.alexincube.differentthings.Blocks.Other.BlockStaffTable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBanner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.alexincube.differentthings.DifferentThings.CTAB;

public class BlocksRegister
{
    public static Block EVILEMERALDBLOCK = new BlockEvilEmerald("evilemeraldblock");
    public static Block EVILEMERALDORE = new BlockEvilEmeraldOre("evilemeraldore");
    public static Block CROP_CORN = new BlockCropCorn("crop_corn");
    public static Block EVILEMERALDCHEST = new BlockEvilEmeraldChest("evilemeraldchest");

    public static Block REDPLANKS = new BlockRedPlanks("redplanks");
    public static Block REDLOGS = new BlockRedLogs("redlogs");
    public static Block REDLEAVES = new BlockRedLeaves("redleaves");
    public static Block REDSAPLING = new BlockRedSapling("redsapling");

    public static Block BLOCKVEGETABLEBUSH = new BlockVegetableBush("vegetablebush");
    public static Block BLOCKSTAFFTABLE = new BlockStaffTable("stafftable", 0, 0, 0, 2, 1, 1);
    public static Block BLOCKREDMINE = new BlockRedMine("redmine", 0, 0, 0, 1, 0.2, 1);

    public static Block IRONFURNACE = new BlockIronFurnace(false, "ironfurnace").setCreativeTab(CTAB);;
    public static Block LITIRONFURNACE = new BlockIronFurnace(true, "lit_ironfurnace").setLightLevel(0.875F);
    public static Block GOLDFURNACE = new BlockGoldFurnace(false, "goldfurnace").setCreativeTab(CTAB);;
    public static Block LITGOLDFURNACE = new BlockGoldFurnace(true, "lit_goldfurnace").setLightLevel(0.875F);
    public static Block DIAMONDFURNACE = new BlockDiamondFurnace(false, "diamondfurnace").setCreativeTab(CTAB);;
    public static Block LITDIAMONDFURNACE = new BlockDiamondFurnace(true, "lit_diamondfurnace").setLightLevel(0.875F);

    public static Block REPAIRER = new BlockRepairer("repairer");
    public static Block BREAKER = new BlockBreaker("breaker");


    public static void register()
    {

        setRegister(EVILEMERALDBLOCK);
        setRegister(EVILEMERALDORE);
        setRegister(CROP_CORN);
        setRegister(EVILEMERALDCHEST);
        setRegister(REDPLANKS);
        setRegister(REDLOGS);
        setRegister(REDLEAVES);
        setRegister(REDSAPLING);
        setRegister(BLOCKVEGETABLEBUSH);
        setRegister(BLOCKSTAFFTABLE);
        setRegister(BLOCKREDMINE);
        setRegister(IRONFURNACE);
        setRegister(LITIRONFURNACE);
        setRegister(GOLDFURNACE);
        setRegister(LITGOLDFURNACE);
        setRegister(DIAMONDFURNACE);
        setRegister(LITDIAMONDFURNACE);
        setRegister(REPAIRER);
        setRegister(BREAKER);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {

        setRender(EVILEMERALDBLOCK);
        setRender(EVILEMERALDORE);
        setRender(CROP_CORN);
        setRender(EVILEMERALDCHEST);
        setRender(REDPLANKS);
        setRender(REDLOGS);
        setRender(REDLEAVES);
        setRender(REDSAPLING);
        setRender(BLOCKVEGETABLEBUSH);
        setRender(BLOCKSTAFFTABLE);
        setRender(BLOCKREDMINE);
        setRender(IRONFURNACE);
        setRender(LITIRONFURNACE);
        setRender(GOLDFURNACE);
        setRender(LITGOLDFURNACE);
        setRender(DIAMONDFURNACE);
        setRender(LITDIAMONDFURNACE);
        setRender(REPAIRER);
        setRender(BREAKER);
    }

    private static void setRegister(Block block)
    {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Block block)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}
