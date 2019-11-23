package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public class Alarm {
    private AlarmState state;
    private SmartHome smartHome;
    private final int timeSleep;
    private final String id;
    private final String code;

    public Alarm(SmartHome smartHome) {
        this.id = "id";
        this.timeSleep = 5;
        this.state = new AlarmDeactivated();
        this.smartHome = smartHome;
        this.code = "standardCode";
    }

    public Alarm(SmartHome smartHome, String code) {
        this.id = "id";
        this.timeSleep = 5;
        this.state = new AlarmDeactivated();
        this.smartHome = smartHome;
        this.code = code;
    }

    public Alarm(SmartHome smartHome, int timeSleep, String id, String code) {
        this.timeSleep = timeSleep;
        this.id = id;
        this.state = new AlarmDeactivated();
        this.smartHome = smartHome;
        this.code = code;
    }

    public void activate() {
        execute(state.activate());
    }

    public void deactivate(String code) {
        execute(state.deactivate(code));
    }


    public void setState(AlarmState state) {
        this.state = state;
    }

    public void startAlarm() {
        state = new AlarmActiveState();
        sendMessage();
        startSiren();
    }

    public boolean checkCode(String code) {
        return code.equals(this.code);
    }

    public void execute(Action action) {
        action.execute(this);
    }

    public AlarmState getState() {
        return state;
    }

    public SmartHome getSmartHome() {
        return smartHome;
    }

    private void sendMessage() {
        System.out.println("Sending message on number " + smartHome.getPhoneNumber());
    }

    private void startSiren() {
        System.out.println("!!!!!!!Siren started!!!!!!!");
    }
}
