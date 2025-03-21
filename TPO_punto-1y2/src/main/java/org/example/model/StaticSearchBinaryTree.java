package org.example.model;

public class StaticSearchBinaryTree implements SearchBinaryTree {

    private final BinaryTree binaryTree;

    public StaticSearchBinaryTree(int root) {
        this.binaryTree = new StaticBinaryTree(root);
    }

    private StaticSearchBinaryTree(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public int getRoot() {
        return this.binaryTree.getRoot();
    }

    @Override
    public SearchBinaryTree getLeft() {
        BinaryTree left = this.binaryTree.getLeft();
        if (left == null) {
            return null;
        }
        return new StaticSearchBinaryTree(left);
    }

    @Override
    public SearchBinaryTree getRight() {
        BinaryTree right = this.binaryTree.getRight();
        if (right == null) {
            return null;
        }
        return new StaticSearchBinaryTree(right);
    }

    @Override
    public void add(int a) {
        if (a < this.getRoot()) {
            if (this.getLeft() != null) {
                this.getLeft().add(a);
                return;
            }
            this.binaryTree.addLeft(a);
        }
        if (a > this.getRoot()) {
            if (this.getRight() != null) {
                this.getRight().add(a);
                return;
            }
            this.binaryTree.addLeft(a);
        }
    }

    @Override
    public void removeLeft() {
        this.binaryTree.removeLeft();
    }

    @Override
    public void removeRight() {
        this.binaryTree.removeRight();
    }
}
