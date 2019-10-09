package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

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

    public void lightOff(){
        for(Light l: lights){
            l.setState(false);
            System.out.println("Pretent we're sending command " + new SensorCommand(CommandType.LIGHT_OFF,l.getId()));
        }
    }
}
