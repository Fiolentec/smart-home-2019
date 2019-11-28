package ru.sbt.mipt.oop.RemoteControlls;

import ru.sbt.mipt.oop.RemoteControlls.actions.BaseAction;
import ru.sbt.mipt.oop.rc.RemoteControl;

import java.util.ArrayList;
import java.util.HashMap;

public class SmartRemoteControl implements RemoteControl {
    private String[] seasons = {"A", "B", "C", "D", "1", "2", "3", "4"};
    private HashMap<String, BaseAction> actions;

    public SmartRemoteControl(ArrayList<BaseAction> act) {
        for (int i = 0; i < act.size(); i++) {
            actions.put(seasons[i], act.get(i));
        }
    }

    public SmartRemoteControl() {
    }

    public void setAction(BaseAction baseAction, String code) {
        actions.put(code, baseAction);
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        BaseAction baseAction = actions.get(buttonCode);
        if (baseAction != null) baseAction.execute();
    }

}