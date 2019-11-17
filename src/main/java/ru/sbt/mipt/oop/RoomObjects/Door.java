package ru.sbt.mipt.oop.RoomObjects;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.States;

public class Door implements BaseRoomObject, Actionable {
    private States isOpen;
    final String id;

    public Door(String id, States isOpen) {
        this.id = id;
        this.isOpen = isOpen;
    }

    public Door(String id, String isOpen) {
        this.id = id;
        this.isOpen = States.valueOf(isOpen);
    }

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
