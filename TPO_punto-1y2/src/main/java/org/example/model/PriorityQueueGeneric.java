package org.example.model;

public interface PriorityQueueGeneric<T> {
    T getFirst();
    int getPriority();
    boolean isEmpty();
    void add(T a, int priority);
    void remove();
}
