package com.github.mahmudindev.mcmod.orenoevents.event;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public class Event<T> {
    private final List<T> listeners = new CopyOnWriteArrayList<>();

    public void register(T listener) {
        this.listeners.add(listener);
    }

    public void invoker(Consumer<T> action) {
        for (T listener : this.listeners) {
            action.accept(listener);
        }
    }
}
