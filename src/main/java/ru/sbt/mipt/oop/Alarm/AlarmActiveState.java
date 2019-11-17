package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Action;

public class AlarmActiveState implements AlarmStateInterface {

    @Override
    public Action activate() {
        return obj -> {
            System.out.println("Try activate Alarm in Active State");
        };
    }

    @Override
    public Action deactivate(String code) {
        return obj -> {
            if (obj instanceof Alarm) {
                if (((Alarm) obj).checkCode(code)) {
                    System.out.println("Deactivate ActiveState with right code");
                    ((Alarm) obj).activeState = false;
                    ((Alarm) obj).setState(new AlarmDeactivated());
                } else {
                    System.out.println("You shall not pass!!! (Wrong code)");
                }
            }
        };
    }

}
