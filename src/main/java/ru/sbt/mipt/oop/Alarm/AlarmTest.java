package ru.sbt.mipt.oop.Alarm;

import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.SmartHome;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlarmTest {
    Light light1 = new Light("1", "LIGHT_OFF");
    Light light2 = new Light("2", "LIGHT_ON");
    Door door1 = new Door("3", "DOOR_OPEN");
    List<Door> doors = Arrays.asList(door1);
    List<Light> lights = Arrays.asList(light1, light2);
    Room room = new Room(lights, doors, "hall");
    List<Room> roomList = Arrays.asList(room);
    SmartHome smartHome = new SmartHome(roomList);


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
        Alarm alarm = new Alarm(smartHome, 5, "alarmid", "123");
        alarm.activate();
        assertTrue(alarm.getState() instanceof AlarmActivated);
    }

    @Test
    void ActivatedAlarmAfterActivateDoesnotChange() {
        Alarm alarm = new Alarm(smartHome, 5, "alarmid", "123");
        AlarmStateInterface ala = alarm.getState();
        assertEquals(ala, alarm.getState());
    }

    @Test
    void ActivatedAlarmAfterRightDeactivateBecomeDeactivatedAlarm() {
        Alarm alarm = new Alarm(smartHome, 5, "alarmid", "123");
        alarm.deactivate("123");
        assertTrue(alarm.getState() instanceof AlarmDeactivated);
    }

    @Test
    void ActivatedAlarmAfterNotRightDeactivateBecomeActiveStateAlarm() {
        Alarm alarm = new Alarm(smartHome, 5, "alarmid", "123");
        alarm.activate();
        alarm.deactivate("1236");
        assertTrue(alarm.getState() instanceof AlarmActiveState);
    }

    @Test
    void ActiveStateAlarmDoesnotChangesAfterDeactivateAndActivate() {
        Alarm alarm = new Alarm(smartHome, 5, "alarmid", "123");
        alarm.activate();
        alarm.deactivate("1236");
        assertTrue(alarm.getState() instanceof AlarmActiveState);
        alarm.deactivate("123");
        assertTrue(alarm.getState() instanceof AlarmActiveState);
        alarm.deactivate("1236");
        assertTrue(alarm.getState() instanceof AlarmActiveState);
    }

}