package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.States;

public enum TypeEvent {
//    "LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"
    LIGHT_ON {
        public States getState() {
            return States.LIGHT_ON;
        }
    }, LIGHT_OFF {
        public States getState() {
            return States.LIGHT_OFF;
        }
    }, DOOR_OPEN {
        public States getState() {
            return States.DOOR_OPEN;
        }
    }, DOOR_CLOSE {
        public States getState() {
            return States.DOOR_CLOSED;
        }
    }, DOOR_LOCK{
        public States getState() {
            return States.DOOR_LOCKED;
        }
    }, DOOR_UNLOCK{
        public States getState() {
            return States.DOOR_UNLOCKED;
        }
    }, ALARM_ACTIVATE {
        public States getState() {
            return States.ALARM_ACTIVATE;
        }
    },
    ALARM_DEACTIVATE {
        public States getState() {
            return States.ALARM_DEACTIVATE;
        }
    };

    abstract States getState();
}
