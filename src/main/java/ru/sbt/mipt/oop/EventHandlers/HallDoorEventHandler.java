package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.API.CCSensorEvent;
import ru.sbt.mipt.oop.API.EventHandler;
import ru.sbt.mipt.oop.Events.DoorEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Events.EventsAdapter;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public class HallDoorEventHandler extends BaseEventHandler implements EventHandler {

    public HallDoorEventHandler(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    void handleEvent(Event event) {
        if ((event instanceof DoorEvent) && (event.getType().equals("DOOR_CLOSE"))) {
            smartHome.execute(objectUp -> {
                if ((objectUp instanceof Room)) {
                    ((Room) objectUp).execute(object -> {
                        if ((object instanceof Door) && (((Door) object).getId().equals(event.getObjectId())) && (((Room) objectUp).getName().equals("hall"))) {
                            smartHome.execute(obj -> {
                                if (obj instanceof Light) {
                                    ((Light) obj).setState(States.LIGHT_OFF);
                                }
                            });
                        }
                    });
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
