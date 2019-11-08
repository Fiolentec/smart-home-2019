package ru.sbt.mipt.oop;

class EventHandler {
    private SmartHome smartHome;

    EventHandler(SmartHome home) {
        this.smartHome = home;
    }

    void handleEvent(Event event) {
        System.out.println("Got event: " + event);
        smartHome.execute(event.getAction());
        smartHome.execute(event.getActionToPrint());
        checkHallDoorEvent(event);
    }

    private void checkHallDoorEvent(Event event) {
        if (event instanceof DoorEvent) {
            smartHome.execute(obj -> {
                if ((event instanceof DoorEvent) && (event.getType().equals("DOOR_CLOSE"))) {
                    smartHome.execute(objectUp -> {
                        if ((objectUp instanceof Room)) {
                            ((Room) objectUp).execute(object -> {
                                if ((object instanceof Door) && (((Door) object).getId().equals(event.getObjectId())) && (((Room) objectUp).getName().equals("hall"))) {
                                    smartHome.execute(o -> {
                                        if (o instanceof Light) {
                                            ((Light) o).setState(States.LIGHT_OFF);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
        }
    }


}
