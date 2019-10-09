package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        String path = "smart-home-1.js";
        // считываем состояние дома из файла
        JsonSmartHomeStateProvider json = new JsonSmartHomeStateProvider(path);
        SmartHome smartHome = json.provideSmartHome();
        // начинаем цикл обработки событий
        start(smartHome);
    }

    private static void start(SmartHome smartHome) {
        Event event = getNextEvent();
        while (event != null) {
            eventHandler(smartHome, event);
            event = getNextEvent();
        }
    }

    private static void eventHandler(SmartHome smartHome, Event event) {
        System.out.println("Got event: " + event);
        RoomObject ro = event.findObject(smartHome);
        if(ro!=null) {
            System.out.println(ro.getString());//print info about event
            ro.setState(event.getState());//set state of event
        }else {
            System.out.println("Object not found or act is not right");
        }
    }


    private static Event getNextEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        String objectId = "" + ((int) (10 * Math.random()));
        Event events[] = {new DoorEvent(objectId,DoorTypeEvent.DOOR_CLOSED),new DoorEvent(objectId,DoorTypeEvent.DOOR_OPEN),
                new LightEvent(objectId,LightTypeEvent.LIGHT_OFF),new LightEvent(objectId,LightTypeEvent.LIGHT_ON)};
        Event event = events[(int) (4 * Math.random())];

        return event;
    }

}
