package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.API.CCSensorEvent;

public class EventsAdapter {
    CCSensorEvent sensorEvent;

    public EventsAdapter(CCSensorEvent sensorEvent) {
        this.sensorEvent = sensorEvent;
    }

    public Event getAdaptedEvent() {
        if (sensorEvent.getEventType().equals("LightIsOn") || (sensorEvent.getEventType().equals("LightIsOff"))) {
            return new LightEventAdapter(sensorEvent.getObjectId(), sensorEventConverter(sensorEvent.getEventType()), sensorEvent);
        }
        if (sensorEvent.getEventType().equals("DoorIsOpen") || (sensorEvent.getEventType().equals("DoorIsClosed"))
                || (sensorEvent.getEventType().equals("DoorIsLocked")) || (sensorEvent.getEventType().equals("DoorIsUnlocked"))) {
            return new DoorEventAdapter(sensorEvent.getObjectId(), sensorEventConverter(sensorEvent.getEventType()), sensorEvent);
        }
        return null;
    }

    TypeEvent sensorEventConverter(String eventType) {
//        "LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"
        switch (eventType) {
            case ("LightIsOn"):
                return TypeEvent.LIGHT_ON;
            case ("LightIsOff"):
                return TypeEvent.LIGHT_OFF;
            case ("DoorIsOpen"):
                return TypeEvent.DOOR_OPEN;
            case ("DoorIsClosed"):
                return TypeEvent.DOOR_CLOSE;
            case ("DoorIsLocked"):
                return TypeEvent.DOOR_LOCK;
            case ("DoorIsUnlocked"):
                return TypeEvent.DOOR_UNLOCK;

        }
        return null;
    }

}
