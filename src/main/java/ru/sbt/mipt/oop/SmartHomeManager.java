package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventHandlerMy;
import ru.sbt.mipt.oop.Events.Event;

public class SmartHomeManager {
    private SmartHome home;
    private EventHandlerMy eventHandlerMy;
    private EventGenerator eventGenerator;


    public SmartHomeManager(SmartHome home, EventHandlerMy eventHandlerMy, EventGenerator eventGenerator) {
        this.home = home;
        this.eventHandlerMy = eventHandlerMy;
        this.eventGenerator = eventGenerator;
    }

    public void startTrackingEvents() {
        Event event = eventGenerator.generateEvent();
        while (event != null) {
            eventHandlerMy.handleEvent(event);
            event = eventGenerator.generateEvent();
        }
    }

}
