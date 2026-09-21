package com.github.mahmudindev.mcmod.orenoevents.neoforge.event;

import com.github.mahmudindev.mcmod.orenoevents.event.events.LifecycleEvents;
import com.github.mahmudindev.mcmod.orenoevents.event.events.PlayerEvents;
import com.github.mahmudindev.mcmod.orenoevents.event.events.ServerEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;

@EventBusSubscriber()
public class EventsNeoForge {
    public static void init() {}

    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        MinecraftServer server = event.getServer();

        LifecycleEvents.SERVER_STARTING.invoker(serverStarting -> {
            serverStarting.onServerStarting(server);
        });
    }

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        MinecraftServer server = event.getServer();

        LifecycleEvents.SERVER_STARTED.invoker(serverStarted -> {
            serverStarted.onServerStarted(server);
        });
    }

    @SubscribeEvent
    public static void onServerStopping(ServerStoppingEvent event) {
        MinecraftServer server = event.getServer();

        LifecycleEvents.SERVER_STOPPING.invoker(serverStopping -> {
            serverStopping.onServerStopping(server);
        });
    }

    @SubscribeEvent
    public static void onServerStopped(ServerStoppedEvent event) {
        MinecraftServer server = event.getServer();

        LifecycleEvents.SERVER_STOPPED.invoker(serverStopped -> {
            serverStopped.onServerStopped(server);
        });
    }

    @SubscribeEvent
    public static void onServerPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        Player entity = event.getEntity();

        PlayerEvents.JOIN.invoker(join -> {
            join.onJoin((ServerPlayer) entity);
        });
    }

    @SubscribeEvent
    public static void onServerPlayerDisconnect(PlayerEvent.PlayerLoggedOutEvent event) {
        Player entity = event.getEntity();

        PlayerEvents.DISCONNECT.invoker(disconnect -> {
            disconnect.onDisconnect((ServerPlayer) entity);
        });
    }

    @SubscribeEvent
    public static void onServerResourceManagerReload(AddReloadListenerEvent event) {
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
