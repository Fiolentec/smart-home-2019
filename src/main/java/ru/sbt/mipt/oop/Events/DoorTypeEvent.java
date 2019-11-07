package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.States;

public enum DoorTypeEvent {
    DOOR_OPEN {
        public States getState() {
            return States.DOOR_OPEN;
        }
    }, DOOR_CLOSE {
        public States getState() {
            return States.DOOR_CLOSED;
        }
    };

    public abstract States getState();
}
