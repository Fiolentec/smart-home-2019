package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.RoomObjects.RoomObject;

public class RoomObjectEventHandler extends BaseEventHandler {
    private Event event;

    public RoomObjectEventHandler(Event event) {
        this.event = event;
    }

    @Override
    void handleEvent(Object ro) {
        if (ro != null) {
            System.out.println(((RoomObject) ro).getString());//print info about event
            ((RoomObject) ro).setState(event.getState());//set state of event
        } else {
            System.out.println("Object not found or act is not right");
        }
    }

}
