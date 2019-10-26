package ru.sbt.mipt.oop.RoomObjects;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public interface RoomObjectInterface {

    void setState(States on);

    void setHome(SmartHome home);

    String getString();
}
