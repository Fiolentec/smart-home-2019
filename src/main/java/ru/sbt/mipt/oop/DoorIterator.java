package ru.sbt.mipt.oop;

import java.util.Iterator;

public class DoorIterator implements RoomObjectIteratorInterface {
    private SmartHome smartHome;
    private Iterator<Room> roomIterator;
    private Iterator<Door> doorIterator;
    private Room currentRoom;
    private Door currentDoor;

    DoorIterator(SmartHome smartHome) {
        this.smartHome = smartHome;
        roomIterator = smartHome.getRooms().iterator();
        currentRoom = null;
        doorIterator = null;
        currentDoor = null;
    }

    @Override
    public boolean hasNext() {
        return (roomIterator.hasNext()) || (doorIterator.hasNext());
    }

    @Override
    public RoomObject getNext() {
        if (hasNext()){
            if((doorIterator!=null)&&(doorIterator.hasNext())){
                currentDoor = doorIterator.next();
                return currentDoor;
            }else {
                currentRoom = roomIterator.next();
                doorIterator = currentRoom.getDoors().iterator();
                currentDoor = doorIterator.next();
                return currentDoor;
            }
        }
        return null;
    }

    @Override
    public void reset() {
        roomIterator = smartHome.getRooms().iterator();
        currentRoom = null;
        doorIterator = null;
        currentDoor = null;
    }
}
