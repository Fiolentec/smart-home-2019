package ru.sbt.mipt.oop;

import javax.swing.*;
import java.util.function.Function;

public class RoomObject implements RoomObjectInterface, Actionable {
    final String id;

    public RoomObject(String id) {
        this.id = id;
    }

    public void setState(States mean) {
    }

    public void setHome(SmartHome home) {
    }

    public String getString() {
        return "";
    }

    public String getId() {
        return "";
    }


    @Override
    public void execute(Function<Object, Void> action) {
    }
}
