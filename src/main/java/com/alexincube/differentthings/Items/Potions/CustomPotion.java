package com.alexincube.differentthings.Items.Potions;

import com.alexincube.differentthings.DifferentThings;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class CustomPotion extends Potion {
    public CustomPotion(String name, boolean isBadPotion, int colour, int iconIndexX, int iconIndexY){
        super(isBadPotion, colour);
        setPotionName("effect."+name);
        setIconIndex(iconIndexX, iconIndexY);
        setRegistryName(new ResourceLocation(DifferentThings.MODID+":"+name));


    }

    @Override
    public boolean hasStatusIcon()
    {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("differentthings:textures/gui/potions/superpotion.png"));
        return true;
    }
}
