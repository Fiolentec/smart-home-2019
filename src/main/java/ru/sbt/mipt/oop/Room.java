package ru.sbt.mipt.oop;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
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


    public void setHome(Collection<RoomObject> o) {
        for (RoomObject ro : o) {
            ro.setHome(this.home);
        }
    }

    @Override
    public void execute(Function<Object, Void> action) {
        lights.forEach(light -> {
            light.execute(action);
        });
        doors.forEach(door -> {
            door.execute(action);
        });
        action.apply(this);
    }

}
