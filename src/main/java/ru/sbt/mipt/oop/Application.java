package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventHandler;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        String path = "smart-home-1.js";
        // считываем состояние дома из файла
        JsonSmartHomeStateProvider json = new JsonSmartHomeStateProvider(path);
        SmartHome smartHome = json.provideSmartHome();

        EventHandler eventHandlerMy = new EventHandler(smartHome);
        EventGenerator eventGenerator = new EventGenerator();
        // начинаем цикл обработки событий
        SmartHomeManager smartHomeManager = new SmartHomeManager(smartHome, eventHandlerMy, eventGenerator);
        smartHomeManager.startTrackingEvents();
    }


}
