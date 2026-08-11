package com.github.mahmudindev.mcmod.orenoevents.event.client;

import com.github.mahmudindev.mcmod.orenoevents.event.Event;
import net.minecraft.server.packs.resources.ResourceManager;

public class ClientEvents {
    public static final Event<ResourceManagerReload> RESOURCE_MANAGER_RELOAD = new Event<>();

    @FunctionalInterface
    public interface ResourceManagerReload {
        void onResourceManagerReload(ResourceManager resourceManager);
    }
}
