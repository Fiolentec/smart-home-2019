package ru.sbt.mipt.oop;

public class AlarmDeactivated implements AlarmStateInterface {
    public AlarmDeactivated() {
    }

    @Override
    public AlarmStateInterface activate(String code) {
        System.out.println("Activate alarm with code " + code);
        return new AlarmActivated(code);
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
