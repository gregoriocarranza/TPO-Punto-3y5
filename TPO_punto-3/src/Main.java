
import model.DynamicQueue;
import model.DynamicQueueOfQueue;
import model.QueueOfQueue;
import utils.QueueUtil;

public class Main {
    public static void main(String[] args) {
        DynamicQueue queue1 = new DynamicQueue();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);

        DynamicQueue queue2 = new DynamicQueue();
        queue2.add(4);
        queue2.add(5);
        queue2.add(6);

        DynamicQueue queue3 = new DynamicQueue();
        queue3.add(7);
        queue3.add(8);
        queue3.add(9);

        DynamicQueueOfQueue queueOfQueue = new DynamicQueueOfQueue();
        queueOfQueue.add(queue1);
        queueOfQueue.add(queue2);
        queueOfQueue.add(queue3);

        System.out.println("\n===== Ejemplo de QueueOfQueue =====");
        QueueUtil.printQueueOfQueue(queueOfQueue);

        DynamicQueue flattenedQueue = queueOfQueue.flat();
        System.out.println("\n===== Resultado de flat() =====");
        QueueUtil.printQueue(flattenedQueue);

        DynamicQueueOfQueue queueOfQueue2 = new DynamicQueueOfQueue();
        DynamicQueue queue4 = new DynamicQueue();
        queue4.add(10);
        queue4.add(11);
        queue4.add(12);
        queueOfQueue2.add(queue4);
        
        DynamicQueue queue5 = new DynamicQueue();
        queue5.add(20);
        queue5.add(21);
        queue5.add(22);
        queueOfQueue2.add(queue5);

        QueueOfQueue concatenatedQueue = queueOfQueue.concatenate(queueOfQueue2);
        System.out.println("\n===== Resultado de concatenate() =====");
        QueueUtil.printQueueOfQueue(concatenatedQueue);

        QueueOfQueue reversedQueue = queueOfQueue.reverseWithDepth();
        System.out.println("\n===== Resultado de reverseWithDepth() =====");
        QueueUtil.printQueueOfQueue(reversedQueue);
    }

}
