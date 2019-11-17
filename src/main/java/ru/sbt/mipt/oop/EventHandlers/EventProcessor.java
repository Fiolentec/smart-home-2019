package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;
import java.util.List;

public class EventProcessor {
    private SmartHome smartHome;

    List<EventHandler> eventHandlers;
    private AlarmEventHandler alarmEventHandler;
    private DoorEventHandler doorEventHandler;
    private HallDoorEventHandler hallDoorEventHandler;
    private LightEventHandler lightEventHandler;

    public EventProcessor(SmartHome home) {
        this.smartHome = home;
        eventHandlers = new ArrayList<>();
        eventHandlers.add(new AlarmEventHandler(smartHome));
        eventHandlers.add(new DoorEventHandler(smartHome));
        eventHandlers.add(new HallDoorEventHandler(smartHome));
        eventHandlers.add(new LightEventHandler(smartHome));
    }

    public void handleEvent(Event event) {
        System.out.println("Got event: " + event);
        eventHandlers.forEach(object -> {
            object.handleEvent(event);
        });
    }

}
