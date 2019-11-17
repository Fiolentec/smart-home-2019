package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventProcessor;
import ru.sbt.mipt.oop.Events.Event;

public class SmartHomeManager {
    private SmartHome home;
    private EventProcessor eventProcessor;
    private EventGenerator eventGenerator;


    public SmartHomeManager(SmartHome home, EventProcessor eventProcessor, EventGenerator eventGenerator) {
        this.home = home;
        this.eventProcessor = eventProcessor;
        this.eventGenerator = eventGenerator;
    }

    public void startTrackingEvents() {
        Event event = eventGenerator.generateEvent();
        while (event != null) {
            eventProcessor.handleEvent(event);
            event = eventGenerator.generateEvent();
        }
    }
}
