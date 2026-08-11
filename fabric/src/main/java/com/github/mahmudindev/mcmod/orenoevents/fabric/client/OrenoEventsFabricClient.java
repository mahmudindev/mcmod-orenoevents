package com.github.mahmudindev.mcmod.orenoevents.fabric.client;

import com.github.mahmudindev.mcmod.orenoevents.fabric.client.event.EventsFabricClient;
import net.fabricmc.api.ClientModInitializer;

public final class OrenoEventsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.

        EventsFabricClient.init();
    }
}
