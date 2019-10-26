package ru.sbt.mipt.oop.RoomObjects;

import ru.sbt.mipt.oop.RoomObjects.RoomObject;

public interface RoomObjectIteratorInterface {
    boolean hasNext();

    RoomObject getNext();

    void reset();
}
