package com.alexincube.differentthings;

import com.alexincube.differentthings.Blocks.FunctionalBlocks.BlockBreaker.TileEntityBreaker;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.DiamondFurnace.TileEntityDiamondFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.EvilEmeraldChest.TileEntityEvilEmeraldChest;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.GoldFurnace.TileEntityGoldFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.IronFurnace.TileEntityIronFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.Repairer.TileEntityRepairer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityEvilEmeraldChest.class,new ResourceLocation("differentthings:evilemeraldchest"));
        GameRegistry.registerTileEntity(TileEntityIronFurnace.class,new ResourceLocation("differentthings:ironfurnace"));
        GameRegistry.registerTileEntity(TileEntityGoldFurnace.class,new ResourceLocation("differentthings:goldfurnace"));
        GameRegistry.registerTileEntity(TileEntityDiamondFurnace.class,new ResourceLocation("differentthings:diamondfurnace"));
        GameRegistry.registerTileEntity(TileEntityRepairer.class,new ResourceLocation("differentthings:repairer"));
        GameRegistry.registerTileEntity(TileEntityBreaker.class,new ResourceLocation("differentthings:breaker"));
    }
}
