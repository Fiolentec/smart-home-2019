package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.API.CCSensorEvent;
import ru.sbt.mipt.oop.API.EventHandler;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Events.EventsAdapter;
import ru.sbt.mipt.oop.Events.LightEvent;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.SmartHome;

public class LightEventHandler extends BaseEventHandler implements EventHandler {
    public LightEventHandler(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    void handleEvent(Event event) {
        if (event instanceof LightEvent) {
            smartHome.execute(object -> {
                if ((object instanceof Light) && (((Light) object).getId().equals(event.getObjectId()))) {
                    ((Light) object).setState(event.getState());
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
