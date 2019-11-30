package ru.sbt.mipt.oop.Events.Types;

import ru.sbt.mipt.oop.API.CCSensorEvent;
import ru.sbt.mipt.oop.Events.DoorEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Events.TypeEvent;
import ru.sbt.mipt.oop.States;

public class DoorUnlockEventConverter implements BaseEventConverter {
    BaseEventConverter nextTypeEvent;

    public DoorUnlockEventConverter(BaseEventConverter nextTypeEvent) {
        this.nextTypeEvent = nextTypeEvent;
    }


    @Override
    public Event get(CCSensorEvent ccSensorEvent) {
        if(ccSensorEvent.getEventType().equals("DoorIsUnlocked")){
            return new DoorEvent(ccSensorEvent.getObjectId(), TypeEvent.DOOR_UNLOCK);
        }
        if(nextTypeEvent!=null){
            return nextTypeEvent.get(ccSensorEvent);
        }
        return null;
    }
}
