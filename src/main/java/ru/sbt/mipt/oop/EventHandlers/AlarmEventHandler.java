package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Events.AlarmEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.States;

public class AlarmEventHandler extends BaseEventHandler {
    private Event event;

    public AlarmEventHandler(Event event) {
        this.event = event;
    }

    @Override
    void handleEvent(Object alarm) {
        if (alarm != null) {
//            System.out.println(((Alarm) alarm).getString());
            if (event.getState().equals(States.ALARM_ACTIVATE)) {
                ((Alarm) alarm).activate(((AlarmEvent) event).getCode());
            } else if (event.getState().equals(States.ALARM_DEACTIVATE)) {
                ((Alarm) alarm).deactivate(((AlarmEvent) event).getCode());
            }
        } else {
            System.out.println("Object not found or act is not right");
        }
    }

}
