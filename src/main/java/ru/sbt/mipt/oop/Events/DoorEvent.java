package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.GetStateToChange;
import ru.sbt.mipt.oop.States;

public class DoorEvent extends Event implements GetStateToChange {
//    private TypeEvent type;

    public DoorEvent(String id, TypeEvent type) {
        super(id,type);
//        this.type = type;
    }

    @Override
    public States getState() {
        return this.type.getState();
    }

    @Override
    public String getType() {
        return super.type.toString();
    }

}
