package org.example.model;
import org.example.model.nodes.NodeGeneric;

public class DynamicStackGeneric<T> implements StackGeneric<T> {
    private NodeGeneric<T> top;

    @Override
    public T getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return top.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public void add(T a) {
        this.top = new NodeGeneric<>(a, this.top);
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar de una pila vacía");
        }
        this.top = this.top.getNext();
    }
}