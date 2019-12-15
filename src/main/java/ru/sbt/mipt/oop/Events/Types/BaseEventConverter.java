package ru.sbt.mipt.oop.Events.Types;

import ru.sbt.mipt.oop.API.CCSensorEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.States;

public interface BaseEventConverter {
    public Event get(CCSensorEvent ccSensorEvent);
}
