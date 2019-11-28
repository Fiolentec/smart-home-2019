package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;
import java.util.List;

public class EventHandlerMy {
    private SmartHome home;
    List<BaseEventHandler> eventHandlers;
    private AlarmEventHandler alarmEventHandler;
    private DoorEventHandler doorEventHandler;
    private HallDoorEventHandler hallDoorEventHandler;
    private LightEventHandler lightEventHandler;

    public EventHandlerMy(SmartHome home) {
        this.home = home;
        eventHandlers = new ArrayList<>();
        eventHandlers.add(new AlarmEventHandler(home));
        eventHandlers.add(new DoorEventHandler(home));
        eventHandlers.add(new HallDoorEventHandler(home));
        eventHandlers.add(new LightEventHandler(home));
    }

    public void handleEvent(Event event) {
        System.out.println("Got event: " + event);
        eventHandlers.forEach(object -> {
            object.handleEvent(event);
        });
    }


}
