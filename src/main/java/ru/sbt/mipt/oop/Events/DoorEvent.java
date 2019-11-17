package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.States;

public class DoorEvent implements Event {
    private DoorTypeEvent type;
    private String objectId;

    public DoorEvent(String objectId, DoorTypeEvent type) {
        this.objectId = objectId;
        this.type = type;
    }

    @Override
    public States getState() {
        return type.getState();
    }

    @Override
    public String getObjectId() {
        return objectId;
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

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + this.getType() +
                ", objectId='" + this.getObjectId() + '\'' +
                '}';
    }

}
