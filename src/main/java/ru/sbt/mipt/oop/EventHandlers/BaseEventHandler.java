package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.SmartHome;

public class BaseEventHandler {
    SmartHome smartHome;

    public BaseEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    void handleEvent(Event event) {
    }
}
