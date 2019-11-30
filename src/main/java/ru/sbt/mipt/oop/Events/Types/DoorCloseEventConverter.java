package ru.sbt.mipt.oop.Events.Types;

import ru.sbt.mipt.oop.API.CCSensorEvent;
import ru.sbt.mipt.oop.Events.DoorEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Events.TypeEvent;
import ru.sbt.mipt.oop.States;

public class DoorCloseEventConverter implements BaseEventConverter {
    BaseEventConverter nextTypeEvent;

    public DoorCloseEventConverter(BaseEventConverter nextTypeEvent) {
        this.nextTypeEvent = nextTypeEvent;
    }

    @Override
    public Event get(CCSensorEvent ccSensorEvent) {
        if (ccSensorEvent.getEventType().equals("DoorIsClosed")){
            return new DoorEvent(ccSensorEvent.getObjectId(), TypeEvent.DOOR_CLOSE);
        }
        if(nextTypeEvent!=null){
            return nextTypeEvent.get(ccSensorEvent);
        }
        return null;
    }

}
