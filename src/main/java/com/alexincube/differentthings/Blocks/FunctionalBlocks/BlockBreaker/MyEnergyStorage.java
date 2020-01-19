package com.alexincube.differentthings.Blocks.FunctionalBlocks.BlockBreaker;

import net.minecraftforge.energy.EnergyStorage;

public class MyEnergyStorage extends EnergyStorage {
    public MyEnergyStorage(int capacity,int maxReceive){
        super(capacity, maxReceive);
    }

    public void setEnergy(int energy){
        this.energy = energy;
    }

    public  void  consumerPower(int energy){
        this.energy -= energy;
        if (this.energy < 0){
            this.energy = 0;
        }
    }
}
