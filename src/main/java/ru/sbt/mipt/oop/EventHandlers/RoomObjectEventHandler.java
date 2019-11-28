package ru.sbt.mipt.oop.EventHandlers;

import ru.sbt.mipt.oop.Events.Event;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.RoomObjects.RoomObject;
import ru.sbt.mipt.oop.SmartHome;

//public class RoomObjectEventHandler extends BaseEventHandler {
//    private Event event;
//
//    public RoomObjectEventHandler(Event event) {
//        this.event = event;
//    }
//
//    @Override
//    void handleEvent(Object ro) {
//        SmartHome home = new SmartHome();
//        Event event = new Event();
//
//        if ((ro instanceof Light) || (ro instanceof Door)) {
//            if (ro != null) {
//                System.out.println(((RoomObject) ro).getString());//print info about event
//                ((RoomObject) ro).setState(event.getState());//set state of event
//            } else {
//                System.out.println("Object not found or act is not right");
//            }
//        }
//
//        home.execute(object -> {
//            if((object instanceof Door)&&(((Door)object).getId().equals(event.getObjectId()))){
//                System.out.println(((Door)object).getString());
//            }
//        });
//    }
//
//}
