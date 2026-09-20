package com.github.mahmudindev.mcmod.orenoevents.client.event.events;

import com.github.mahmudindev.mcmod.orenoevents.event.Event;
import net.minecraft.client.player.LocalPlayer;

public class ClientPlayerEvents {
    public static final Event<Join> JOIN = new Event<>();
    public static final Event<Disconnect> DISCONNECT = new Event<>();

    @FunctionalInterface
    public interface Join {
        void onJoin(LocalPlayer localPlayer);
    }

    @FunctionalInterface
    public interface Disconnect {
        void onDisconnect(LocalPlayer localPlayer);
    }
}
