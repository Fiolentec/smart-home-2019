package ru.sbt.mipt.oop.Events.Types;

import ru.sbt.mipt.oop.API.CCSensorEvent;
import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.Events.LightEvent;
import ru.sbt.mipt.oop.Events.TypeEvent;
import ru.sbt.mipt.oop.States;

public class LightOffEventConverter implements BaseEventConverter {
    BaseEventConverter nextTypeEvent;

    public LightOffEventConverter(BaseEventConverter nextTypeEvent) {
        this.nextTypeEvent = nextTypeEvent;
    }

    @Override
    public Event get(CCSensorEvent ccSensorEvent) {
        if(ccSensorEvent.getEventType().equals("LightIsOff")){
            return new LightEvent(ccSensorEvent.getObjectId(), TypeEvent.LIGHT_OFF);
        }
        if(nextTypeEvent!=null){
            return nextTypeEvent.get(ccSensorEvent);
        }
        return null;
    }
}
