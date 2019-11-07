package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Events.LightEvent;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.SmartHome;

public class LightEventHandler extends BaseEventHandler {
    public LightEventHandler(SmartHome smartHome) {
        super(smartHome);
    }

    @Override
    void handleEvent(Event event) {
        if (event instanceof LightEvent) {
            smartHome.execute(objectUp -> {
                if (objectUp instanceof Room){
                    ((Room) objectUp).execute(object ->{
                        if ((object instanceof Light) && (((Light) object).getId().equals(event.getObjectId()))) {
                            ((Light) object).setState(event.getState());
                            String s = String.format("Light %s in room %s %s", ((Light) object).getId(), ((Room) objectUp).getName(), ((Light) object).getState().getString());
                            System.out.println(s);
                        }
                    });
                }
            });
        }
    }
}
