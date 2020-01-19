package com.alexincube.differentthings;

import com.alexincube.differentthings.World.generation.generators.VillageWizardHouse;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import javax.annotation.Nonnull;
import java.util.Random;

public class VillagerHandler {


    private static final VillagerRegistry VILLAGER_REGISTRY = VillagerRegistry.instance();
    public static VillagerRegistry.VillagerProfession PROF_WIZARD;

    @GameRegistry.ObjectHolder("minecraft:librarian")
    public static final VillagerRegistry.VillagerProfession LIBRARIAN = null;

    public static void initIEVillagerHouse()
    {
        VILLAGER_REGISTRY.registerVillageCreationHandler(new VillageWizardHouse.VillageManager());
        MapGenStructureIO.registerStructureComponent(VillageWizardHouse.class, DifferentThings.MODID+":WizardHouse");
    }

    public static void initVillagerTrades()
    {

        PROF_WIZARD = new VillagerRegistry.VillagerProfession(DifferentThings.MODID+":wizard", "differentthings:textures/models/villager_wizard.png", "differentthings:textures/models/zombie_villager_wizard.png");
        ForgeRegistries.VILLAGER_PROFESSIONS.register(PROF_WIZARD);

        //Wizard
        VillagerRegistry.VillagerCareer career_wizard = new VillagerRegistry.VillagerCareer(PROF_WIZARD, DifferentThings.MODID+".wizard");
        career_wizard.addTrade(1,
                new EmeraldForItemstack(new ItemStack(ItemsRegister.EVILEMERALD, 6, 0), new EntityVillager.PriceInfo(1, 3)),
                new ItemstackForEmerald(new ItemStack(Items.EMERALD, 1, 0), new EntityVillager.PriceInfo(15, 20), ItemsRegister.LIGHTNINGSTAFF)


        );
        career_wizard.addTrade(2,
                new EmeraldForItemstack(new ItemStack(ItemsRegister.EVILEMERALDAXE, 1, 1), new EntityVillager.PriceInfo(2, 6))

        );
        career_wizard.addTrade(3,
                new EmeraldForItemstack(new ItemStack(ItemsRegister.EVILEMERALDAXE, 1, 2), new EntityVillager.PriceInfo(2, 6)),
                new EmeraldForItemstack(new ItemStack(ItemsRegister.EVILEMERALDAXE, 1, 7), new EntityVillager.PriceInfo(4, 8))

        );
    }

    private static class EmeraldForItemstack implements EntityVillager.ITradeList
    {
        public ItemStack buyingItem;
        public EntityVillager.PriceInfo buyAmounts;

        public EmeraldForItemstack(@Nonnull ItemStack item, @Nonnull EntityVillager.PriceInfo buyAmounts)
        {
            this.buyingItem = item;
            this.buyAmounts = buyAmounts;
        }

        @Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            recipeList.add(new MerchantRecipe(copyStackWithAmount(this.buyingItem, this.buyAmounts.getPrice(random)), Items.EMERALD));
        }
    }

    private static class ItemstackForEmerald implements EntityVillager.ITradeList
    {
        private final Item item1;
        public ItemStack buyingItem;
        public EntityVillager.PriceInfo buyAmounts;

        public ItemstackForEmerald(@Nonnull ItemStack item, @Nonnull EntityVillager.PriceInfo buyAmounts, Item item1)
        {
            this.buyingItem = item;
            this.buyAmounts = buyAmounts;
            this.item1=item1;
        }

        @Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            recipeList.add(new MerchantRecipe(copyStackWithAmount(this.buyingItem, this.buyAmounts.getPrice(random)), item1));
        }
    }

    public static ItemStack copyStackWithAmount(ItemStack stack, int amount)
    {
        if(stack.isEmpty())
            return ItemStack.EMPTY;
        ItemStack s2 = stack.copy();
        s2.setCount(amount);
        return s2;
    }




}
