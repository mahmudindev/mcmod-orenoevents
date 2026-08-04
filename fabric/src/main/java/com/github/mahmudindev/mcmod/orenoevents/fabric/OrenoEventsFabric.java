package com.github.mahmudindev.mcmod.orenoevents.fabric;

import com.github.mahmudindev.mcmod.orenoevents.OrenoEvents;
import com.github.mahmudindev.mcmod.orenoevents.fabric.event.EventsFabric;
import net.fabricmc.api.ModInitializer;

public final class OrenoEventsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        OrenoEvents.init();

        EventsFabric.init();
    }
}
