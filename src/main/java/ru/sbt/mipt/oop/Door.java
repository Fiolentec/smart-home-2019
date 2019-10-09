package ru.sbt.mipt.oop;

public class Door extends RoomObject{
    private static final String[] st = {" was opened."," was closed."};
    private boolean isOpen;
    private Room room;

    public Door(boolean isOpen, String id) {
        super(id);
        this.isOpen = isOpen;
    }

    public String getId() {
        return id;
    }

    @Override
    public void setState(boolean open) {
        isOpen = open;
        if (room.getName().equals("hall")){
            room.lightOff();
        }
    }

    @Override
    public String getString(){
        return "Door " + this.getId() + " in room " +  room.getName() + ((isOpen)? st[0]:st[1]);
    };

    public void setRoom(Room room) {
        this.room = room;
    }
}
