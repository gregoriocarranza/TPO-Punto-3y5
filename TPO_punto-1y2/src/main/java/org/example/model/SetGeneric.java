package org.example.model;

public interface SetGeneric<T> {
    void add(T value);
    boolean contains(T value);
    void remove(Object value);
    boolean isEmpty();
    /**
     * Devuelve un elemento cualquiera del conjunto sin eliminarlo.
     * @return Un elemento del conjunto o `null` si está vacío.
     */
    T getAnyElement();
}
