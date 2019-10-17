package ru.sbt.mipt.oop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SmartHome implements Actionable {
    private Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
        for (Room r:rooms) {
            r.setHome(this);
//            r.setHomeForAll();
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
        room.setHome(this);
//        room.setHomeForAll();
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    RoomObject findDoor(String id){
        DoorIterator iterator = new DoorIterator(this);
        while (iterator.hasNext()){
            RoomObject object = iterator.getNext();
            if (object.getId().equals(id)){
                return object;
            }
        }
//        for (Room room : this.getRooms()) {
//            for (Door door : room.getDoors()) {
//                if (door.getId().equals(id)) {
//                    return door;
//                }
//            }
//        }
        return null;
    }

    RoomObject findLight(String id){
        LightIterator iterator = new LightIterator(this);
        while (iterator.hasNext()){
            RoomObject object = iterator.getNext();
            if (object.getId().equals(id)){
                return object;
            }
        }
//        for (Room room : rooms) {
//            for (Light light : room.getLights()) {
//                if (light.getId().equals(id)) {
////                    light.setRoom(room);
//                    return light;
//                }
//            }
//        }
        return null;
    }

    Room findRoomForLight(String id){
        for (Room room : rooms) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(id)) {
                    return room;
                }
            }
        }
        return null;
    }

    Room findRoomForDoor(String id){

        for (Room room : rooms) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(id)) {
                    return room;
                }
            }
        }
        return null;
    }

    void lightOff(){
        for (Room r:rooms){
            for (Light l : r.getLights()) {
                l.setState(States.LIGHT_OFF);
                System.out.println("Pretent we're sending command " + new SensorCommand(CommandType.LIGHT_OFF, l.getId()));
            }
        }
    }

    public void setHome(Collection<RoomObject> o){
        for (RoomObject ro: o) {
            ro.setHome(this);
        }
    }

    @Override
    public void execute(Action action) {
        RoomIterator roomIterator = new RoomIterator(this);
        while (roomIterator.hasNext()){
            Room room = roomIterator.next();
            room.execute(action);
        }
        action.run(this);
    }

    public void setHomeToAll() {
        for (Room room:this.getRooms()){
            for (Door door: room.getDoors()){
                door.setHome(this);
            }
            for (Light light:room.getLights()){
                light.setHome(this);
            }
        }
    }
}
