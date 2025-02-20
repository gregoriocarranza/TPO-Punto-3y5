package utils;

import model.DynamicQueue;
import model.DynamicQueueOfQueue;
import model.QueueOfQueue;
import model.node.NodeQueue;

public class QueueUtil {
    public static void printQueueOfQueue(QueueOfQueue queueOfQueue) {
        DynamicQueueOfQueue tempQueue = (DynamicQueueOfQueue) queueOfQueue;
        NodeQueue current = tempQueue.getFirstNode();

        while (current != null) {
            printQueue(current.getValue());
            current = current.getNext();
        }
    }


    public static void printQueue(DynamicQueue queue) {
        DynamicQueue tempQueue = new DynamicQueue();
        while (!queue.isEmpty()) {
            int value = queue.getFirst();
            System.out.print(value + " ");
            queue.remove();
            tempQueue.add(value);
        }
        System.out.println();

        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.getFirst());
            tempQueue.remove();
        }
    }
}
