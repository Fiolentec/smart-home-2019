package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.GetStateToChange;
import ru.sbt.mipt.oop.States;

public class LightEvent extends Event implements GetStateToChange {
//    private TypeEvent type;

    public LightEvent(String id, TypeEvent type) {
        super(id,type);
//        this.type = type;
    }

    @Override
    public States getState() {
        return type.getState();
    }

    @Override
    public String getType() {
        return type.toString();
    }
}
