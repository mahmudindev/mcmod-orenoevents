package com.github.mahmudindev.mcmod.orenoevents.forge;

import com.github.mahmudindev.mcmod.orenoevents.OrenoEvents;
import com.github.mahmudindev.mcmod.orenoevents.forge.client.OrenoEventsForgeClient;
import com.github.mahmudindev.mcmod.orenoevents.forge.event.EventsForge;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(OrenoEvents.MOD_ID)
public final class OrenoEventsForge {
    public OrenoEventsForge() {
        // Run our common setup.
        OrenoEvents.init();

        EventsForge.init();

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> OrenoEventsForgeClient::new);
    }
}
