package com.alexincube.differentthings.Items.Misc;

import com.alexincube.differentthings.Sounds;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import static com.alexincube.differentthings.DifferentThings.CTAB;

public class ItemMusicDisc extends ItemRecord {

    public ItemMusicDisc(String name,SoundEvent id) {

        super(name,id);
        this.setRegistryName ("record."+name);
        this.setUnlocalizedName("record."+name);
        setMaxStackSize(1);
        setCreativeTab(CTAB);
    }
}
