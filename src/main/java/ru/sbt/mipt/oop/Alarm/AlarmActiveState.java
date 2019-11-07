package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Events.Event;

public class AlarmActiveState implements AlarmStateInterface {

    @Override
    public AlarmStateInterface activate() {
        return this;
    }

    @Override
    public AlarmStateInterface deactivate(String code) {
        return this;
    }

    @Override
    public AlarmStateInterface takeHomeEvent(Event event) {
        return this;
    }

    @Override
    public String getString() {
        return " in active state!!!";
    }
}
