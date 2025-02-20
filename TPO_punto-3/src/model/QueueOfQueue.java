package model;

public interface QueueOfQueue {
    void add(DynamicQueue queue);
    void remove();
    boolean isEmpty();
    DynamicQueue getFirst();
    QueueOfQueue concatenate(QueueOfQueue... queues);
    DynamicQueue flat();
    QueueOfQueue reverseWithDepth();
}
