package com.github.mahmudindev.mcmod.orenoevents.event;

import net.minecraft.server.packs.resources.ResourceManager;

public class ServerEvents {
    public static final Event<ResourceManagerReload> RESOURCE_MANAGER_RELOAD = new Event<>();

    @FunctionalInterface
    public interface ResourceManagerReload {
        void onResourceManagerReload(ResourceManager resourceManager);
    }
}
