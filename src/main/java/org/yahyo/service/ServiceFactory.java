package org.yahyo.service;

import org.yahyo.entity.Computer;
import org.yahyo.entity.Keyboard;
import org.yahyo.entity.Monitor;
import org.yahyo.entity.Mouse;

public enum ServiceFactory {
    INSTANCE;

    @SuppressWarnings("unchecked")
    public <A extends Computer> MainService<A> getService(Class<A> classType) {
        if (Monitor.class.equals(classType)) return (MainService<A>) new MonitorService();
        else if (Keyboard.class.equals(classType)) return (MainService<A>) new KeyboardService();
        else if (Mouse.class.equals(classType)) return (MainService<A>) new MouseService();
        else throw new IllegalArgumentException("Unsupported class type: " + classType.getSimpleName());
    }
}
