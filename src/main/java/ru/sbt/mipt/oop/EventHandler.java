package ru.sbt.mipt.oop;

class EventHandler {
    private SmartHome home;

    EventHandler(SmartHome home) {
        this.home = home;
    }

    void handleEvent(Event event) {
        System.out.println("Got event: " + event);
        home.execute(event.getAction());
        home.execute(event.getActionToPrint());
        checkHallDoorEvent(event);
    }

    private void checkHallDoorEvent(Event event){
        if (event instanceof DoorEvent){
            home.execute(obj -> {
                if ((obj instanceof Door)&&(((Door) obj).getId().equals(event.getObjectId()))){
                    if((home.findRoomForDoor(event.getObjectId())).getName().equals("hall")&&(event.getType().equals("DOOR_CLOSE"))){
                        home.execute(object ->{
                            if (object instanceof Light){
                                ((Light) object).setState(States.LIGHT_OFF);
                                System.out.println(((Light) object).getString());
                            }
                        });
                    }
                }
            });
        }
    }


}
