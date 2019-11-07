package ru.sbt.mipt.oop;

public class Event implements GetStateToChange, GetAction, GetActionToPrint {
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

    @Override
    public States getState() {
        return States.DOOR_CLOSED;
    }

    @Override
    public Action getAction() {
        return null;
    }

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
}
