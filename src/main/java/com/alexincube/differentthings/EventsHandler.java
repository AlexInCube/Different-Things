package com.alexincube.differentthings;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventsHandler {

    @SubscribeEvent
    public void onDeath(LivingDeathEvent e)
    {
        if (e.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) e.getEntity();

            if (player.getName().equals("AlexInCube"))
            {
                player.dropItem(new ItemStack(Items.GOLDEN_APPLE, 1, 1), false);
            }
        }
    }

    @SubscribeEvent
    public void onLootTablesLoaded(LootTableLoadEvent event) {

        if (event.getName().equals(LootTableList.CHESTS_SPAWN_BONUS_CHEST)) {

            final LootPool pool2 = event.getTable().getPool("pool2");

            if (pool2 != null) {

                // pool2.addEntry(new LootEntryItem(ITEM, WEIGHT, QUALITY, FUNCTIONS, CONDITIONS, NAME));
                pool2.addEntry(new LootEntryItem(ItemsRegister.CORN, 10, 0, new LootFunction[0], new LootCondition[0], "loottable:corn"));
            }
        }
    }

    @SubscribeEvent
    public static void yourPotionActive(TickEvent.PlayerTickEvent event){
        boolean isActive = false;
        if(event.player.isPotionActive(PotionRegister.YOUR_POTION_EFFECT)) isActive = true;

        if(isActive){

        }
    }
}
