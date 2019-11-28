package ru.sbt.mipt.oop.EventHandlers;

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
