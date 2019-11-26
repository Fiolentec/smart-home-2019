package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.Alarm;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {
    private Collection<Room> rooms;
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
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }


    public Alarm getAlarm() {
        return alarm;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void execute(Action action) {
        rooms.forEach(room -> {
            room.execute(action);
        });
        alarm.execute(action);
        action.execute(this);
    }

}
