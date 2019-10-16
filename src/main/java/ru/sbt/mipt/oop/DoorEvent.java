package ru.sbt.mipt.oop;

public class DoorEvent extends Event implements ObjectFinder,GetStateToChange {
    private DoorTypeEvent type;

    public DoorEvent(String id,DoorTypeEvent type) {
        super(id);
        this.type = type;
    }

    @Override
    public RoomObject findObject(SmartHome home) {
        return home.findDoor(this.getObjectId());
    }

    @Override
    public States getState() {
        return type.getState();
    }

    @Override
    public String getType(){
        return type.toString();
    }

}
