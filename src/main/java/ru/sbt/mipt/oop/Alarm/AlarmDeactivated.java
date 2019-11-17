package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Action;

public class AlarmDeactivated implements AlarmStateInterface {
    public AlarmDeactivated() {
    }

    @Override
    public Action activate() {
        return obj -> {
            System.out.println("Activate alarm");
            if (obj instanceof Alarm) {
                ((Alarm) obj).setState(new AlarmActivated());
            }
        };
    }

    @Override
    public Action deactivate(String code) {
        return obj -> {
            System.out.println("Try deactivate deactivated alarm");
        };
    }

}
