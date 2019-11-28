package ru.sbt.mipt.oop.RemoteControlls.actions;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public class LightOff extends BaseAction {
    private static Action action = obj -> {
        if (obj instanceof Light) {
            ((Light) obj).setState(States.LIGHT_OFF);
        }
    };

    public LightOff(SmartHome smartHome) {
        super(smartHome, action);
    }

}
