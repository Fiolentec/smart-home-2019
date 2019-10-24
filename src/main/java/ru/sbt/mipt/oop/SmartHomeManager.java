package ru.sbt.mipt.oop;

import java.lang.reflect.Field;
import java.util.Collection;

public class SmartHomeManager {
    private SmartHome home;
    private EventHandler eventHandler;
    private EventGenerator eventGenerator;


    public SmartHomeManager(SmartHome home, EventHandler eventHandler, EventGenerator eventGenerator) {
        this.home = home;
        this.eventHandler = eventHandler;
        this.eventGenerator = eventGenerator;
    }

    public void startTrackingEvents() {
        Event event = eventGenerator.generateEvent();
        while (event != null) {
            eventHandler.handleEvent(event);
            event = eventGenerator.generateEvent();
        }
    }

    public void setHomeAll() {
        for (Field f : Room.class.getDeclaredFields()) {
            System.out.println("i'm here, guyzzzzzzzzzzz");
            System.out.println(f.getName());
            if (f.getClass().equals(RoomObject.class)) {
                f.setAccessible(true);
                try {
                    this.home.setHome((Collection<RoomObject>) f.get(f));
                } catch (IllegalAccessException e) {
                    System.out.println("Something went wrong");
                }

            }
        }
    }
}
