package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.API.SensorEventsManager;
import ru.sbt.mipt.oop.EventHandlers.AlarmEventHandler;
import ru.sbt.mipt.oop.EventHandlers.DoorEventHandler;
import ru.sbt.mipt.oop.EventHandlers.HallDoorEventHandler;
import ru.sbt.mipt.oop.EventHandlers.LightEventHandler;


@Configuration
public class HomeConfiguration {

    @Bean
    public SensorEventsManager getEventManager(){
        String path = "smart-home-1.js";
        // считываем состояние дома из файла
        JsonSmartHomeStateProvider json = new JsonSmartHomeStateProvider(path);
        SmartHome smartHome = json.provideSmartHome();
        //создам обработчик событий и генератор событий
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        RegisterAllHandlers(smartHome,sensorEventsManager);
        return sensorEventsManager;
    }

    @Bean
    public MyEventManager getMyEventManager(){
        String path = "smart-home-1.js";
        // считываем состояние дома из файла
        JsonSmartHomeStateProvider json = new JsonSmartHomeStateProvider(path);
        SmartHome smartHome = json.provideSmartHome();
        MyEventManager myEventManager = new MyEventManager(smartHome);
        return myEventManager;
    }



    private static void RegisterAllHandlers(SmartHome smartHome,SensorEventsManager sensorEventsManager) {
        sensorEventsManager.registerEventHandler(event -> {
            System.out.println("Event type [" + event.getEventType() + "] from object with id=[" + event.getObjectId() + "]");
        });
        sensorEventsManager.registerEventHandler(new DoorEventHandler(smartHome));
        sensorEventsManager.registerEventHandler(new LightEventHandler(smartHome));
        sensorEventsManager.registerEventHandler(new HallDoorEventHandler(smartHome));
        sensorEventsManager.registerEventHandler(new AlarmEventHandler(smartHome));
    }

}


