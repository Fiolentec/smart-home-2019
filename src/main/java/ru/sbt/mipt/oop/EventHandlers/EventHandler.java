package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Events.DoorEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Events.LightEvent;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    private SmartHome smartHome;

    List<BaseEventHandler> eventHandlers;
    private AlarmEventHandler alarmEventHandler;
    private DoorEventHandler doorEventHandler;
    private HallDoorEventHandler hallDoorEventHandler;
    private LightEventHandler lightEventHandler;

    public EventHandler(SmartHome home) {
        this.smartHome = home;
        eventHandlers = new ArrayList<>();
        eventHandlers.add(new AlarmEventHandler(smartHome));
        eventHandlers.add(new DoorEventHandler(smartHome));
        eventHandlers.add(new HallDoorEventHandler(smartHome));
        eventHandlers.add(new LightEventHandler(smartHome));
    }

    public void handleEvent(Event event) {
        System.out.println("Got event: " + event);
        eventHandlers.forEach(object ->{
            object.handleEvent(event);
        });
    }

}
