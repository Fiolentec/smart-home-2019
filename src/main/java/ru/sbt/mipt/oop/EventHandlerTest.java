package ru.sbt.mipt.oop;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventHandlerTest {

    Light light1 = new Light("1", "LIGHT_OFF");
    Light light2 = new Light("2", "LIGHT_ON");
    Door door1 = new Door("3", "DOOR_OPEN");
    List<Door> doors = Arrays.asList(door1);
    List<Light> lights = Arrays.asList(light1, light2);
    Room room = new Room(lights, doors, "hall");
    Event event2 = new DoorEvent("3", DoorTypeEvent.DOOR_CLOSE);
    Event event1 = new LightEvent("1", LightTypeEvent.LIGHT_ON);
    List<Room> roomList = Arrays.asList(room);
    SmartHome smartHome = new SmartHome(roomList);
    EventHandler eventHandler = new EventHandler(smartHome);


    @org.junit.jupiter.api.Test
    void handleEvent() {
        smartHome.setHomeToAll();
//        smartHome.addRoom(room);
        eventHandler.handleEvent(event1);
        Assert.assertEquals(light1.getState(), States.LIGHT_ON);
        eventHandler.handleEvent(event2);
        Assert.assertEquals(door1.getState(), States.DOOR_CLOSED);
        Assert.assertEquals(light1.getState(), States.LIGHT_OFF);
        Assert.assertEquals(light2.getState(), States.LIGHT_OFF);
    }
}