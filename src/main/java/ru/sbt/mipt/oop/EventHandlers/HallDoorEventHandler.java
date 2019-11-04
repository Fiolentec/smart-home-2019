package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.API.CCSensorEvent;
import ru.sbt.mipt.oop.API.EventHandler;
import ru.sbt.mipt.oop.Events.DoorEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Events.EventsAdapter;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public class HallDoorEventHandler extends BaseEventHandler implements EventHandler {

    public HallDoorEventHandler(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    void handleEvent(Event event){
        if (event instanceof DoorEvent){
            smartHome.execute(obj -> {
                if ((obj instanceof Door)&&(((Door) obj).getId().equals(event.getObjectId()))){
                    if((smartHome.findRoomForDoor(event.getObjectId())).getName().equals("hall")&&(event.getType().equals("DOOR_CLOSE"))){
                        smartHome.execute(object ->{
                            if (object instanceof Light){
                                ((Light) object).setState(States.LIGHT_OFF);
                                System.out.println(((Light) object).getString());
                            }
                        });
                    }
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
