package com.ilzirabalobanova.epam.learning_center.blocking_queue;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer {
    private final BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void getMessage(List<String> messageList, AtomicInteger counter) {
        while (counter.intValue() != messageList.size()) {
            String message = blockingQueue.getMessage();
            System.out.println(message);
            counter.incrementAndGet();
        }
    }
}
