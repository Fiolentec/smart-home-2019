package ru.sbt.mipt.oop;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.function.Function;

public class Room implements Actionable{
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


    public void setHome(Collection<RoomObject> o){
        for (RoomObject ro: o) {
            ro.setHome(this.home);
        }
    }

    @Override
    public void execute(Function<Object,Void> action) {
        LightIterator lightIterator = new LightIterator(home);
        while (lightIterator.hasNext()){
            RoomObject ro = lightIterator.getNext();
            ro.execute(action);
        }
        DoorIterator doorIterator = new DoorIterator(home);
        while (doorIterator.hasNext()){
            RoomObject ro = lightIterator.getNext();
            ro.execute(action);
        }
        action.apply(this);
    }
}
