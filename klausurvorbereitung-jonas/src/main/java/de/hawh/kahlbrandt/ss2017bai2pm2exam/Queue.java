package de.hawh.kahlbrandt.ss2017bai2pm2exam;

import de.hawh.kahlbrandt.QueueFullException;

import java.util.Optional;

public class Queue<E> implements IQueue<E> {

    public Queue() {
    }


    public Queue(int... initialElements) {
    }

    @Override
    public void enqueue(E element) throws QueueFullException {

    }

    @Override
    public void dequeue() {

    }

    @Override
    public Optional<E> peek() {
        return Optional.empty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
