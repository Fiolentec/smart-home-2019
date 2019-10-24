package ru.sbt.mipt.oop;

public enum States {
    LIGHT_ON {
        String getString() {
            return " was turned on.";
        }
    },
    LIGHT_OFF {
        String getString() {
            return " was turned off.";
        }
    },
    DOOR_CLOSED {
        String getString() {
            return " was opened.";
        }
    },
    DOOR_OPEN {
        String getString() {
            return " was closed.";
        }
    },
    ALARM_ACTIVATE {
        String getString() {
            return " was activated.";
        }
    },
    ALARM_DEACTIVATE {
        String getString() {
            return " was deactivated.";
        }
    };

    abstract String getString();
}
