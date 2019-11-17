package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventHandlers.EventProcessor;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        String path = "smart-home-1.js";
        // считываем состояние дома из файла
        JsonSmartHomeStateProvider json = new JsonSmartHomeStateProvider(path);
        SmartHome smartHome = json.provideSmartHome();

        EventProcessor eventProcessorMy = new EventProcessor(smartHome);
        EventGenerator eventGenerator = new EventGenerator();
        // начинаем цикл обработки событий
        SmartHomeManager smartHomeManager = new SmartHomeManager(smartHome, eventProcessorMy, eventGenerator);
        smartHomeManager.startTrackingEvents();
    }


}
