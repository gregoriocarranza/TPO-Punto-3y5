package org.example.model;

public class StaticQueueOfStacks implements QueueOfStacks {
    private static final int MAX = 100;
    private final Stack[] stacks;
    private int count;

    public StaticQueueOfStacks() {
        this.stacks = new Stack[MAX];
        this.count = 0;
    }

    @Override
    public void addStack(Stack stack) {
        if (count >= MAX) {
            throw new RuntimeException("No se pueden agregar más pilas, la cola está llena");
        }
        stacks[count] = stack;
        count++;
    }

    @Override
    public void removeStack() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede eliminar, la cola de pilas está vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            stacks[i] = stacks[i + 1];
        }
        count--;
    }

    @Override
    public Stack getFirstStack() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer stack de una cola vacía");
        }
        return stacks[0];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}