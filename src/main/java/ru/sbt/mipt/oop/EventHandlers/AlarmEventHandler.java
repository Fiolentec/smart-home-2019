package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.API.CCSensorEvent;
import ru.sbt.mipt.oop.API.EventHandler;
import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Events.AlarmEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public class AlarmEventHandler extends BaseEventHandler implements EventHandler {
//    private Event event;

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
//        if (alarm != null) {
////            System.out.println(((Alarm) alarm).getString());
//            if (event.getState().equals(States.ALARM_ACTIVATE)) {
//                ((Alarm) alarm).activate(((AlarmEvent) event).getCode());
//            } else if (event.getState().equals(States.ALARM_DEACTIVATE)) {
//                ((Alarm) alarm).deactivate(((AlarmEvent) event).getCode());
//            }
//        } else {
//            System.out.println("Object not found or act is not right");
//        }
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
    }
}
