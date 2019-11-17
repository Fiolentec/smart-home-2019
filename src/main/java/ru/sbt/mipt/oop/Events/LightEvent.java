package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.States;

public class LightEvent implements Event {
    private LightTypeEvent type;
    private String objectId;

    public LightEvent(String objectId, LightTypeEvent type) {
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
            if ((object instanceof Light) && (((Light) object).getId().equals(this.getObjectId()))) {
                ((Light) object).setState(this.getState());
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

    @Override
    public Action getActionToPrint() {
        return objectUp -> {
            if (objectUp instanceof Room) {
                ((Room) objectUp).execute(object -> {
                    if ((object instanceof Light) && (((Light) object).getId().equals(this.getObjectId()))) {
                        String s = String.format("Light %s in room %s %s", ((Light) object).getId(), ((Room) objectUp).getName(), ((Light) object).getState().getString());
                        System.out.println(s);
                    }
                });
            }
        };
    }

}
