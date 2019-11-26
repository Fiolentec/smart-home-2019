package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.States;

public class AlarmEvent implements Event {
    private AlarmTypeEvent type;
    private String code;
    private String objectId;

    public AlarmEvent(String objectId, AlarmTypeEvent type, String code) {
        this.objectId = objectId;
        this.type = type;
        this.code = code;
    }

    public String getCode() {
        return code;
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
    public States getState() {
        return type.getState();
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + this.getType() +
                ", objectId='" + this.getObjectId() + '\'' +
                '}';
    }

}
