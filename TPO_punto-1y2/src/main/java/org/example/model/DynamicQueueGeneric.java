package org.example.model;


import org.example.model.nodes.NodeGeneric;

public class DynamicQueueGeneric<T> implements QueueGeneric<T> {
    private NodeGeneric<T> first, last;

    @Override
    public T getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void add(T a) {
        NodeGeneric<T> newNode = new NodeGeneric<>(a, null);
        if (this.isEmpty()) {
            first = last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacía");
        }
        first = first.getNext();
    }
}