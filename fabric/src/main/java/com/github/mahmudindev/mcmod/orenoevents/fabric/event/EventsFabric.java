package com.github.mahmudindev.mcmod.orenoevents.fabric.event;

import com.github.mahmudindev.mcmod.orenoevents.OrenoEvents;
import com.github.mahmudindev.mcmod.orenoevents.event.LifecycleEvents;
import com.github.mahmudindev.mcmod.orenoevents.event.ServerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;

public class EventsFabric {
    public static void init() {
        EventsFabric.lifecycleEvents();
        EventsFabric.serverEvents();
    }

    private static void lifecycleEvents() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            LifecycleEvents.SERVER_STARTING.invoker(serverStarting -> {
                serverStarting.onServerStarting(server);
            });
        });

        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            LifecycleEvents.SERVER_STARTED.invoker(serverStarted -> {
                serverStarted.onServerStarted(server);
            });
        });

        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            LifecycleEvents.SERVER_STOPPING.invoker(serverStopping -> {
                serverStopping.onServerStopping(server);
            });
        });

        ServerLifecycleEvents.SERVER_STOPPED.register(server -> {
            LifecycleEvents.SERVER_STOPPED.invoker(serverStopped -> {
                serverStopped.onServerStopped(server);
            });
        });
    }

    private static void serverEvents() {
        ResourceManagerHelper
                .get(PackType.SERVER_DATA)
                .registerReloadListener(new SimpleSynchronousResourceReloadListener() {
                    @Override
                    public ResourceLocation getFabricId() {
                        return new ResourceLocation(OrenoEvents.MOD_ID, "default");
                    }

                    @Override
                    public void onResourceManagerReload(ResourceManager resourceManager) {
                        ServerEvents.RESOURCE_MANAGER_RELOAD.invoker(serverResourceReload -> {
                            serverResourceReload.onResourceManagerReload(resourceManager);
                        });
                    }
                });
    }
}
