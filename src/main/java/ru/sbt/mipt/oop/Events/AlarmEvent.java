package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.EventHandlers.AlarmEventHandler;
import ru.sbt.mipt.oop.EventHandlers.BaseEventHandler;

public class AlarmEvent extends Event implements GetStateToChange  {
//    private TypeEvent type;
    private String code;

    public AlarmEvent(String objectId, TypeEvent type, String code) {
        super(objectId,type);
//        this.type = type;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getType() {
        return type.toString();
    }

//    @Override
//    public BaseEventHandler getHandler() {
//        return new AlarmEventHandler(this);
//    }


    @Override
    public States getState() {
        return type.getState();
    }

}
