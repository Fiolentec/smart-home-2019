package ru.sbt.mipt.oop;

public class DoorEvent extends Event implements ObjectFinder,GetStateToChange {
    private DoorTypeEvent type;

    public DoorEvent(String id,DoorTypeEvent type) {
        super(id);
        this.type = type;
    }

    @Override
    public RoomObject findObject(SmartHome home) {
        for (Room room : home.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(this.getObjectId())) {
                    door.setRoom(room);
                    return door;
                }
            }
        }
        return null;
    }

    @Override
    public boolean getState() {
        return type.getState();
    }

    @Override
    public String getType(){
        return type.toString();
    }

}
