package model.node;

import model.DynamicQueue;

public class NodeQueue {
    private DynamicQueue value;
    private NodeQueue next;

    public NodeQueue(DynamicQueue value, NodeQueue next) {
        this.value = value;
        this.next = next;
    }

    public DynamicQueue getValue() {
        return value;
    }

    public void setValue(DynamicQueue value) {
        this.value = value;
    }

    public NodeQueue getNext() {
        return next;
    }

    public void setNext(NodeQueue next) {
        this.next = next;
    }
}
