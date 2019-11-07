package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Events.DoorEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.SmartHome;

public class DoorEventHandler extends BaseEventHandler {
    public DoorEventHandler(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    void handleEvent(Event event) {
        if (event instanceof DoorEvent) {
            smartHome.execute(objectUp -> {
                if(objectUp instanceof Room){
                    ((Room) objectUp).execute(object->{
                        if ((object instanceof Door) && (((Door) object).getId().equals(event.getObjectId()))) {
                            ((Door) object).setState(event.getState());
                            String s = String.format("Door %s in room %s %s", ((Door) object).getId(), ((Room) objectUp).getName(), ((Door) object).getState().getString());
                            System.out.println(s);
                        }
                    });
                }
            });
        }
    }
}
