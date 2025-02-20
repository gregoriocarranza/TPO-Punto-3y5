package org.example.model;

import org.example.model.nodes.PriorityNodeGeneric;

public class DynamicPriorityQueueGeneric<T> implements PriorityQueueGeneric<T>{
    private PriorityNodeGeneric<T> first;

    @Override
    public T getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el valor de una cola vacía");
        }
        return this.first.getValue();
    }

    @Override
    public int getPriority() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad de una cola vacía");
        }
        return this.first.getPriority();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void add(T a, int priority) {
        if (this.isEmpty()) {
            this.first = new PriorityNodeGeneric<>(a, priority, null);
            return;
        }

        if (priority < this.first.getPriority()) {
            this.first = new PriorityNodeGeneric<>(a, priority, this.first);
            return;
        }

        PriorityNodeGeneric<T> current = this.first;
        while (current.getNext() != null && current.getNext().getPriority() <= priority) {
            current = current.getNext();
        }

        current.setNext(new PriorityNodeGeneric<>(a, priority, current.getNext()));
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }
        this.first = this.first.getNext();
    }
}
