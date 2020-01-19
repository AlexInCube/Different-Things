package com.alexincube.differentthings;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;


public class Sounds
{

    public static SoundEvent franx;

    public static void registerSounds()
    {
        franx = registerSound("soundfranx");
    }

    private static SoundEvent registerSound(String name) {
        ResourceLocation location = new ResourceLocation("differentthings", name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}

