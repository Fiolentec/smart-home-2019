package ru.sbt.mipt.oop.RoomObjects;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

import java.util.function.Function;

public class Door extends RoomObject implements RoomObjectInterface, Actionable {
    private States isOpen;

    public Door(String id, States isOpen) {
        super(id);
        this.isOpen = isOpen;
    }

    public Door(String id, String isOpen) {
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
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }

    public States getState() {
        return isOpen;
    }

}