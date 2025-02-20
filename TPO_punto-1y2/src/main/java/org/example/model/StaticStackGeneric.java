package org.example.model;

public class StaticStackGeneric<T> implements StackGeneric<T> {
    private static final int MAX = 10000;
    private final Object[] array;
    private int count;

    public StaticStackGeneric() {
        this.array = new Object[MAX];
        this.count = 0;
    }

    @Override
    public T getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacía");
        }
        return (T) this.array[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void add(T a) {
        if (count == MAX) {
            throw new RuntimeException("La pila está llena");
        }
        this.array[count++] = a;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar de una pila vacía");
        }
        this.count--;
    }
}