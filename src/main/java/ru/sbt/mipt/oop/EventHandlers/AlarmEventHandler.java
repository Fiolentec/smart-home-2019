package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Events.AlarmEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public class AlarmEventHandler extends BaseEventHandler {
    private Event event;

    public AlarmEventHandler(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    void handleEvent(Event event) {
        smartHome.execute(obj -> {
            if(obj instanceof Alarm){
                if (event.getState().equals(States.ALARM_ACTIVATE)) {
                    ((Alarm) obj).activate(((AlarmEvent) event).getCode());
                } else if (event.getState().equals(States.ALARM_DEACTIVATE)) {
                    ((Alarm) obj).deactivate(((AlarmEvent) event).getCode());
                }
            }
        });
    }

}
