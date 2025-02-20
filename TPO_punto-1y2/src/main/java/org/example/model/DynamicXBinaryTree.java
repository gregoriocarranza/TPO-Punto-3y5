package org.example.model;

public class DynamicXBinaryTree implements XBinaryTree {

    private final int root;
    private XBinaryTree left;
    private XBinaryTree right;

    public DynamicXBinaryTree(int root) {
        this.root = root;
    }

    @Override
    public int getRoot() {
        return this.root;
    }

    @Override
    public XBinaryTree getLeft() {
        return this.left;
    }

    @Override
    public XBinaryTree getRight() {
        return this.right;
    }

    @Override
    public void insertLeft(XBinaryTree left) {
        if(left == this) {
            throw new RuntimeException("No se puede agregar el hijo izquierdo porque se genera un ciclo");
        }
        if (this.left != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        this.left = left;
    }

    @Override
    public void insertRight(XBinaryTree right) {
        if(right == this) {
            throw new RuntimeException("No se puede agregar el hijo izquierdo porque se genera un ciclo");
        }
        if (this.right != null) {
            throw new RuntimeException("Ya existe un hijo derecho");
        }
        this.right = right;
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
