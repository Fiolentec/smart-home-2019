package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.RoomObjects.Door;

public class DoorEvent extends Event implements GetStateToChange, GetAction, GetActionToPrint {
    private DoorTypeEvent type;

    public DoorEvent(String id, DoorTypeEvent type) {
        super(id);
        this.type = type;
    }

    @Override
    public States getState() {
        return type.getState();
    }

    @Override
    public String getType() {
        return type.toString();
    }

    @Override
    public Action getAction() {
        return object -> {
            if ((object instanceof Door) && (((Door) object).getId().equals(this.getObjectId()))) {
                ((Door) object).setState(this.getState());
            }
        };
    }

    @Override
    public Action getActionToPrint() {
        return objectUp -> {
            if (objectUp instanceof Room) {
                ((Room) objectUp).execute(object -> {
                    if ((object instanceof Door) && (((Door) object).getId().equals(this.getObjectId()))) {
                        String s = String.format("Door %s in room %s %s", ((Door) object).getId(), ((Room) objectUp).getName(), ((Door) object).getState().getString());
                        System.out.println(s);
                    }
                });
            }
        };
    }


}
