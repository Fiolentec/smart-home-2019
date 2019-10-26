package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Events.DoorEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Events.LightEvent;
import ru.sbt.mipt.oop.SmartHome;

public class EventHandler {
    private SmartHome home;

    public EventHandler(SmartHome home) {
        this.home = home;
    }

    public void handleEvent(Event event) {
        System.out.println("Got event: " + event);
        Object ro = findObject(event);
        BaseEventHandler eventHandler = event.getHandler();
        eventHandler.handleEvent(ro);
        if (ro != null) {
            home.getAlarm().takeHomeEvent(event);
        }
    }

    private Object findObject(Event event){
        if (event.getObjectId().equals("alarm")){
            return home.getAlarm();
        }
        if((event instanceof LightEvent)){
            return home.findLight(event.getObjectId());
        }
        if((event instanceof DoorEvent)){
            return home.findDoor(event.getObjectId());
        }
        return null;
    }

}
