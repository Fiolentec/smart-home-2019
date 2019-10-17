package ru.sbt.mipt.oop;

import java.util.List;

public interface SmartHomeProvider {
    SmartHome provideSmartHome();
    void setHomeToAll(SmartHome smartHome);
}
