package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Events.Event;

public interface AlarmStateInterface {
    AlarmStateInterface activate(String code);

    AlarmStateInterface deactivate(String code);

    AlarmStateInterface takeHomeEvent(Event event);

    String getString();
}
