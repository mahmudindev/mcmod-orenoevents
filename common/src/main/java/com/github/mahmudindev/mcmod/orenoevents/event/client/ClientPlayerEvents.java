package com.github.mahmudindev.mcmod.orenoevents.event.client;

import com.github.mahmudindev.mcmod.orenoevents.event.Event;
import net.minecraft.client.player.LocalPlayer;

public class ClientPlayerEvents {
    public static final Event<Disconnect> DISCONNECT = new Event<>();

    @FunctionalInterface
    public interface Disconnect {
        void onDisconnect(LocalPlayer localPlayer);
    }
}
