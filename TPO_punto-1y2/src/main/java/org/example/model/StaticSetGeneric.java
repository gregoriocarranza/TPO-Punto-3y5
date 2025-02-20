package org.example.model;

public class StaticSetGeneric<T> implements SetGeneric<T> {
    private static final int MAX = 10000;
    private final Object[] elements;
    private int count;

    public StaticSetGeneric() {
        this.elements = new Object[MAX];
        this.count = 0;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < count; i++) {
            if (elements[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T value) {
        if (!contains(value)) {
            if (count == MAX) {
                throw new RuntimeException("No se pueden agregar más elementos al conjunto");
            }
            elements[count++] = value;
        }
    }

    @Override
    public void remove(Object value) {
        if (isEmpty()) {
            throw new RuntimeException("No se puede eliminar de un conjunto vacío");
        }

        for (int i = 0; i < count; i++) {
            if (elements[i].equals(value)) {
                // Mover el último elemento a la posición eliminada para mantener la estructura
                elements[i] = elements[count - 1];
                elements[count - 1] = null;
                count--;
                return;
            }
        }

        throw new RuntimeException("Elemento no encontrado en el conjunto");
    }

    @Override
    public T getAnyElement() {
        if (isEmpty()) {
            return null;
        }
        return (T) elements[0]; // Devolver el primer elemento sin eliminarlo
    }
}