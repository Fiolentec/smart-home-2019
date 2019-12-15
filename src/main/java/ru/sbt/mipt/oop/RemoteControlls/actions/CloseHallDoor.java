package ru.sbt.mipt.oop.RemoteControlls.actions;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public class CloseHallDoor extends BaseAction {
    private static Action action =
            objectUp -> {
                if (objectUp instanceof SmartHome) {
                    ((SmartHome) objectUp).execute(obj -> {
                        if ((obj instanceof Room) && (((Room) obj).getName().equals("hall"))) {
                            ((Room) obj).execute(object -> {
                                if (object instanceof Door) {
                                    ((Door) object).setState(States.DOOR_CLOSED);
                                }
                            });
                        }
                        if (obj instanceof Light) {
                            ((Light) obj).setState(States.LIGHT_OFF);
                        }
                    });
                }
            };

    public CloseHallDoor(SmartHome smartHome) {
        super(smartHome, action);
    }

}
