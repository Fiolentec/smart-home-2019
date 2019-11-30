package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    BaseEventHandler eventHandler(List<BaseEventHandler> eventHandlers){
        return new EventProcessor(readSmartHome(), eventHandlers);
    }

    @Bean
    BaseEventHandler doorEventHandler(){
        return new DoorEventHandler(readSmartHome());
    }

    @Bean
    BaseEventHandler lightEventHandler(){
        return new LightEventHandler(readSmartHome());
    }

    @Bean
    BaseEventHandler HallDoorEventHandler(){
        return new HallDoorEventHandler(readSmartHome());
    }

    @Bean
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
    BaseEventConverter baseEventConverter(LightOffEventConverter lightOffEventConverter){
        return new LightOnEventConverter(lightOffEventConverter);
    }

}

