package com.github.mahmudindev.mcmod.orenoevents.neoforge.client.event;

import com.github.mahmudindev.mcmod.orenoevents.client.event.events.ClientEvents;
import com.github.mahmudindev.mcmod.orenoevents.client.event.events.ClientPlayerEvents;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;

@EventBusSubscriber()
public class EventsNeoForgeClient {
    public static void init() {}

    @SubscribeEvent
    public static void onClientResourceManagerReload(RegisterClientReloadListenersEvent event) {
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
    public static void onClientPlayerJoin(ClientPlayerNetworkEvent.LoggingIn event) {
        LocalPlayer player = event.getPlayer();

        ClientPlayerEvents.JOIN.invoker(join -> {
            join.onJoin(player);
        });
    }

    @SubscribeEvent
    public static void onClientPlayerDisconnect(ClientPlayerNetworkEvent.LoggingOut event) {
        LocalPlayer player = event.getPlayer();

        ClientPlayerEvents.DISCONNECT.invoker(disconnect -> {
            disconnect.onDisconnect(player);
        });
    }
}
