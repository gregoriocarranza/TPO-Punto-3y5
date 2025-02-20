package org.example.model.nodes;
import org.example.model.Stack;

public class NodeStack {
    private Stack stack;
    private NodeStack next;

    public NodeStack(Stack stack, NodeStack next) {
        this.stack = stack;
        this.next = next;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public NodeStack getNext() {
        return next;
    }

    public void setNext(NodeStack next) {
        this.next = next;
    }
}