package com.ilzirabalobanova.epam.learning_center.blocking_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueue {
    private final List<String> messageList = new ArrayList<>();
    private static final int QUEUE_LIMIT = 10;
    private final Deque<String> messageQueue = new ArrayDeque<>(QUEUE_LIMIT);
    public final AtomicInteger sentMessageCount = new AtomicInteger(0);
    public final AtomicInteger receivedMessageCount = new AtomicInteger(0);

    public BlockingQueue() {
        for (int i = 1; i <= 10000; i++) {
            messageList.add(String.format("Message #%d", i));
        }
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public AtomicInteger getSentMessageCount() {
        return sentMessageCount;
    }

    public AtomicInteger getReceivedMessageCount() {
        return receivedMessageCount;
    }

    public synchronized String getMessage() {
        while (messageQueue.isEmpty()) {
            try {
                wait(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Сообщение принято");
        String message = messageQueue.pollFirst();
        notifyAll();
        return message;
    }

    public synchronized void pushMessage(String message) {
        while (messageQueue.size() == QUEUE_LIMIT) {
            try {
                System.out.println("Производитель ожидает");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        messageQueue.push(message);
        System.out.println("Сообщение отправлено " + message);
        notifyAll();
    }
}
