package ru.sbt.mipt.oop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class SmartHome implements Actionable {
    private Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
        for (Room r : rooms) {
            r.setHome(this);
        }
    }

    public void addRoom(Room room) {
        rooms.add(room);
        room.setHome(this);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void execute(Action action) {
        rooms.forEach(room -> {
            room.execute(action);
        });
        action.execute(this);
    }
    
}
