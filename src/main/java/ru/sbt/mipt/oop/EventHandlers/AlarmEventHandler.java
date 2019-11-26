package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Alarm.AlarmActivated;
import ru.sbt.mipt.oop.Events.AlarmEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public class AlarmEventHandler implements EventHandler {
    private Event event;
    private SmartHome smartHome;

    public AlarmEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void handleEvent(Event event) {
        smartHome.execute(obj -> {
            if (obj instanceof Alarm) {
                if (event instanceof AlarmEvent) {
                    if (event.getState().equals(States.ALARM_ACTIVATE)) {
                        ((Alarm) obj).activate();
                    } else if (event.getState().equals(States.ALARM_DEACTIVATE)) {
                        ((Alarm) obj).deactivate(((AlarmEvent) event).getCode());
                    }
                } else if (((Alarm) obj).getState() instanceof AlarmActivated) {
                    ((Alarm) obj).danger();
                }
            }

        });
    }

}
