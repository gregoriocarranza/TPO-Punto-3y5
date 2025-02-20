package org.example.model;

public interface QueueGeneric<T> {
    T getFirst();
    boolean isEmpty();
    void add(T a);
    void remove();
}
