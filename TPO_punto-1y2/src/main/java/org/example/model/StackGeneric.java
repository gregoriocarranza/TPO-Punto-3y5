package org.example.model;

public interface StackGeneric<T> {
    T getTop();
    boolean isEmpty();
    void add(T a);
    void remove();
}
