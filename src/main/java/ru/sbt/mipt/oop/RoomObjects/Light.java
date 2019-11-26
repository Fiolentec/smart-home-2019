package ru.sbt.mipt.oop.RoomObjects;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.States;

public class Light implements BaseRoomObject, Actionable {
    private States isOn;
    final String id;

    public Light(String id, String isOn) {
        this.id = id;
        this.isOn = States.valueOf(isOn);
    }

    public Light(String id, States isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public String getId() {
        return id;
    }


    @Override
    public void setState(States on) {
        isOn = on;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }

    public States getState() {
        return isOn;
    }

}
