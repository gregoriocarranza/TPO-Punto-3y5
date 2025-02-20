package model;

import model.node.Node;

public interface Queue {

    int getFirst();

    Node getFirstNode();

    boolean isEmpty();
    void add(int a);
    void remove();

}
