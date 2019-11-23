package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Action;

public interface AlarmState {
    Action activate();

    Action deactivate(String code);

}
