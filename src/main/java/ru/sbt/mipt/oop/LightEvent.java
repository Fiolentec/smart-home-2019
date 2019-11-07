package ru.sbt.mipt.oop;

public class LightEvent extends Event implements GetStateToChange {
    private LightTypeEvent type;

    public LightEvent(String id, LightTypeEvent type) {
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
            if ((object instanceof Light) && (((Light) object).getId().equals(this.getObjectId()))) {
                ((Light) object).setState(this.getState());
            }
        };
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
