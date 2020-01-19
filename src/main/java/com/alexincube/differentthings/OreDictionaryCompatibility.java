package com.alexincube.differentthings;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryCompatibility {
    public static void registerOreDictionary()
    {
        OreDictionary.registerOre("plankWood",BlocksRegister.REDPLANKS);
        OreDictionary.registerOre("logWood",BlocksRegister.REDLOGS);
        OreDictionary.registerOre("treeLeaves",BlocksRegister.REDLEAVES);
        OreDictionary.registerOre("treeSapling",BlocksRegister.REDSAPLING);
    }
}
