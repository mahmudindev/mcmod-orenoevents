package com.github.mahmudindev.mcmod.orenoevents.neoforge;

import com.github.mahmudindev.mcmod.orenoevents.OrenoEvents;
import com.github.mahmudindev.mcmod.orenoevents.neoforge.client.OrenoEventsNeoForgeClient;
import com.github.mahmudindev.mcmod.orenoevents.neoforge.event.EventsNeoForge;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(OrenoEvents.MOD_ID)
public final class OrenoEventsNeoForge {
    public OrenoEventsNeoForge() {
        // Run our common setup.
        OrenoEvents.init();

        EventsNeoForge.init();

        if (FMLEnvironment.dist == Dist.CLIENT) {
            new OrenoEventsNeoForgeClient();
        }
    }
}
