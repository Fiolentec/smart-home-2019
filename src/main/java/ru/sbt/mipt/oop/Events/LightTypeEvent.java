package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.States;

public enum LightTypeEvent {
    LIGHT_ON {
        public States getState() {
            return States.LIGHT_ON;
        }
    }, LIGHT_OFF {
        public States getState() {
            return States.LIGHT_OFF;
        }
    };

    abstract States getState();
}
