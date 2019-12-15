package ru.sbt.mipt.oop.Alarm;

public class AlarmDeactivated implements AlarmState {
    Alarm alarm;

    public AlarmDeactivated(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate() {
        System.out.println("Activate alarm");
        alarm.setState(new AlarmActivated(alarm));
    }

    @Override
    public void deactivate(String code) {
        System.out.println("Try deactivate deactivated alarm");
    }

    @Override
    public void danger() {
        alarm.setState(new AlarmActiveState(alarm));
    }

}
