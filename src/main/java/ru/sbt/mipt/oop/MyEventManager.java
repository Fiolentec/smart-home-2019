package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventHandlerMy;

public class MyEventManager {
    SmartHome smartHome;

    public MyEventManager(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public void start() {
        EventHandlerMy eventHandlerMy = new EventHandlerMy(this.smartHome);
        EventGenerator eventGenerator = new EventGenerator();
        SmartHomeManager smartHomeManager = new SmartHomeManager(this.smartHome, eventHandlerMy, eventGenerator);
        smartHomeManager.startTrackingEvents();
    }
}
