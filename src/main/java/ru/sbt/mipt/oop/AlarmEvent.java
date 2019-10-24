package ru.sbt.mipt.oop;

public class AlarmEvent extends Event implements ObjectFinder {
    private AlarmTypeEvent type;
    private String code;

    AlarmEvent(String objectId, AlarmTypeEvent type, String code) {
        super(objectId);
        this.type = type;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getType() {
        return type.toString();
    }

    @Override
    BaseEventHandler getHandler() {
        return new AlarmEventHandler(this);
    }

    @Override
    public Object findObject(SmartHome home) {
        return home.getAlarm();
    }

    @Override
    public States getState() {
        return type.getState();
    }

}
