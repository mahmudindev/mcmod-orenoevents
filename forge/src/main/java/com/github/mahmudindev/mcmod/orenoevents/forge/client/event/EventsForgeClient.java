package com.github.mahmudindev.mcmod.orenoevents.forge.client.event;

import com.github.mahmudindev.mcmod.orenoevents.event.client.ClientEvents;
import com.github.mahmudindev.mcmod.orenoevents.event.client.ClientPlayerEvents;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventsForgeClient {
    public static void init() {
        MinecraftForge.EVENT_BUS.register(new EventsForgeClient());
    }

    @SubscribeEvent
    public void onClientResourceManagerReload(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(new ResourceManagerReloadListener() {
            @Override
            public void onResourceManagerReload(ResourceManager resourceManager) {
                ClientEvents.RESOURCE_MANAGER_RELOAD.invoker(clientResourceReload -> {
                    clientResourceReload.onResourceManagerReload(resourceManager);
                });
            }
        });
    }

    @SubscribeEvent
    public void onClientPlayerDisconnect(ClientPlayerNetworkEvent.LoggingOut event) {
        LocalPlayer player = event.getPlayer();

        ClientPlayerEvents.DISCONNECT.invoker(disconnect -> {
            disconnect.onDisconnect(player);
        });
    }
}
