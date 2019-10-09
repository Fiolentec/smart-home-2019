package ru.sbt.mipt.oop;

public class LightEvent extends Event implements ObjectFinder, GetStateToChange {
    private LightTypeEvent type;

    public LightEvent(String id, LightTypeEvent type) {
        super(id);
        this.type = type;
    }

    @Override
    public RoomObject findObject(SmartHome home) {
        for (Room room : home.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(this.getObjectId())) {
                    light.setRoom(room);
                    return light;
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
    public String getType() {
        return type.toString();
    }
}
