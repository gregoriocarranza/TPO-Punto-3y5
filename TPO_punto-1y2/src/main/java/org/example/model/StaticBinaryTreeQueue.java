package org.example.model;

public class StaticBinaryTreeQueue implements BinaryTreeQueue {

    private static final int MAX = 10000;

    private final BinaryTree[] array;
    private int count;

    public StaticBinaryTreeQueue() {
        this.array = new BinaryTree[MAX];
        this.count = 0;
    }

    @Override
    public BinaryTree getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return this.array[0];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void add(BinaryTree a) {
        this.array[count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacia");
        }
        for (int i = 0; i < this.count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
    }

}
