package ru.sbt.mipt.oop;

public enum LightTypeEvent {
    LIGHT_ON{
        public boolean getState(){
            return true;
        }
    }, LIGHT_OFF{
        public boolean getState(){
            return false;
        }
    };
    abstract boolean getState();
}
