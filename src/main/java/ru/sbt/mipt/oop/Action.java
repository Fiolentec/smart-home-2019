package ru.sbt.mipt.oop;

public interface Action<T,R> {
    R run(T val);
}
