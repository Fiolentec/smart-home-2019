package ru.sbt.mipt.oop;

public class AlarmActivated implements AlarmStateInterface {
    String code;

    public AlarmActivated(String code) {
        this.code = code;
    }

    @Override
    public AlarmStateInterface activate(String code) {
        System.out.println("Try activate activated alarm with code " + this.code);
        return this;
    }

    @Override
    public AlarmStateInterface deactivate(String code) {
        System.out.println("Deactivate activated alarm with code " + code + " right code - " + this.code);
        if (this.code.equals(code)) {
            return new AlarmDeactivated();
        } else {
            return new AlarmActiveState();
        }
    }

    @Override
    public AlarmStateInterface takeHomeEvent(Event event) {
        if (!(event instanceof AlarmEvent)) {
            return new AlarmActiveState();
        }
        return this;
    }

    @Override
    public String getString() {
        return " was activated.";
    }

}
