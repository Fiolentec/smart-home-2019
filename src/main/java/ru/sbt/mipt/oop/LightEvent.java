package ru.sbt.mipt.oop;

import java.util.function.Function;

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
    public Action getAction(){
        return object -> {
            if((object instanceof Light)&&(((Light)object).getId().equals(this.getObjectId()))){
                ((Light)object).setState(this.getState());
            }
        };
    }

    @Override
    public Action getActionToPrint(){
        return object -> {
            if((object instanceof Light)&&(((Light)object).getId().equals(this.getObjectId()))){
                System.out.println(((Light)object).getString());
            }
        };
    }

}
