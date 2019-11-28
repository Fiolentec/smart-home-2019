package ru.sbt.mipt.oop.RemoteControlls.actions;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public class OnHallLight extends BaseAction {
    static Action action =
            objectUp -> {
                if (objectUp instanceof SmartHome) {
                    ((SmartHome) objectUp).execute(obj -> {
                        if ((obj instanceof Room) && (((Room) obj).getName().equals("hall"))) {
                            ((Room) obj).execute(object -> {
                                if (object instanceof Light) {
                                    ((Light) object).setState(States.LIGHT_ON);
                                }
                            });
                        }
                    });
                }
            };

    public OnHallLight(SmartHome smartHome) {
        super(smartHome, action);
    }
}
