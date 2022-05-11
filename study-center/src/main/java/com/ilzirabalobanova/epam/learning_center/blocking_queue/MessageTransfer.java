package com.ilzirabalobanova.epam.learning_center.blocking_queue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageTransfer {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        BlockingQueue blockingQueue = new BlockingQueue();
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        List<String> messageList = blockingQueue.getMessageList();
        AtomicInteger counter = blockingQueue.getSentMessageCount();
        AtomicInteger counter2 = blockingQueue.getReceivedMessageCount();

        ExecutorService producers = Executors.newFixedThreadPool(3);
        ExecutorService consumers = Executors.newFixedThreadPool(3);

        producers.execute(() -> producer.pushMessage(messageList, counter));
        consumers.execute(() -> consumer.getMessage(messageList, counter2));

        producers.shutdown();
        consumers.shutdown();
        LocalDateTime end = LocalDateTime.now();
        System.out.println(ChronoUnit.MILLIS.between(start, end));
    }
}
