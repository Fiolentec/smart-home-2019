package ru.sbt.mipt.oop.Events;

import ru.sbt.mipt.oop.API.CCSensorEvent;
import ru.sbt.mipt.oop.API.EventHandler;
import ru.sbt.mipt.oop.EventHandlers.BaseEventHandler;
import ru.sbt.mipt.oop.Events.Types.BaseEventConverter;

public class EventsAdapter implements EventHandler {
    private BaseEventHandler baseEventHandler;
    private BaseEventConverter baseEventConverter;

    public EventsAdapter(BaseEventHandler baseEventHandler, BaseEventConverter baseEventConverter) {
        this.baseEventHandler = baseEventHandler;
        this.baseEventConverter = baseEventConverter;
    }

    @Override
    public void handleEvent(CCSensorEvent event) {
        baseEventHandler.handleEvent(baseEventConverter.get(event));
    }
}
