package ru.sbt.mipt.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlarmTest {
    Light light1 = new Light("1", "LIGHT_OFF");
    Light light2 = new Light("2", "LIGHT_ON");
    Door door1 = new Door("3", "DOOR_OPEN");
    List<Door> doors = Arrays.asList(door1);
    List<Light> lights = Arrays.asList(light1, light2);
    Room room = new Room(lights, doors, "hall");
    List<Room> roomList = Arrays.asList(room);
    SmartHome smartHome = new SmartHome(roomList);
    Alarm alarm = new Alarm(smartHome);


    @Test
    void AlarmStandardCreationTypeOfAlarm() {
        Alarm al = new Alarm(smartHome);
        assertTrue(al.getState() instanceof AlarmDeactivated);
    }

    @Test
    void AlarmStandardCreationSmartHome() {
        Alarm al = new Alarm(smartHome);
        assertEquals(al.getSmartHome(), smartHome);
    }

    @Test
    void DeactivatedAlarmAfterActivateBecomeActivated() {
        alarm.activate("123");
        assertTrue(alarm.getState() instanceof AlarmActivated);
    }

    @Test
    void ActivatedAlarmAfterActivateDoesnotChange() {
        alarm.activate("123");
        AlarmStateInterface ala = alarm.getState();
        alarm.activate("12345");
        assertEquals(ala, alarm.getState());
    }

    @Test
    void ActivatedAlarmAfterRightDeactivateBecomeDeactivatedAlarm() {
        Alarm alarm = new Alarm(smartHome);
        alarm.activate("123");
        alarm.deactivate("123");
        assertTrue(alarm.getState() instanceof AlarmDeactivated);
    }

    @Test
    void ActivatedAlarmAfterNotRightDeactivateBecomeActiveStateAlarm() {
        Alarm alarm = new Alarm(smartHome);
        alarm.activate("123");
        alarm.deactivate("1236");
        assertTrue(alarm.getState() instanceof AlarmActiveState);
    }

    @Test
    void ActiveStateAlarmDoesnotChangesAfterDeactivateAndActivate() {
        Alarm alarm = new Alarm(smartHome);
        alarm.activate("123");
        alarm.deactivate("1236");
        assertTrue(alarm.getState() instanceof AlarmActiveState);
        alarm.deactivate("123");
        assertTrue(alarm.getState() instanceof AlarmActiveState);
        alarm.deactivate("1236");
        assertTrue(alarm.getState() instanceof AlarmActiveState);
        alarm.activate("123");
        assertTrue(alarm.getState() instanceof AlarmActiveState);
        alarm.activate("2324");
        assertTrue(alarm.getState() instanceof AlarmActiveState);
    }

}