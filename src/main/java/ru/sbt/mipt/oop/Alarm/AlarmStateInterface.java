package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Action;

public interface AlarmStateInterface {
    Action activate();

    Action deactivate(String code);

}
