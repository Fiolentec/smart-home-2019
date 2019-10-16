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
            System.out.println(ro.getString());//print info about event
            ro.setState(event.getState());//set state of event
        } else {
            System.out.println("Object not found or act is not right");
        }
    }

}
