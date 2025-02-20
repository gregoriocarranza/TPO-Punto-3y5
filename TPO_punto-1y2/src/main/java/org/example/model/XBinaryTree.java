package org.example.model;

public interface XBinaryTree {

    int getRoot();

    XBinaryTree getLeft();

    XBinaryTree getRight();

    void insertLeft(XBinaryTree left);

    void insertRight(XBinaryTree right);

    void removeLeft();

    void removeRight();

}
