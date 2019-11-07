package ru.sbt.mipt.oop.RemoteControlls;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.SmartHome;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoteControl implements Actionable, RemoteControlInterface {
    private String[] seasons  = {"A", "B", "C", "D", "1", "2", "3", "4"};
    private String rcId;
    SmartHome smartHome;
    private HashMap<String, ButtonActions> actions;

    public RemoteControl(SmartHome smartHome, String rcId, ArrayList<ButtonActions> act) {
        this.smartHome = smartHome;
        this.rcId = rcId;
        for (int i =0; i<act.size();i++){
            actions.put(seasons[i],act.get(i));
        }
    }

    public String getRcId(){
        return rcId;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        smartHome.execute(actions.get(buttonCode).getAction());
    }
}
