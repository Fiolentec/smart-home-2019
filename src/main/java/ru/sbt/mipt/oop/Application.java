package ru.sbt.mipt.oop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.sbt.mipt.oop.API.SensorEventsManager;
import ru.sbt.mipt.oop.EventHandlers.*;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(HomeConfiguration.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        sensorEventsManager.start();
//        StartMyManager(smartHome);
    }




}
