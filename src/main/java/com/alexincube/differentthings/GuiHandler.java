package com.alexincube.differentthings;

import com.alexincube.differentthings.Blocks.FunctionalBlocks.BlockBreaker.ContainerBreaker;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.BlockBreaker.GuiBreaker;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.BlockBreaker.TileEntityBreaker;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.DiamondFurnace.ContainerDiamondFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.DiamondFurnace.GuiDiamondFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.DiamondFurnace.TileEntityDiamondFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.EvilEmeraldChest.ContainerEvilEmeraldChest;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.EvilEmeraldChest.GuiEvilEmeraldChest;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.EvilEmeraldChest.TileEntityEvilEmeraldChest;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.GoldFurnace.ContainerGoldFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.GoldFurnace.GuiGoldFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.GoldFurnace.TileEntityGoldFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.IronFurnace.ContainerIronFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.IronFurnace.GuiIronFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.IronFurnace.TileEntityIronFurnace;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.Repairer.ContainerRepairer;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.Repairer.GuiRepairer;
import com.alexincube.differentthings.Blocks.FunctionalBlocks.Repairer.TileEntityRepairer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == DifferentThings.GUI_EVILEMERALD_CHEST) return new ContainerEvilEmeraldChest(player.inventory, (TileEntityEvilEmeraldChest)world.getTileEntity(new BlockPos(x,y,z)),player);
        if(ID == DifferentThings.GUI_IRON_FURNACE) return new ContainerIronFurnace(player.inventory, (TileEntityIronFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        if(ID == DifferentThings.GUI_GOLD_FURNACE) return new ContainerGoldFurnace(player.inventory, (TileEntityGoldFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        if(ID == DifferentThings.GUI_DIAMOND_FURNACE) return new ContainerDiamondFurnace(player.inventory, (TileEntityDiamondFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        if(ID == DifferentThings.GUI_REPAIRER) return new ContainerRepairer(player.inventory, (TileEntityRepairer) world.getTileEntity(new BlockPos(x,y,z)),player);
        if(ID == DifferentThings.GUI_BREAKER) return new ContainerBreaker(player.inventory, (TileEntityBreaker) world.getTileEntity(new BlockPos(x,y,z)),player);
        return null;

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == DifferentThings.GUI_EVILEMERALD_CHEST) return new GuiEvilEmeraldChest(player.inventory, (TileEntityEvilEmeraldChest)world.getTileEntity(new BlockPos(x,y,z)),player);
        if(ID == DifferentThings.GUI_IRON_FURNACE) return new GuiIronFurnace(player.inventory, (TileEntityIronFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        if(ID == DifferentThings.GUI_GOLD_FURNACE) return new GuiGoldFurnace(player.inventory, (TileEntityGoldFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        if(ID == DifferentThings.GUI_DIAMOND_FURNACE) return new GuiDiamondFurnace(player.inventory, (TileEntityDiamondFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        if(ID == DifferentThings.GUI_REPAIRER) return new GuiRepairer(player.inventory, (TileEntityRepairer)world.getTileEntity(new BlockPos(x,y,z)),player);
        if(ID == DifferentThings.GUI_BREAKER) return new GuiBreaker(player.inventory, (TileEntityBreaker) world.getTileEntity(new BlockPos(x,y,z)),player);
        return null;
    }


}
