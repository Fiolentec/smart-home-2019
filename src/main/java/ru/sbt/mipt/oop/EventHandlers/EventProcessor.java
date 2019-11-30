package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Alarm.*;
import ru.sbt.mipt.oop.Events.AlarmEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;
import java.util.List;

public class EventProcessor implements BaseEventHandler {
    private SmartHome smartHome;

    List<BaseEventHandler> eventHandlers;

    public EventProcessor(SmartHome home,List<BaseEventHandler> eventHandlers) {
        this.smartHome = home;
        this.eventHandlers = eventHandlers;
    }

    public void handleEvent(Event event) {
        System.out.println("Got event: " + event);
        Sender sender = new Sender();
        Alarm alarm = smartHome.getAlarm();

        if (alarm.getState() instanceof AlarmDeactivated ||(alarm.getState() instanceof AlarmActiveState && event instanceof AlarmEvent)) {
            eventHandlers.forEach(object -> {
                object.handleEvent(event);
            });
        }

        if (alarm.getState() instanceof AlarmActivated ||alarm.getState() instanceof AlarmActiveState){
            sender.send("Try change state of home; " + event);
        }

        if (alarm.getState() instanceof AlarmActivated){
            alarm.setState(new AlarmActiveState(alarm));
        }
    }

}
