package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.States;

public class DoorEvent implements Event {
    private DoorTypeEvent type;
    private String objectId;

    public DoorEvent(String objectId, DoorTypeEvent type) {
        this.objectId = objectId;
        this.type = type;
    }

    @Override
    public States getState() {
        return type.getState();
    }

    @Override
    public String getObjectId() {
        return objectId;
    }

    @Override
    public String getType() {
        return type.toString();
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + this.getType() +
                ", objectId='" + this.getObjectId() + '\'' +
                '}';
    }

}
