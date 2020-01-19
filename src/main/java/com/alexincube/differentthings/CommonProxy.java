package com.alexincube.differentthings;

import com.alexincube.differentthings.World.generation.generators.WorldGenBush;
import com.alexincube.differentthings.World.generation.WorldGenCustomTrees;
import com.alexincube.differentthings.World.generation.WorldGenOres;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        Sounds.registerSounds();
        ItemsRegister.register();
        BlocksRegister.register();
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
        PotionRegister.registerPotions();
        NetworkRegistry.INSTANCE.registerGuiHandler(DifferentThings.instance, new GuiHandler());

        TileEntityHandler.registerTileEntities();
        GameRegistry.registerWorldGenerator(new WorldGenOres(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenBush(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenCustomTrees(), 0);
        VillagerHandler.initIEVillagerHouse();
        VillagerHandler.initVillagerTrades();
    }

    public void init(FMLInitializationEvent event)
    {
        CraftingRegister.register();
        OreDictionaryCompatibility.registerOreDictionary();

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}
