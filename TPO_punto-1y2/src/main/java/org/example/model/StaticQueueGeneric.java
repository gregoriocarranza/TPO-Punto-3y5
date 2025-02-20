package org.example.model;



public class StaticQueueGeneric<T> implements QueueGeneric<T> {
    private static final int MAX = 10000;
    private final Object[] array;
    private int count;

    public StaticQueueGeneric() {
        this.array = new Object[MAX];
        this.count = 0;
    }

    @Override
    public T getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return (T) this.array[0];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void add(T a) {
        if (count == MAX) {
            throw new RuntimeException("La cola está llena");
        }
        this.array[count++] = a;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
    }
}