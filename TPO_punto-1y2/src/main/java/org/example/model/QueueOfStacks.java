package org.example.model;

public interface QueueOfStacks {
    void addStack(Stack stack);
    void removeStack();
    Stack getFirstStack();
    boolean isEmpty();
}