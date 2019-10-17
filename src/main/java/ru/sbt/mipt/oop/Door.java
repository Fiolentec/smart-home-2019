package ru.sbt.mipt.oop;

import java.util.function.Function;

import javax.swing.*;

public class Door extends RoomObject implements RoomObjectInterface, Actionable{
    private static final String[] st = {" was opened."," was closed."};
    private States isOpen;
    private SmartHome home;

    public Door(String id,States isOpen) {
        super(id);
        this.isOpen = isOpen;
    }

    public Door(String id,String isOpen) {
        super(id);
        this.isOpen = States.valueOf(isOpen);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setState(States open) {
        isOpen = open;
        if (home.findRoomForDoor(this.getId()).getName().equals("hall")&&open.equals(States.DOOR_CLOSED)){
            home.lightOff();
        }
    }

    @Override
    public String getString(){
        return "Door " + this.getId() + " in room " + home.findRoomForDoor(this.getId()).getName() + (isOpen.getString());
    }


    ;

    @Override
    public void setHome(SmartHome home) {
        this.home = home;
    }

    @Override
    public void execute(Function<Object,Void> action) {
        action.apply(this);
    }

    public States getState() {
        return isOpen;
    }

}
