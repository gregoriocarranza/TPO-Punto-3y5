package org.example.model.nodes;

public class PriorityNodeGeneric<T> {
    private T value;
    private int priority;
    private PriorityNodeGeneric<T> next;

    public PriorityNodeGeneric(T value, int priority, PriorityNodeGeneric<T> next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    public PriorityNodeGeneric<T> getNext() {
        return next;
    }

    public void setNext(PriorityNodeGeneric<T> next) {
        this.next = next;
    }
}
