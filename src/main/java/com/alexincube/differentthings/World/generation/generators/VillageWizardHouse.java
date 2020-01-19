package com.alexincube.differentthings.World.generation.generators;


import com.alexincube.differentthings.BlocksRegister;
import com.alexincube.differentthings.DifferentThings;
import com.alexincube.differentthings.VillagerHandler;
import net.minecraft.block.*;
import net.minecraft.block.BlockDoor.EnumHingePosition;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraft.world.gen.structure.StructureVillagePieces.Village;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class VillageWizardHouse extends Village
{

    public VillageWizardHouse(Start villagePiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, EnumFacing facing)
    {
        super(villagePiece, par2);
        this.setCoordBaseMode(facing);
        this.boundingBox = par4StructureBoundingBox;
    }

    static List<BlockPos> framesHung = new ArrayList();
    private int groundLevel = -1;

    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox box)
    {
        if(groundLevel < 0)
        {
            groundLevel = this.getAverageGroundLevel(world, box);
            if(groundLevel < 0)
                return true;
            boundingBox.offset(0, groundLevel-boundingBox.maxY+9-1, 0);
        }


        IBlockState iblockstate = Blocks.STONEBRICK.getDefaultState();
        IBlockState iblockstate1 = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH));
        IBlockState iblockstate2 = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST));
        IBlockState iblockstate3 = this.getBiomeSpecificBlockState(Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST));
        this.fillWithBlocks(world, boundingBox, 1, 1, 1, 3, 3, 7, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        this.fillWithBlocks(world, boundingBox, 1, 5, 1, 3, 9, 3, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        this.fillWithBlocks(world, boundingBox, 1, 0, 0, 3, 0, 4, iblockstate, iblockstate, false);
        this.fillWithBlocks(world, boundingBox, 1, 1, 0, 3, 10, 0, iblockstate, iblockstate, false);
        this.fillWithBlocks(world, boundingBox, 0, 1, 1, 0, 10, 3, iblockstate, iblockstate, false);
        this.fillWithBlocks(world, boundingBox, 4, 1, 1, 4, 10, 3, iblockstate, iblockstate, false);
        this.fillWithBlocks(world, boundingBox, 1, 1, 4, 3, 3, 4, iblockstate, iblockstate, false);


        this.fillWithBlocks(world, boundingBox, 1, 5, 4, 3, 10, 4, iblockstate, iblockstate, false);

        this.fillWithBlocks(world, boundingBox, 0, 9, 0, 4, 9, 4, iblockstate, iblockstate, false);
        this.fillWithBlocks(world, boundingBox, 0, 4, 0, 4, 4, 4, iblockstate, iblockstate, false);
        this.setBlockState(world, iblockstate, 0, 11, 2, boundingBox);
        this.setBlockState(world, iblockstate, 4, 11, 2, boundingBox);
        this.setBlockState(world, iblockstate, 2, 11, 0, boundingBox);
        this.setBlockState(world, iblockstate, 2, 11, 4, boundingBox);

        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 0, 3, 2, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 4, 2, 2, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 4, 3, 2, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 0, 6, 2, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 0, 7, 2, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 4, 6, 2, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 4, 7, 2, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 2, 6, 0, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 2, 7, 0, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 2, 6, 4, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 2, 7, 4, boundingBox);


        IBlockState iblockstate4 = Blocks.LADDER.getDefaultState().withProperty(BlockLadder.FACING, EnumFacing.WEST);

        for (int i = 1; i <= 9; ++i)
        {
            this.setBlockState(world, iblockstate4, 3, i, 3, boundingBox);
        }

        this.setBlockState(world, Blocks.AIR.getDefaultState(), 2, 1, 0, boundingBox);
        this.setBlockState(world, Blocks.AIR.getDefaultState(), 2, 2, 0, boundingBox);
        this.createVillageDoor(world, boundingBox, rand, 2, 1, 0, EnumFacing.NORTH);

        if (this.getBlockStateFromPos(world, 2, 0, -1, boundingBox).getMaterial() == Material.AIR && this.getBlockStateFromPos(world, 2, -1, -1, boundingBox).getMaterial() != Material.AIR)
        {
            this.setBlockState(world, iblockstate1, 2, 0, -1, boundingBox);

            if (this.getBlockStateFromPos(world, 2, -1, -1, boundingBox).getBlock() == Blocks.GRASS_PATH)
            {
                this.setBlockState(world, Blocks.GRASS.getDefaultState(), 2, -1, -1, boundingBox);
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            for (int j = 0; j < 5; ++j)
            {
                this.clearCurrentPositionBlocksUpwards(world, j, 12, k, boundingBox);
                this.replaceAirAndLiquidDownwards(world, iblockstate, j, -1, k, boundingBox);
            }
        }
        /*this.fillWithBlocks(world, box, 0, 0, 0, 10, 9, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        this.fillWithBlocks(world, box, 1, 0, 1, 8, 0, 8, Blocks.COBBLESTONE.getDefaultState(), Blocks.COBBLESTONE.getDefaultState(), false);
        this.fillWithBlocks(world, box, 1, 0, 0, 8, 0, 0, Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH), Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH), false);
        this.fillWithBlocks(world, box, 1, 0, 9, 8, 0, 9, Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH), Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH), false);
        this.fillWithBlocks(world, box, 0, 0, 0, 9, 0, 9, Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST), Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST), false);
        this.fillWithBlocks(world, box, 0, 0, 9, 9, 0, 9, Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST), Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST), false);
        /*
        //Clear Space
        this.fillWithBlocks(world, box, 0, 0, 0, 10, 9, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        //Cobble
        this.fillWithBlocks(world, box, 1, 0, 1, 9, 0, 8, Blocks.COBBLESTONE.getDefaultState(), Blocks.COBBLESTONE.getDefaultState(), false);
        this.fillWithBlocks(world, box, 6, 0, 1, 9, 0, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        //Stair
        this.setBlockState(world, Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH), 4, 0, 0, box);

        //Pillars
        this.fillWithBlocks(world, box, 1, 1, 3, 1, 4, 3, BlocksRegister.REDPLANKS.getDefaultState(), BlocksRegister.REDPLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 1, 1, 8, 1, 6, 8, BlocksRegister.REDPLANKS.getDefaultState(), BlocksRegister.REDPLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 9, 1, 3, 9, 6, 3, BlocksRegister.REDPLANKS.getDefaultState(), BlocksRegister.REDPLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 9, 1, 8, 9, 6, 8, BlocksRegister.REDPLANKS.getDefaultState(), BlocksRegister.REDPLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 1, 4, 3, 9, 4, 8, BlocksRegister.REDPLANKS.getDefaultState(), BlocksRegister.REDPLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 6, 5, 3, 6, 7, 3, BlocksRegister.REDPLANKS.getDefaultState(), BlocksRegister.REDPLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 1, 5, 5, 1, 6, 5, BlocksRegister.REDPLANKS.getDefaultState(), BlocksRegister.REDPLANKS.getDefaultState(), false);

        this.fillWithBlocks(world, box, 2, 4, 5, 8, 4, 7, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);

        //Wool
        this.fillWithBlocks(world, box, 2, 0, 3, 5, 0, 4, Blocks.WOOL.getStateFromMeta(13), Blocks.WOOL.getStateFromMeta(13), false);
        this.fillWithBlocks(world, box, 2, 0, 4, 8, 0, 7, Blocks.WOOL.getStateFromMeta(13), Blocks.WOOL.getStateFromMeta(13), false);
        this.fillWithBlocks(world, box, 6, 4, 4, 8, 4, 4, Blocks.WOOL.getStateFromMeta(13), Blocks.WOOL.getStateFromMeta(13), false);
        this.fillWithBlocks(world, box, 2, 4, 5, 7, 4, 5, Blocks.WOOL.getStateFromMeta(13), Blocks.WOOL.getStateFromMeta(13), false);
        this.fillWithBlocks(world, box, 2, 4, 6, 6, 4, 6, Blocks.WOOL.getStateFromMeta(13), Blocks.WOOL.getStateFromMeta(13), false);
        this.fillWithBlocks(world, box, 2, 4, 7, 4, 4, 7, Blocks.WOOL.getStateFromMeta(13), Blocks.WOOL.getStateFromMeta(13), false);

        //Walls
        //Front
        this.fillWithBlocks(world, box, 2, 1, 3, 8, 3, 3, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 7, 5, 3, 8, 6, 3, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
        this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 7, 7, 3, box);
        this.fillWithBlocks(world, box, 6, 5, 4, 6, 7, 4, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 2, 5, 5, 5, 6, 5, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 3, 7, 5, 5, 7, 5, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
        this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 8, 5, box);
        //Back
        this.fillWithBlocks(world, box, 2, 1, 8, 8, 3, 8, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 2, 5, 8, 8, 6, 8, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 3, 7, 8, 7, 7, 8, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
        this.setBlockState(world, Blocks.PLANKS.getDefaultState(), 5, 8, 8, box);
        //Left
        this.fillWithBlocks(world, box, 1, 1, 4, 1, 3, 7, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 1, 5, 6, 1, 5, 7, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
        //Right
        this.fillWithBlocks(world, box, 9, 1, 4, 9, 3, 7, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);
        this.fillWithBlocks(world, box, 9, 5, 4, 9, 6, 7, Blocks.PLANKS.getDefaultState(), Blocks.PLANKS.getDefaultState(), false);

        //Windows
        //Front
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 2, 2, 3, box);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 3, box);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 8, 2, 3, box);
        this.fillWithBlocks(world, box, 7, 6, 3, 8, 6, 3, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
        //Back
        this.fillWithBlocks(world, box, 3, 2, 8, 5, 2, 8, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
        this.fillWithBlocks(world, box, 3, 6, 8, 4, 6, 8, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
        this.fillWithBlocks(world, box, 6, 6, 8, 7, 6, 8, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
        //Left
        this.fillWithBlocks(world, box, 1, 2, 5, 1, 2, 6, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
        this.fillWithBlocks(world, box, 1, 6, 6, 1, 6, 7, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
        //Right
        this.fillWithBlocks(world, box, 9, 2, 5, 9, 2, 6, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);
        this.fillWithBlocks(world, box, 9, 6, 5, 9, 6, 6, Blocks.GLASS_PANE.getDefaultState(), Blocks.GLASS_PANE.getDefaultState(), false);

        //Fences
        this.fillWithBlocks(world, box, 1, 1, 1, 1, 1, 2, Blocks.ACACIA_FENCE.getStateFromMeta(0), Blocks.ACACIA_FENCE.getStateFromMeta(0), false);
        this.fillWithBlocks(world, box, 2, 1, 1, 3, 1, 1, Blocks.ACACIA_FENCE.getStateFromMeta(0), Blocks.ACACIA_FENCE.getStateFromMeta(0), false);
        this.fillWithBlocks(world, box, 5, 1, 1, 5, 1, 2, Blocks.ACACIA_FENCE.getStateFromMeta(0), Blocks.ACACIA_FENCE.getStateFromMeta(0), false);
        this.fillWithBlocks(world, box, 1, 5, 3, 1, 5, 4, Blocks.ACACIA_FENCE.getStateFromMeta(0), Blocks.ACACIA_FENCE.getStateFromMeta(0), false);
        this.fillWithBlocks(world, box, 2, 5, 3, 5, 5, 3, Blocks.ACACIA_FENCE.getStateFromMeta(0), Blocks.ACACIA_FENCE.getStateFromMeta(0), false);
        this.fillWithBlocks(world, box, 7, 1, 6, 7, 5, 6, Blocks.ACACIA_FENCE.getStateFromMeta(0), Blocks.ACACIA_FENCE.getStateFromMeta(0), false);

        //Doors
        this.generateDoor(world, box, rand, 4, 1, 3, EnumFacing.NORTH, Blocks.OAK_DOOR);
        if(getCoordBaseMode()==EnumFacing.SOUTH||getCoordBaseMode()==EnumFacing.WEST)
        {
            this.placeDoor(world, box, rand, 3, 5, 5, EnumFacing.NORTH, EnumHingePosition.LEFT);
            this.placeDoor(world, box, rand, 4, 5, 5, EnumFacing.NORTH, EnumHingePosition.RIGHT);
        }
        else
        {
            this.placeDoor(world, box, rand, 3, 5, 5, EnumFacing.NORTH, EnumHingePosition.LEFT);
            this.placeDoor(world, box, rand, 4, 5, 5, EnumFacing.NORTH, EnumHingePosition.RIGHT);
        }



        //Stairs
        IBlockState stairs = Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH);
        setBlockState(world, stairs, 8, 1, 6, box);
        stairs = stairs.withRotation(Rotation.COUNTERCLOCKWISE_90);
//		stairMeta = this.getMetadataWithOffset(Blocks.OAK_STAIRS, 1);
        setBlockState(world, Blocks.PLANKS.getDefaultState(), 8, 1, 7, box);
        setBlockState(world, stairs, 7, 2, 7, box);
        setBlockState(world, stairs, 6, 3, 7, box);
        setBlockState(world, stairs, 5, 4, 7, box);

        //Roof
        IBlockState brickSlab = Blocks.STONE_SLAB.getDefaultState().withProperty(BlockStoneSlab.VARIANT, BlockStoneSlab.EnumType.BRICK);
        IBlockState brickSlabInverted = brickSlab.withProperty(BlockSlab.HALF, EnumBlockHalf.TOP);
        this.fillWithBlocks(world, box, 0, 6, 4, 0, 6, 8, brickSlabInverted, brickSlabInverted, false);
        this.fillWithBlocks(world, box, 1, 7, 4, 1, 7, 8, brickSlab, brickSlab, false);
        this.fillWithBlocks(world, box, 3, 8, 4, 3, 8, 8, brickSlab, brickSlab, false);
        this.fillWithBlocks(world, box, 5, 9, 2, 5, 9, 8, brickSlab, brickSlab, false);
        this.fillWithBlocks(world, box, 7, 8, 2, 7, 8, 8, brickSlab, brickSlab, false);
        this.fillWithBlocks(world, box, 9, 7, 2, 9, 7, 8, brickSlab, brickSlab, false);
        this.fillWithBlocks(world, box, 10, 6, 2, 10, 6, 8, brickSlabInverted, brickSlabInverted, false);

        IBlockState brickStairs = Blocks.BRICK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST);
        this.fillWithBlocks(world, box, 2, 7, 4, 2, 7, 8, brickStairs, brickStairs, false);
        this.fillWithBlocks(world, box, 4, 8, 4, 4, 8, 8, brickStairs, brickStairs, false);
        brickStairs = brickStairs.withRotation(Rotation.CLOCKWISE_180);
        this.fillWithBlocks(world, box, 6, 8, 2, 6, 8, 8, brickStairs, brickStairs, false);
        this.fillWithBlocks(world, box, 8, 7, 2, 8, 7, 8, brickStairs, brickStairs, false);

        this.fillWithBlocks(world, box, 2, 7, 5, 2, 8, 5, Blocks.BRICK_BLOCK.getDefaultState(), Blocks.BRICK_BLOCK.getDefaultState(), false);
        this.fillWithBlocks(world, box, 7, 8, 4, 7, 9, 4, Blocks.BRICK_BLOCK.getDefaultState(), Blocks.BRICK_BLOCK.getDefaultState(), false);

        for(int zz = 0; zz <= 9; zz++)
            for(int xx = 0; xx <= 10; xx++)
            {
                this.clearCurrentPositionBlocksUpwards(world, xx, 10, zz, box);
                this.replaceAirAndLiquidDownwards(world, Blocks.COBBLESTONE.getDefaultState(), xx, -1, zz, box);
            }



        */

        this.spawnVillagers(world, box, 2, 1, 2, 1);
        return true;
    }

    protected void placeDoor(World worldIn, StructureBoundingBox boundingBoxIn, Random rand, int x, int y, int z, EnumFacing facing, EnumHingePosition hinge)
    {
        this.setBlockState(worldIn, Blocks.OAK_DOOR.getDefaultState().withProperty(BlockDoor.FACING, facing).withProperty(BlockDoor.HINGE, hinge), x, y, z, boundingBoxIn);
        this.setBlockState(worldIn, Blocks.OAK_DOOR.getDefaultState().withProperty(BlockDoor.FACING, facing).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER).withProperty(BlockDoor.HINGE, hinge), x, y+1, z, boundingBoxIn);
    }

    @Override
    protected VillagerProfession chooseForgeProfession(int count, net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession prof)
    {
        return VillagerHandler.PROF_WIZARD;
    }
//	protected int func_180779_c(int i, int previousProfession)
//	{
//		//Changed to return Smith while Engineers don't exist
//		return 3;
//		//return Config.getInt("villager_engineer");
//	}

    public static class VillageManager implements VillagerRegistry.IVillageCreationHandler
    {
        @Override
        public Village buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List<StructureComponent> pieces, Random random, int p1, int p2, int p3, EnumFacing facing, int p5)
        {
            StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, 11, 10, 9, facing);
            return (!canVillageGoDeeper(box))||(StructureComponent.findIntersecting(pieces, box)!=null)?null: new VillageWizardHouse(startPiece, p5, random, box, facing);
        }

        @Override
        public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int i)
        {
            return new StructureVillagePieces.PieceWeight(VillageWizardHouse.class, 15, MathHelper.getInt(random, 0+i, 1+i));
        }

        @Override
        public Class<?> getComponentClass()
        {
            return VillageWizardHouse.class;
        }
    }
}
