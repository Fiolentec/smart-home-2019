package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Action;

public class AlarmActiveState implements AlarmState {
    Alarm alarm;

    public AlarmActiveState(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate() {
        System.out.println("Try activate Alarm in Active State");
    }

    @Override
    public void deactivate(String code) {
        if (alarm.checkCode(code)) {
            System.out.println("Deactivate ActiveState with right code");
            alarm.setState(new AlarmDeactivated(alarm));
        } else {
            System.out.println("Wrong code");
        }
    }

}
