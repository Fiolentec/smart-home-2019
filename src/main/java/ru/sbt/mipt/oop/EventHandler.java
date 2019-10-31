package ru.sbt.mipt.oop;

class EventHandler {
    private SmartHome home;

    EventHandler(SmartHome home) {
        this.home = home;
    }

    void handleEvent(Event event) {
        System.out.println("Got event: " + event);
//        RoomObject ro = event.findObject(home);
        RoomObject ro = findObject(event);
        if (ro != null) {
            System.out.println(ro.getString());//print info about event
            ro.setState(event.getState());//set state of event
        } else {
            System.out.println("Object not found or act is not right");
        }
    }

    private RoomObject findObject(Event event){
        if((event instanceof LightEvent)){
            return home.findLight(event.getObjectId());
        }
        if((event instanceof DoorEvent)){
            return home.findDoor(event.getObjectId());
        }
        return null;
    }

    private void checkHallDoorEvent(Event event){
        if (event instanceof DoorEvent){
            RoomObject ro = findObject(event);
            if (ro instanceof Door){
                if((home.findRoomForDoor(((Door)ro).getId()).getName().equals("hall")&&(event.getType().equals("DOOR_CLOSE")))){
                    home.execute(object ->{
                        if (object instanceof Light){
                            ((Light) object).setState(States.LIGHT_OFF);
                        }
                        return null;
                    });
                }
            }
        }
    }

}
