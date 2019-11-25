package ru.sbt.mipt.oop.Alarm;

public interface AlarmState {
    void activate();

    void deactivate(String code);

}
