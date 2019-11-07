package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Events.Event;

public class AlarmDeactivated implements AlarmStateInterface {
    String code;

    public AlarmDeactivated(String code) {
        code = code;
    }

    @Override
    public AlarmStateInterface activate() {
        System.out.println("Activate alarm with code " + this.code);
        return new AlarmActivated(this.code);
    }

    @Override
    public AlarmStateInterface deactivate(String code) {
        System.out.println("Try deactivate deactivated alarm");
        return this;
    }

    @Override
    public AlarmStateInterface takeHomeEvent(Event event) {
        return this;
    }

    @Override
    public String getString() {
        return " was deactivated.";
    }
}
