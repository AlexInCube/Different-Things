package com.alexincube.differentthings.World.generation.generators;

import com.alexincube.differentthings.BlocksRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedFlower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WorldGenBush implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {
            generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }


    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateBlockOnTop(world, random, chunkX * 16, chunkZ * 16, 30, BlocksRegister.BLOCKVEGETABLEBUSH.getDefaultState(), BiomePlains.class);
    }


    private void generateBlockOnTop(World worldIn, Random rand, int x, int z, int chances, IBlockState block, Class<?>... classes) {
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

        int y = worldIn.getActualHeight();

        BlockPos position = new BlockPos(x + rand.nextInt(16), y + rand.nextInt(y), z + rand.nextInt(16));
        for (IBlockState iblockstate = worldIn.getBlockState(position); (iblockstate.getBlock().isAir(iblockstate, worldIn, position) || iblockstate.getBlock().isLeaves(iblockstate, worldIn, position)) && position.getY() > 0; iblockstate = worldIn.getBlockState(position)) {
            position = position.down();
        }

        Class<?> biome = worldIn.provider.getBiomeForCoords(position).getClass();
        if (worldIn.getWorldType() != WorldType.FLAT) {
            if (classesList.contains(biome)) {
                for (int i = 0; i < chances; ++i) {
                    BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), 1, rand.nextInt(8) - rand.nextInt(8));

                    if (worldIn.isAirBlock(blockpos) && Blocks.DEADBUSH.canBlockStay(worldIn, blockpos, Blocks.DEADBUSH.getDefaultState())) {
                        worldIn.setBlockState(blockpos, block, 2);
                    }
                }
            }
        }
    }
}




