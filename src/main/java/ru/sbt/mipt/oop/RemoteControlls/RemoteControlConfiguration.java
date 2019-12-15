package ru.sbt.mipt.oop.RemoteControlls;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.RemoteControlls.actions.*;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.rc.RemoteControl;
import ru.sbt.mipt.oop.rc.RemoteControlRegistry;

import java.util.ArrayList;

@Configuration
public class RemoteControlConfiguration {
    String rcId = "1234";

    @Bean
    RemoteControl remoteControl(SmartHome smartHome) {
        ArrayList<BaseAction> actions = new ArrayList<>();
        actions.add(closeHallDoor(smartHome));
        actions.add(lightOff(smartHome));
        actions.add(onAllLight(smartHome));
        actions.add(onHallLight(smartHome));
        actions.add(alarmActivate(smartHome));
        actions.add(dangerAlarm(smartHome));
        SmartRemoteControl smartRemoteControl = new SmartRemoteControl(actions);
        remoteControlRegistry().registerRemoteControl(smartRemoteControl, rcId);
        return smartRemoteControl;
    }

    @Bean
    RemoteControlRegistry remoteControlRegistry() {
        return new RemoteControlRegistry();
    }

    @Bean
    BaseAction alarmActivate(SmartHome smartHome) {
        return new AlarmActivate(smartHome);
    }

    @Bean
    BaseAction closeHallDoor(SmartHome smartHome) {
        return new CloseHallDoor(smartHome);
    }

    @Bean
    BaseAction lightOff(SmartHome smartHome) {
        return new LightOff(smartHome);
    }

    @Bean
    BaseAction onAllLight(SmartHome smartHome) {
        return new OnAllLight(smartHome);
    }

    @Bean
    BaseAction onHallLight(SmartHome smartHome) {
        return new OnHallLight(smartHome);
    }

    @Bean
    BaseAction dangerAlarm(SmartHome smartHome) {
        return new DangerAlarm(smartHome);
    }

}
