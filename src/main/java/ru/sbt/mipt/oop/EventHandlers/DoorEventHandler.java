package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.API.CCSensorEvent;
import ru.sbt.mipt.oop.API.EventHandler;
import ru.sbt.mipt.oop.Events.DoorEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Events.EventsAdapter;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.SmartHome;

public class DoorEventHandler extends BaseEventHandler implements EventHandler {

    public DoorEventHandler(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    void handleEvent(Event event) {
        if (event instanceof DoorEvent) {
            smartHome.execute(object -> {
                if ((object instanceof Door) && (((Door) object).getId().equals(event.getObjectId()))) {
                    ((Door) object).setState(event.getState());
                    smartHome.execute(event.getActionToPrint());
                }
            });
        }
    }

    @Override
    public void handleEvent(CCSensorEvent sensorEvent) {
        EventsAdapter eventsAdapter = new EventsAdapter(sensorEvent);
        Event event = eventsAdapter.getAdaptedEvent();
        handleEvent(event);
    }
}
