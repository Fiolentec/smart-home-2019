package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public class Alarm {
    private AlarmStateInterface state;
    private SmartHome smartHome;
    private final int timeSleep;
    private final String id;
    private final String code;
    volatile boolean activeState;

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


    public void setState(AlarmStateInterface state) {
        this.state = state;
    }

    public void startAlarm() {
        state = new AlarmActiveState();
        startSiren();
        activeState = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (activeState) {
                    smartHome.getRooms().forEach(room -> {
                        room.getLights().forEach(light -> {
                            light.setState((Math.random() > 0.5) ? States.LIGHT_OFF : States.LIGHT_ON);
                        });
                    });
                    sendMessage();
                    try {
                        Thread.sleep(timeSleep * 1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.toString());
                    }
                }
            }
        }
        ).start();
    }

    public boolean checkCode(String code) {
        return code.equals(this.code);
    }

    public void execute(Action action) {
        action.execute(this);
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
}
