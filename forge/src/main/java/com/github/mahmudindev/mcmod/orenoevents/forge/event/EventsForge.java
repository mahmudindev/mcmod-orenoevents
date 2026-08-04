package com.github.mahmudindev.mcmod.orenoevents.forge.event;

import com.github.mahmudindev.mcmod.orenoevents.event.LifecycleEvents;
import com.github.mahmudindev.mcmod.orenoevents.event.ServerEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventsForge {
    public static void init() {
        MinecraftForge.EVENT_BUS.register(new EventsForge());
    }

    @SubscribeEvent
    private void onServerStarting(ServerStartingEvent event) {
        MinecraftServer server = event.getServer();

        LifecycleEvents.SERVER_STARTING.invoker(serverStarting -> {
            serverStarting.onServerStarting(server);
        });
    }

    @SubscribeEvent
    private void onServerStarted(ServerStartedEvent event) {
        MinecraftServer server = event.getServer();

        LifecycleEvents.SERVER_STARTED.invoker(serverStarted -> {
            serverStarted.onServerStarted(server);
        });
    }

    @SubscribeEvent
    private void onServerStopping(ServerStoppingEvent event) {
        MinecraftServer server = event.getServer();

        LifecycleEvents.SERVER_STOPPING.invoker(serverStopping -> {
            serverStopping.onServerStopping(server);
        });
    }

    @SubscribeEvent
    private void onServerStopped(ServerStoppedEvent event) {
        MinecraftServer server = event.getServer();

        LifecycleEvents.SERVER_STOPPED.invoker(serverStopped -> {
            serverStopped.onServerStopped(server);
        });
    }

    @SubscribeEvent
    private void onServerResourceManagerReload(AddReloadListenerEvent event) {
        event.addListener(new ResourceManagerReloadListener() {
            @Override
            public void onResourceManagerReload(ResourceManager resourceManager) {
                ServerEvents.RESOURCE_MANAGER_RELOAD.invoker(serverResourceReload -> {
                    serverResourceReload.onResourceManagerReload(resourceManager);
                });
            }
        });
    }
}
