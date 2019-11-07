package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.API.SensorEventsManager;
import ru.sbt.mipt.oop.EventHandlers.*;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        String path = "smart-home-1.js";
        // считываем состояние дома из файла
        JsonSmartHomeStateProvider json = new JsonSmartHomeStateProvider(path);
        SmartHome smartHome = json.provideSmartHome();
        //создам обработчик событий и генератор событий
        StartApiManager(smartHome);

//        StartMyApp(smartHome);
    }

    private static void StartMyApp(SmartHome smartHome) {
        EventHandlerMy eventHandlerMy = new EventHandlerMy(smartHome);
        EventGenerator eventGenerator = new EventGenerator();
        // начинаем цикл обработки событий
        SmartHomeManager smartHomeManager = new SmartHomeManager(smartHome, eventHandlerMy, eventGenerator);
        smartHomeManager.startTrackingEvents();
    }

    private static void StartApiManager(SmartHome smartHome) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(event -> {
            System.out.println("Event type [" + event.getEventType() + "] from object with id=[" + event.getObjectId() + "]");
        });
        sensorEventsManager.registerEventHandler(new DoorEventHandler(smartHome));
        sensorEventsManager.registerEventHandler(new LightEventHandler(smartHome));
        sensorEventsManager.registerEventHandler(new HallDoorEventHandler(smartHome));
        sensorEventsManager.registerEventHandler(new AlarmEventHandler(smartHome));
        sensorEventsManager.start();
    }


}
