package ru.sbt.mipt.oop;

public enum DoorTypeEvent {
    DOOR_OPEN {
        public boolean getState(){
            return true;
        }
    }, DOOR_CLOSED{
        public boolean getState(){
            return false;
        }
    };
    abstract boolean getState();
}
