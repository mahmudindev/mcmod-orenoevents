package com.github.mahmudindev.mcmod.orenoevents.event.common;

import com.github.mahmudindev.mcmod.orenoevents.event.Event;
import net.minecraft.server.level.ServerPlayer;

public class PlayerEvents {
    public static final Event<Join> JOIN = new Event<>();
    public static final Event<Disconnect> DISCONNECT = new Event<>();

    @FunctionalInterface
    public interface Join {
        void onJoin(ServerPlayer serverPlayer);
    }

    @FunctionalInterface
    public interface Disconnect {
        void onDisconnect(ServerPlayer serverPlayer);
    }
}
