package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.GetStateToChange;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.States;

public class DoorEvent extends Event implements GetStateToChange, GetAction, GetActionToPrint {

    public DoorEvent(String id, TypeEvent type) {
        super(id, type);
    }

    @Override
    public States getState() {
        return this.type.getState();
    }

    @Override
    public String getType() {
        return super.type.toString();
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
