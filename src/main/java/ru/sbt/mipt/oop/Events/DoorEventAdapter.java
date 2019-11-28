package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.API.CCSensorEvent;

public class DoorEventAdapter extends DoorEvent {
    CCSensorEvent sensorEvent;

    public DoorEventAdapter(String id, TypeEvent type, CCSensorEvent sensorEvent) {
        super(id, type);
        this.sensorEvent = sensorEvent;
    }

    @Override
    public String getType() {
        return this.type.toString();
    }

}
