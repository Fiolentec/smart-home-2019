package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.API.CCSensorEvent;

public class LightEventAdapter extends LightEvent {
    CCSensorEvent sensorEvent;

    public LightEventAdapter(String id, TypeEvent type,CCSensorEvent sensorEvent) {
        super(id, type);
        sensorEvent = sensorEvent;
    }
}
