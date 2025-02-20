package org.example.model;

public class DynamicBinaryTree implements BinaryTree {

    private final int root;
    private BinaryTree left;
    private BinaryTree right;

    public DynamicBinaryTree(int root) {
        this.root = root;
    }

    @Override
    public int getRoot() {
        return this.root;
    }

    @Override
    public BinaryTree getLeft() {
        return this.left;
    }

    @Override
    public BinaryTree getRight() {
        return this.right;
    }

    @Override
    public void addLeft(int a) {
        if (this.left != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        this.left = new DynamicBinaryTree(a);
    }

    @Override
    public void addRight(int a) {
        if (this.right != null) {
            throw new RuntimeException("Ya existe un hijo derecho");
        }
        this.right = new DynamicBinaryTree(a);
    }

    @Override
    public void removeLeft() {
        this.left = null;
    }

    @Override
    public void removeRight() {
        this.right = null;
    }
}
