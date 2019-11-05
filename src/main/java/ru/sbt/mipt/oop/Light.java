package ru.sbt.mipt.oop;

import javax.swing.*;
import java.util.function.Function;

public class Light extends RoomObject implements RoomObjectInterface,Actionable {
    private States isOn;
    private static final String[] st = {" was turned on.", " was turned off."};
    private SmartHome home;

    public Light(String id, String isOn) {
        super(id);
        this.isOn = States.valueOf(isOn);
    }

    public Light(String id, States isOn) {
        super(id);
        this.isOn = isOn;
    }

    @Override
    public String getId() {
        return id;
    }


    @Override
    public void setState(States on) {
        isOn = on;
    }

    @Override
    public void setHome(SmartHome home) {
        this.home = home;
    }

    @Override
    public String getString() {
        return "Light " + this.getId() + " in room " + home.findRoomForLight(this.getId()).getName() + (isOn.getString());
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }

    public States getState() {
        return isOn;
    }

    ;
}