package ru.sbt.mipt.oop;

public class LightEvent extends Event implements ObjectFinder, GetStateToChange {
    private LightTypeEvent type;

    LightEvent(String id, LightTypeEvent type) {
        super(id);
        this.type = type;
    }

    @Override
    public RoomObject findObject(SmartHome home) {
        return home.findLight(this.getObjectId());
    }

    @Override
    public States getState() {
        return type.getState();
    }

    @Override
    public String getType() {
        return type.toString();
    }
}
