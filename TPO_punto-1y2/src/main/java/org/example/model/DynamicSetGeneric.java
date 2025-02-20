package org.example.model;

import org.example.model.nodes.NodeGeneric;

public class DynamicSetGeneric<T> implements SetGeneric<T> {
    private NodeGeneric<T> head;

    public DynamicSetGeneric() {
        this.head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(T value) {
        NodeGeneric<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void add(T value) {
        if (!contains(value)) {
            head = new NodeGeneric<>(value, head);
        }
    }

    @Override
    public void remove(Object value) {
        if (isEmpty()) {
            throw new RuntimeException("No se puede eliminar de un conjunto vacío");
        }

        // Si el elemento a eliminar está en la cabeza
        if (head.getValue().equals(value)) {
            head = head.getNext();
            return;
        }

        // Buscar el elemento en la lista
        NodeGeneric<T> current = head;
        while (current.hasNext()) {
            if (current.getNext().getValue().equals(value)) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }

        throw new RuntimeException("Elemento no encontrado en el conjunto");
    }

    @Override
    public T getAnyElement() {
        if (isEmpty()) {
            return null;
        }
        return head.getValue(); // Devuelve el primer elemento sin eliminarlo
    } }
