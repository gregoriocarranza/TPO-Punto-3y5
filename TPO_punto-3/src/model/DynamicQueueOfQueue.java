package model;

import model.node.Node;
import model.node.NodeQueue;

public class DynamicQueueOfQueue implements QueueOfQueue {
    private NodeQueue first;

    @Override
    public void add(DynamicQueue queue) {
        if (this.first == null) {
            this.first = new NodeQueue(queue, null);
            return;
        }

        NodeQueue candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(new NodeQueue(queue, null));
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una QueueOfQueue vacía");
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
    public NodeQueue getFirstNode() {
        return this.first;
    }

    @Override
    public DynamicQueue getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una QueueOfQueue vacía");
        }
        return this.first.getValue();
    }

    @Override
    public QueueOfQueue concatenate(QueueOfQueue... queues) {
        DynamicQueueOfQueue result = new DynamicQueueOfQueue();
        copy(result, this.first);
        concatenateMultiple(result, queues, 0);
        return result;
    }

    private void copy(DynamicQueueOfQueue result, NodeQueue current) {
        if (current == null) {
            return;
        }
        result.add(current.getValue());
        copy(result, current.getNext());
    }

    private void concatenateMultiple(DynamicQueueOfQueue result, QueueOfQueue[] queues, int index) {
        if (index >= queues.length) {
            return;
        }

        DynamicQueueOfQueue currentQueue = (DynamicQueueOfQueue) queues[index];
        copy(result, currentQueue.first); // Agregar la cola actual a `result`

        concatenateMultiple(result, queues, index + 1);
    }

    @Override
    public DynamicQueue flat() {
        DynamicQueue result = new DynamicQueue();
        NodeQueue current = this.first;

        while (current != null) {
            DynamicQueue innerQueue = current.getValue();
            Node innerCurrent = innerQueue.getFirstNode();

            while (innerCurrent != null) {
                result.add(innerCurrent.getValue());
                innerCurrent = innerCurrent.getNext();
            }

            current = current.getNext();
        }

        return result;
    }


    @Override
    public QueueOfQueue reverseWithDepth() {
        DynamicQueueOfQueue reversedQueue = new DynamicQueueOfQueue();
        NodeQueue current = this.first;

        while (current != null) {
            DynamicQueue reversedInnerQueue = new DynamicQueue();
            DynamicQueue originalInnerQueue = current.getValue();

            while (!originalInnerQueue.isEmpty()) {
                int value = originalInnerQueue.getFirst();
                originalInnerQueue.remove();

                DynamicQueue temp = new DynamicQueue();
                temp.add(value);
                while (!reversedInnerQueue.isEmpty()) {
                    temp.add(reversedInnerQueue.getFirst());
                    reversedInnerQueue.remove();
                }
                reversedInnerQueue = temp;
            }

            DynamicQueueOfQueue tempQueue = new DynamicQueueOfQueue();
            tempQueue.add(reversedInnerQueue);

            while (!reversedQueue.isEmpty()) {
                tempQueue.add(reversedQueue.getFirst());
                reversedQueue.remove();
            }

            reversedQueue = tempQueue;
            current = current.getNext();
        }

        return reversedQueue;
    }
}
