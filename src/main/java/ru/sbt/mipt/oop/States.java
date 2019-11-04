package ru.sbt.mipt.oop;

public enum States {
    LIGHT_ON{
        String getString(){
            return " was turned on.";
        }
    },
    LIGHT_OFF{
        String getString(){
            return " was turned off.";
        }
    },
    DOOR_CLOSED{
        String getString() {
            return " was closed.";
        }
    },
    DOOR_OPEN{
        String getString() {
            return " was opened.";
        }
    };
    abstract String getString();
}
