package com.alexincube.differentthings;


import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.fml.common.registry.GameRegistry;



public class CraftingRegister
{
    public static void register() {
        registerRecipes("evilemerald");
        registerRecipes("evilemeraldblock");
        registerRecipes("evilemeraldpickaxe");
        registerRecipes("evilemeraldsword");
        registerRecipes("evilemeraldshovel");
        registerRecipes("evilemeraldhoe");
        registerRecipes("evilemeraldaxe");
        registerRecipes("evilemeraldboots");
        registerRecipes("evilemeraldleggs");
        registerRecipes("evilemeraldchestplate");
        registerRecipes("evilemeraldhead");
        GameRegistry.addSmelting(ItemsRegister.CORN, new ItemStack(ItemsRegister.ROLTON), 2F);
        GameRegistry.addSmelting(BlocksRegister.EVILEMERALDORE, new ItemStack(ItemsRegister.EVILEMERALD), 2F);
        GameRegistry.addSmelting(BlocksRegister.REDLOGS, new ItemStack(Items.COAL, 1, 1), 2F);
    }



    private static void registerRecipes(String name)
    {
        CraftingHelper.register(new ResourceLocation("differentthings", name), (IRecipeFactory) (context, json) -> CraftingHelper.getRecipe(json, context));
    }
}
