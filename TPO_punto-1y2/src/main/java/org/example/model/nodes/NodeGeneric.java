package org.example.model.nodes;

public class NodeGeneric<T> {
    private T value;
    private NodeGeneric<T> next;

    public NodeGeneric(T value, NodeGeneric<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeGeneric<T> getNext() {
        return next;
    }

    public void setNext(NodeGeneric<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }
}