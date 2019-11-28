package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.Events.Event;

public class Alarm implements Actionable {
    private AlarmStateInterface state;
    private SmartHome smartHome;
    private final int timeSleep;
    private final String id;

    public Alarm(SmartHome smartHome) {
        this.id = "id";
        this.timeSleep = 5;
        this.state = new AlarmDeactivated();
        this.smartHome = smartHome;
    }

    public Alarm(SmartHome smartHome, int timeSleep, String id) {
        this.timeSleep = timeSleep;
        this.id = id;
        this.state = new AlarmDeactivated();
        this.smartHome = smartHome;
    }

    public void activate(String code) {
        state = state.activate(code);
    }

    public void deactivate(String code) {
        state = state.deactivate(code);
        if (state instanceof AlarmActiveState) {
            startAlarm();
        }
    }

    public void takeHomeEvent(Event event) {
        state.takeHomeEvent(event);
    }

    private void startAlarm() {
        startSiren();
        while (true) {
            try {
                Thread.sleep(timeSleep * 1000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
            smartHome.getRooms().forEach(room -> {
                room.getLights().forEach(light -> {
                    light.setState((Math.random() > 0.5) ? States.LIGHT_OFF : States.LIGHT_ON);
                    System.out.println(light.getString());
                });
            });
            sendMessage();
        }
    }

    public AlarmStateInterface getState() {
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

    public String getString() {
        return "Alarm" + (state.getString());
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
