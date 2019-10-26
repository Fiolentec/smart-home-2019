package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.EventHandlers.BaseEventHandler;
import ru.sbt.mipt.oop.GetStateToChange;
import ru.sbt.mipt.oop.EventHandlers.RoomObjectEventHandler;
import ru.sbt.mipt.oop.States;

public class Event implements GetStateToChange {
    private final String objectId;

    Event(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getType() {
        return "";
    }

    public BaseEventHandler getHandler() {
        return new RoomObjectEventHandler(this);
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
}
