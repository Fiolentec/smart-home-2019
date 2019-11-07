package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.EventHandlers.BaseEventHandler;
import ru.sbt.mipt.oop.GetStateToChange;
//import ru.sbt.mipt.oop.EventHandlers.RoomObjectEventHandler;
import ru.sbt.mipt.oop.States;

public class Event implements GetStateToChange,GetAction, GetActionToPrint {
    private final String objectId;
    TypeEvent type;

    Event(String objectId,TypeEvent type) {
        this.objectId = objectId;
        this.type = type;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getType() {
        return "";
    }

    @Override
    public States getState() {
        return States.DOOR_CLOSED;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + this.getType() +
                ", objectId='" + this.getObjectId() + '\'' +
                '}';
    }

    @Override
    public Action getActionToPrint() {
        return null;
    }

    @Override
    public Action getAction() {
        return null;
    }
}
