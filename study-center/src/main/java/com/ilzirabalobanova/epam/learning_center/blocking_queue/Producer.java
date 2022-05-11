package com.ilzirabalobanova.epam.learning_center.blocking_queue;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer {
    private final BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void pushMessage(List<String> messageList, AtomicInteger counter) {
        while (counter.intValue() != messageList.size()) {
            for (String message : messageList) {
                blockingQueue.pushMessage(message);
                counter.incrementAndGet();
            }
        }
    }
}
