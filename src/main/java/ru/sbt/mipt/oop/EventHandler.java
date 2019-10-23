package ru.sbt.mipt.oop;

class EventHandler {
    private SmartHome home;

    EventHandler(SmartHome home) {
        this.home = home;
    }

    void handleEvent(Event event) {
        System.out.println("Got event: " + event);
        RoomObject ro = event.findObject(home);
        if (ro != null) {
            checkHallDoorEvent(event);
            System.out.println(ro.getString());//print info about event
            ro.setState(event.getState());//set state of event
        } else {
            System.out.println("Object not found or act is not right");
        }
    }

    private void checkHallDoorEvent(Event event){
        if (event instanceof DoorEvent){
            RoomObject ro = event.findObject(home);
            if((home.findRoomForDoor(((Door)ro).getId()).getName().equals("hall")&&(event.getType().equals("DOOR_CLOSE")))){
                home.lightOff();
            }
        }
    }

}
