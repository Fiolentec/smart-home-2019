package ru.sbt.mipt.oop;

public enum States {
    LIGHT_ON {
        public String getString() {
            return " was turned on.";
        }
    },
    LIGHT_OFF {
        public String getString() {
            return " was turned off.";
        }
    },
    DOOR_CLOSED {
        public String getString() {
            return " was opened.";
        }
    },
    DOOR_OPEN {
        public String getString() {
            return " was closed.";
        }
    },
    ALARM_ACTIVATE {
        public String getString() {
            return " was activated.";
        }
    },
    ALARM_DEACTIVATE {
        public String getString() {
            return " was deactivated.";
        }
    };

    public abstract String getString();
}
