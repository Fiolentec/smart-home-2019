package ru.sbt.mipt.oop;

public class Light extends RoomObject{
    private boolean isOn;
    private static final String[] st = {" was turned on."," was turned off."};

    private Room room;

    public Light(String id, boolean isOn) {
        super(id);
        this.isOn = isOn;
        this.room = null;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void setState(boolean on) {
        isOn = on;
    }

    @Override
    public String getString(){
        return "Light " + this.getId() + " in room " +  room.getName() + ((isOn)? st[0]:st[1]);
    };
}
