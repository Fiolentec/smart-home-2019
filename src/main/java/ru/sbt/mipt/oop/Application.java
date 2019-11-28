package ru.sbt.mipt.oop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.API.SensorEventsManager;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(HomeConfiguration.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        sensorEventsManager.start();
//        StartMyApp(smartHome);
    }


}
