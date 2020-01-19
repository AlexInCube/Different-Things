package com.alexincube.differentthings;

import com.alexincube.differentthings.Items.EvilEmeraldSeries.*;
import com.alexincube.differentthings.Items.Food.ItemCorn;
import com.alexincube.differentthings.Items.Food.ItemRolton;
import com.alexincube.differentthings.Items.Misc.FurnaceUpgrades.ItemFurnaceCookTimeUpgrade;
import com.alexincube.differentthings.Items.Misc.FurnaceUpgrades.ItemFurnaceFuelUpgrade;
import com.alexincube.differentthings.Items.Misc.ItemHealingStaff;
import com.alexincube.differentthings.Items.Misc.ItemLightningStaff;
import com.alexincube.differentthings.Items.Misc.ItemMusicDisc;
import com.alexincube.differentthings.Items.Seeds.ItemCornSeed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ItemsRegister
{
    public static Item EVILEMERALD = new ItemEvilEmerald("evilemerald");
    public static Item ROLTON = new ItemRolton(1, 0.5F, false);
    public static Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial("differentthings:evilemeraldtool", 3, 2000, 12, 4, 15).setRepairItem(new ItemStack(EVILEMERALD));
    public static final Item EVILEMERALDAXE = new ItemEvilEmeraldAxe(toolMaterial);
    public static final Item EVILEMERALDPICKAXE = new ItemEvilEmeraldPickaxe(toolMaterial);
    public static final Item EVILEMERALDSHOVEL = new ItemEvilEmeraldShovel(toolMaterial);
    public static final Item EVILEMERALDHOE = new ItemEvilEmeraldHoe(toolMaterial);
    public static final Item EVILEMERALDSWORD = new ItemEvilEmeraldSword(toolMaterial);
    public static final Item EVILEMERALDMULTITOOL = new ItemEvilEmeraldMultiTool(toolMaterial,EVILEMERALD);
    public static ItemArmor.ArmorMaterial armorMaterial = EnumHelper.addArmorMaterial("differentthings:evilemeraldarmor", "differentthings:evilemeraldarmor", 70, new int[]{3, 5, 8, 4}, 7, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F).setRepairItem(new ItemStack(ItemsRegister.EVILEMERALD));

    public static Item EVILEMERALDBOOTS = new ItemEvilEmeraldArmor("evilemeraldboots", armorMaterial, 1, EntityEquipmentSlot.FEET);
    public static Item EVILEMERALDLEGGS = new ItemEvilEmeraldArmor("evilemeraldleggs", armorMaterial, 2, EntityEquipmentSlot.LEGS);
    public static Item EVILEMERALDCHESTPLATE = new ItemEvilEmeraldArmor("evilemeraldchestplate", armorMaterial, 1, EntityEquipmentSlot.CHEST);
    public static Item EVILEMERALDHEAD = new ItemEvilEmeraldArmor("evilemeraldhead", armorMaterial, 1, EntityEquipmentSlot.HEAD);

    public static final Item CORN_SEED = new ItemCornSeed("corn_seed");
    public static final Item CORN = new ItemCorn("corn", 2, 0.6F, false);

    public static final Item LIGHTNINGSTAFF = new ItemLightningStaff("lightningstaff");
    public static final Item HEALINGSTAFF = new ItemHealingStaff("healingstaff");

    public static Item MUSICDISCFRANX = new ItemMusicDisc("music_discfanx",Sounds.franx);

    public static Item UPGRADEFURNACEFUEL = new ItemFurnaceFuelUpgrade("furnacefuelupgrade");
    public static Item UPGRADEFURNACECOOKTIME = new ItemFurnaceCookTimeUpgrade("furnacecooktimeupgrade");

    public static void register()
    {
        setRegister(EVILEMERALD);
        setRegister(ROLTON);
        setRegister(EVILEMERALDAXE);
        setRegister(EVILEMERALDPICKAXE);
        setRegister(EVILEMERALDSHOVEL);
        setRegister(EVILEMERALDHOE);
        setRegister(EVILEMERALDSWORD);
        setRegister(EVILEMERALDBOOTS);
        setRegister(EVILEMERALDLEGGS);
        setRegister(EVILEMERALDCHESTPLATE);
        setRegister(EVILEMERALDHEAD);
        setRegister(CORN_SEED);
        setRegister(CORN);
        setRegister(LIGHTNINGSTAFF);
        setRegister(EVILEMERALDMULTITOOL);
        setRegister(MUSICDISCFRANX);
        setRegister(HEALINGSTAFF);
        setRegister(UPGRADEFURNACEFUEL);
        setRegister(UPGRADEFURNACECOOKTIME);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {
        setRender(EVILEMERALD);
        setRender(ROLTON);
        setRender(EVILEMERALDAXE);
        setRender(EVILEMERALDPICKAXE);
        setRender(EVILEMERALDSHOVEL);
        setRender(EVILEMERALDHOE);
        setRender(EVILEMERALDSWORD);
        setRender(EVILEMERALDBOOTS);
        setRender(EVILEMERALDLEGGS);
        setRender(EVILEMERALDCHESTPLATE);
        setRender(EVILEMERALDHEAD);
        setRender(CORN_SEED);
        setRender(CORN);
        setRender(LIGHTNINGSTAFF);
        setRender(EVILEMERALDMULTITOOL);
        setRender(MUSICDISCFRANX);
        setRender(HEALINGSTAFF);
        setRender(UPGRADEFURNACEFUEL);
        setRender(UPGRADEFURNACECOOKTIME);
    }

    private static void setRegister(Item item)
    {
        ForgeRegistries.ITEMS.register(item);
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }



}
