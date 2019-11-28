package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.rc.RemoteControl;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    private Collection<Room> rooms;
    private Collection<RemoteControl> controllers;
    String phoneNumber;
    Alarm alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
        this.phoneNumber = "8-800-555-35-35";
        alarm = new Alarm(this);
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
        this.phoneNumber = "8-800-555-35-35";
        alarm = new Alarm(this);
        rooms.forEach(room -> {
            room.setHome(this);
        });
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
        alarm.execute(action);
        action.execute(this);
    }

    public void addRemoteController(RemoteControl remoteController) {
        controllers.add(remoteController);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
