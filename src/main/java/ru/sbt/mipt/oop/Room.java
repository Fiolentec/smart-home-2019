package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.RoomObjects.RoomObject;

import java.util.Collection;
import java.util.function.Function;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;
    private SmartHome home;

    public void setHome(SmartHome home) {
        this.home = home;
    }

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(Action action) {
        lights.forEach(light -> {
            light.execute(action);
        });
        doors.forEach(door -> {
            door.execute(action);
        });
        action.execute(this);
    }

}
