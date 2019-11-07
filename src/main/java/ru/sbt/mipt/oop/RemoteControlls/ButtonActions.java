package ru.sbt.mipt.oop.RemoteControlls;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.RoomObjects.Light;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.States;

public enum ButtonActions {
    LightOff{
        public Action getAction(){
            return obj -> {
                if(obj instanceof Light){
                    ((Light) obj).setState(States.LIGHT_OFF);
                }
            };
        }
    },//    Выключить свет во всем доме
    HallDoorClose{
        public Action getAction(){
            return objectUp -> {
                if (objectUp instanceof SmartHome) {
                    ((SmartHome) objectUp).execute(obj -> {
                        if((obj instanceof Room)&&(((Room) obj).getName().equals("hall"))){
                            ((Room) obj).execute(object ->{
                                if(object instanceof Door){
                                    ((Door) object).setState(States.DOOR_CLOSED);
                                }
                            });
                        }
                        if (obj instanceof Light){
                            ((Light) obj).setState(States.LIGHT_OFF);
                        }
                    });
                }
            };
        }
    },//    Закрыть входную дверь
    HallLightOn{
        public Action getAction(){
            return objectUp -> {
                if (objectUp instanceof SmartHome) {
                    ((SmartHome) objectUp).execute(obj -> {
                        if ((obj instanceof Room) && (((Room) obj).getName().equals("hall"))) {
                            ((Room) obj).execute(object -> {
                                if (object instanceof Light) {
                                    ((Light) object).setState(States.LIGHT_ON);
                                }
                            });
                        }
                    });
                }
            };
        }
    },//    Включить свет в коридоре
    AlarmActivate{
        public Action getAction(){
            return obj -> {
                if(obj instanceof Alarm){
                    ((Alarm) obj).activate();
                }
            };
        }
    },//    Активировать сигнализацию
    AlarmActiveState{
        public Action getAction(){
            return obj -> {
                if (obj instanceof Alarm){
                    ((Alarm) obj).startAlarm();
                }
            };
        }
    },//    Включить режим тревоги сигнализации
    LightOn{
        public Action getAction(){
            return obj -> {
                if(obj instanceof Light){
                    ((Light) obj).setState(States.LIGHT_ON);
                }
            };
        }
    };//    Включить свет во всем доме
    abstract Action getAction();
    }
