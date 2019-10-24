package ru.sbt.mipt.oop;

import javax.swing.*;
import java.util.function.Function;

public interface Actionable {
    void execute(Function<Object, Void> action);
}
