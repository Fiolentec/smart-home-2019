package ru.sbt.mipt.oop;

class EventHandler {
    private SmartHome home;

    EventHandler(SmartHome home) {
        this.home = home;
    }

    void handleEvent(Event event) {
        System.out.println("Got event: " + event);
        Object ro = event.findObject(home);
        BaseEventHandler eventHandler = event.getHandler();
        eventHandler.handleEvent(ro);
        if (ro != null) {
            home.alarm.takeHomeEvent(event);
        }
//        if (ro != null) {
//            eventHandler.handleEvent(ro);
//            System.out.println(ro.getString());//print info about event
//            ro.setState(event.getState());//set state of event
//        } else {
//            System.out.println("Object not found or act is not right");
//        }
    }

}
