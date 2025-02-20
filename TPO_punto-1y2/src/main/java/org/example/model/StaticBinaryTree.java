package org.example.model;

public class StaticBinaryTree implements BinaryTree {

    private static final int MAX = 10;
    private final Integer[] array;
    private final int indexRoot;

    public StaticBinaryTree(int root) {
        this.array = new Integer[(int) Math.pow(2, MAX) - 1];
        this.indexRoot = 0;
        this.array[indexRoot] = root;
    }

    private StaticBinaryTree(int indexRoot, Integer[] array) {
        this.array = array;
        this.indexRoot = indexRoot;
    }

    @Override
    public int getRoot() {
        return this.array[this.indexRoot];
    }

    @Override
    public BinaryTree getLeft() {
        if (this.array[2 * indexRoot + 1] == null) {
            return null;
        }
        return new StaticBinaryTree(2 * indexRoot + 1, array);
    }

    @Override
    public BinaryTree getRight() {
        if (this.array[2 * indexRoot + 2] == null) {
            return null;
        }
        return new StaticBinaryTree(2 * indexRoot + 2, array);
    }

    @Override
    public void addLeft(int a) {
        if (this.array[2 * indexRoot + 1] != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        this.array[2 * indexRoot + 1] = a;
    }

    @Override
    public void addRight(int a) {
        if (this.array[2 * indexRoot + 2] != null) {
            throw new RuntimeException("Ya existe un hijo derecho");
        }
        this.array[2 * indexRoot + 2] = a;
    }

    @Override
    public void removeLeft() {
        BinaryTree left = this.getLeft();
        if (left == null) {
            return;
        }
        left.removeLeft();
        left.removeRight();
        this.array[2 * indexRoot + 1] = null;
    }

    @Override
    public void removeRight() {
        BinaryTree right = this.getRight();
        if (right == null) {
            return;
        }
        right.removeLeft();
        right.removeRight();
        this.array[2 * indexRoot + 2] = null;
    }
}
