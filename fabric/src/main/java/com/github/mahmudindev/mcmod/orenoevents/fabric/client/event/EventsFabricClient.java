package com.github.mahmudindev.mcmod.orenoevents.fabric.client.event;

import com.github.mahmudindev.mcmod.orenoevents.OrenoEvents;
import com.github.mahmudindev.mcmod.orenoevents.client.event.events.ClientEvents;
import com.github.mahmudindev.mcmod.orenoevents.client.event.events.ClientPlayerEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;

public class EventsFabricClient {
    public static void init() {
        clientEvents();
        playerEvents();
    }

    private static void clientEvents() {
        ResourceManagerHelper
                .get(PackType.CLIENT_RESOURCES)
                .registerReloadListener(new SimpleSynchronousResourceReloadListener() {
                    @Override
                    public ResourceLocation getFabricId() {
                        return ResourceLocation.fromNamespaceAndPath(
                                OrenoEvents.MOD_ID,
                                "default"
                        );
                    }

                    @Override
                    public void onResourceManagerReload(ResourceManager resourceManager) {
                        ClientEvents.RESOURCE_MANAGER_RELOAD.invoker(clientResourceReload -> {
                            clientResourceReload.onResourceManagerReload(resourceManager);
                        });
                    }
                });
    }

    private static void playerEvents() {
        ClientPlayConnectionEvents.JOIN.register(((handler, sender, client) -> {
            ClientPlayerEvents.JOIN.invoker(join -> {
                join.onJoin(client.player);
            });
        }));

        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            ClientPlayerEvents.DISCONNECT.invoker(disconnect -> {
                disconnect.onDisconnect(client.player);
            });
        });
    }
}
