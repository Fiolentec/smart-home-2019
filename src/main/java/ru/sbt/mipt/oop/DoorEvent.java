package ru.sbt.mipt.oop;

public class DoorEvent extends Event implements GetStateToChange,GetAction, GetActionToPrint {
    private DoorTypeEvent type;

    public DoorEvent(String id,DoorTypeEvent type) {
        super(id);
        this.type = type;
    }

    @Override
    public States getState() {
        return type.getState();
    }

    @Override
    public String getType(){
        return type.toString();
    }

    @Override
    public Action getAction(){
        return object -> {
            if((object instanceof Door)&&(((Door)object).getId().equals(this.getObjectId()))){
                ((Door)object).setState(this.getState());
            }
        };
    }

    @Override
    public Action getActionToPrint(){
        return object -> {
            if((object instanceof Door)&&(((Door)object).getId().equals(this.getObjectId()))){
                System.out.println(((Door)object).getString());
            }
        };
    }



}
