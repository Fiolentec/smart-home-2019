package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.RoomObjects.Door;
import ru.sbt.mipt.oop.RoomObjects.Light;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JsonSmartHomeStateProvider implements SmartHomeProvider {
    String path;

    public JsonSmartHomeStateProvider(String path) {
        this.path = path;
    }


    @Override
    public SmartHome provideSmartHome() {
        Gson gson = new Gson();
        String json;
        try {
            json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        } catch (IOException e) {
            System.out.println("State file not founded, returned new SmartHome");
            return new SmartHome();
        }
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);
        return smartHome;
    }

}
