package ru.sbt.mipt.oop;

public interface AlarmStateInterface {
    AlarmStateInterface activate(String code);

    AlarmStateInterface deactivate(String code);

    AlarmStateInterface takeHomeEvent(Event event);

    String getString();
}
