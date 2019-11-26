package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Alarm.*;
import ru.sbt.mipt.oop.Events.AlarmEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;
import java.util.List;

public class EventProcessor {
    private SmartHome smartHome;

    List<EventHandler> eventHandlers;
    private AlarmEventHandler alarmEventHandler;
    private DoorEventHandler doorEventHandler;
    private HallDoorEventHandler hallDoorEventHandler;
    private LightEventHandler lightEventHandler;

    public EventProcessor(SmartHome home) {
        this.smartHome = home;
        eventHandlers = new ArrayList<>();
        eventHandlers.add(new AlarmEventHandler(smartHome));
        eventHandlers.add(new DoorEventHandler(smartHome));
        eventHandlers.add(new HallDoorEventHandler(smartHome));
        eventHandlers.add(new LightEventHandler(smartHome));
    }

    public void handleEvent(Event event) {
        System.out.println("Got event: " + event);
        Sender sender = new Sender();
        Alarm alarm = smartHome.getAlarm();

        if (alarm.getState() instanceof AlarmDeactivated||(alarm.getState() instanceof AlarmActiveState && event instanceof AlarmEvent)) {
            eventHandlers.forEach(object -> {
                object.handleEvent(event);
            });
        }

        if (alarm.getState() instanceof AlarmActivated||alarm.getState() instanceof AlarmActiveState){
            sender.send("Try change state of home; " + event);
        }

        if (alarm.getState() instanceof AlarmActivated){
            alarm.setState(new AlarmActiveState(alarm));
        }
    }

}
