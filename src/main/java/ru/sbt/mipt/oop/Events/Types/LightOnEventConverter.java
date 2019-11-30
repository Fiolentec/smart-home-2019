package ru.sbt.mipt.oop.Events.Types;

import ru.sbt.mipt.oop.API.CCSensorEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Events.LightEvent;
import ru.sbt.mipt.oop.Events.TypeEvent;
import ru.sbt.mipt.oop.States;

public class LightOnEventConverter implements BaseEventConverter {
    BaseEventConverter nextTypeEvent;

    public LightOnEventConverter(BaseEventConverter nextEventType) {
        this.nextTypeEvent = nextEventType;
    }

    @Override
    public Event get(CCSensorEvent ccSensorEvent) {
        if(ccSensorEvent.getEventType().equals("LightIsOn")){
            return new LightEvent(ccSensorEvent.getObjectId(), TypeEvent.LIGHT_ON);
        }
        if(nextTypeEvent!=null){
            return nextTypeEvent.get(ccSensorEvent);
        }
        return null;
    }
}
