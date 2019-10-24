package ru.sbt.mipt.oop;

public class Event implements ObjectFinder, GetStateToChange {
    private final String objectId;

    Event(String objectId) {
        this.objectId = objectId;
    }

    String getObjectId() {
        return objectId;
    }

    public String getType() {
        return "";
    }

    BaseEventHandler getHandler() {
        return new RoomObjectEventHandler(this);
    }

    @Override
    public Object findObject(SmartHome home) {
        return null;
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
