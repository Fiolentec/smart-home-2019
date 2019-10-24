package ru.sbt.mipt.oop;

public class AlarmEventHandler extends BaseEventHandler {
    private Event event;

    AlarmEventHandler(Event event) {
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
