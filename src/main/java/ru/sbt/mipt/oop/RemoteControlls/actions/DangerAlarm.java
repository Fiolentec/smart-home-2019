package ru.sbt.mipt.oop.RemoteControlls.actions;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.SmartHome;

public class DangerAlarm extends BaseAction {
    private static Action action = obj -> {
        if (obj instanceof Alarm) {
            ((Alarm) obj).danger();
        }
    };

    public DangerAlarm(SmartHome smartHome) {
        super(smartHome, action);
    }
}
