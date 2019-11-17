package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Action;

public class AlarmActivated implements AlarmStateInterface {

    @Override
    public Action activate() {
        return obj -> {
            System.out.println("Try activate activated alarm");
        };
    }

    @Override
    public Action deactivate(String code) {
        return obj -> {
            System.out.println("Deactivate activated alarm with code " + code);
            if (obj instanceof Alarm) {
                if (((Alarm) obj).checkCode(code)) {
                    ((Alarm) obj).setState(new AlarmDeactivated());
                } else {
                    ((Alarm) obj).setState(new AlarmActiveState());
                    ((Alarm) obj).startAlarm();
                }
            }
        };
    }

}
