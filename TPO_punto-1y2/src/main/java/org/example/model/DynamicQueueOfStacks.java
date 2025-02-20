package org.example.model;
import org.example.model.nodes.NodeStack;
public class DynamicQueueOfStacks implements QueueOfStacks {
    private NodeStack first;

    @Override
    public void addStack(Stack stack) {
        if (this.first == null) {
            this.first = new NodeStack(stack, null);
            return;
        }

        NodeStack candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(new NodeStack(stack, null));
    }

    @Override
    public void removeStack() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede eliminar, la cola de pilas está vacía");
        }
        this.first = this.first.getNext();
    }

    @Override
    public Stack getFirstStack() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer stack de una cola vacía");
        }
        return this.first.getStack();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}