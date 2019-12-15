package ru.sbt.mipt.oop.RemoteControlls.actions;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.SmartHome;

public class BaseAction implements Executable {
    SmartHome smartHome;
    Action action;

    public BaseAction(SmartHome smartHome, Action action) {
        this.smartHome = smartHome;
        this.action = action;
    }


    @Override
    public void execute() {
        smartHome.execute(action);
    }
}
