package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.States;

public enum AlarmTypeEvent {
    ALARM_ACTIVATE {
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
