package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.States;

public interface Event {

//    Event(String objectId) {
//        this.objectId = objectId;
//    }

    String getObjectId();

    String getType();

    States getState();

    Action getAction();

    String toString();

    Action getActionToPrint();
}
