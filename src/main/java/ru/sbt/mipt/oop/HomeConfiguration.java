package ru.sbt.mipt.oop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.sbt.mipt.oop.API.SensorEventsManager;
import ru.sbt.mipt.oop.EventHandlers.*;
import ru.sbt.mipt.oop.Events.EventsAdapter;
import ru.sbt.mipt.oop.Events.Types.*;
import java.util.List;


@Configuration
public class HomeConfiguration {

    @Bean
    public SensorEventsManager getEventManager(BaseEventHandler eventHandler, BaseEventConverter baseEventConverter) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(new EventsAdapter(eventHandler,baseEventConverter));
        return sensorEventsManager;
    }

    @Bean
    @Primary
    BaseEventHandler eventHandler(List<BaseEventHandler> eventHandlers){
        return new EventProcessor(readSmartHome(), eventHandlers);
    }

    @Bean
    @Qualifier("doorHandler")
    BaseEventHandler doorEventHandler(){
        return new DoorEventHandler(readSmartHome());
    }

    @Bean
    @Qualifier("lightHandler")
    BaseEventHandler lightEventHandler(){
        return new LightEventHandler(readSmartHome());
    }

    @Bean
    @Qualifier("hallDoorHandler")
    BaseEventHandler HallDoorEventHandler(){
        return new HallDoorEventHandler(readSmartHome());
    }

    @Bean
    @Qualifier("alarmHandler")
    BaseEventHandler AlarmEventHandler(){
        return new AlarmEventHandler(readSmartHome());
    }

    @Bean
    SmartHome readSmartHome(){
        JsonSmartHomeStateProvider json = new JsonSmartHomeStateProvider("smart-home-1.js");
        return json.provideSmartHome();
    }

    @Bean
    DoorCloseEventConverter doorCloseEventConverter(){
        return new DoorCloseEventConverter(null);
    }

    @Bean
    DoorLockEventConverter doorLockEventConverter(DoorCloseEventConverter doorCloseEventConverter){
        return new DoorLockEventConverter(doorCloseEventConverter);
    }

    @Bean
    DoorOpenEventConverter doorOpenEventConverter(DoorLockEventConverter doorLockEventConverter){
        return new DoorOpenEventConverter(doorLockEventConverter);
    }

    @Bean
    DoorUnlockEventConverter doorUnlockEventConverter(DoorOpenEventConverter doorOpenEventConverter){
        return new DoorUnlockEventConverter(doorOpenEventConverter);
    }

    @Bean
    LightOffEventConverter lightOffEventConverter(DoorUnlockEventConverter doorUnlockEventConverter){
        return new LightOffEventConverter(doorUnlockEventConverter);
    }

    @Bean
    @Primary
    BaseEventConverter baseEventConverter(LightOffEventConverter lightOffEventConverter){
        return new LightOnEventConverter(lightOffEventConverter);
    }

}

