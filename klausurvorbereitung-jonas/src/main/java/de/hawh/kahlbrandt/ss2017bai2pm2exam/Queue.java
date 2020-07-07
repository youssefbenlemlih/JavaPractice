package de.hawh.kahlbrandt.ss2017bai2pm2exam;

import de.hawh.kahlbrandt.QueueEmptyException;
import de.hawh.kahlbrandt.QueueFullException;

import java.util.Arrays;
import java.util.Optional;

public class Queue<E> implements IQueue<E> {

    private static final int DEFAULT_SIZE = 42;

    private final int size;
    private final E[] elements;
    private int first;
    private int last;

    public Queue() {
        this(DEFAULT_SIZE);
    }


    @SuppressWarnings("unchecked")
    public Queue(int size) {
        this.size = size;
        elements = (E[]) new Object[size];
    }

    @Override
    public void enqueue(E element) throws QueueFullException {
        if (!isFull()) {
            elements[nextIndex(last)] = element;
            last = nextIndex(last);
        } else {
            throw new QueueFullException("The Queue is full!");
        }
    }

    @Override
    public void dequeue() throws QueueEmptyException {
        if (!isEmpty()) {
            elements[first] = null;
            first = nextIndex(first);
        } else {
            throw new QueueEmptyException("The Queue is empty!");
        }
    }

    @Override
    public Optional<E> peek() {
        return isEmpty() ? Optional.empty() : Optional.of(elements[first]);
    }

    @Override
    public boolean isFull() {
        return elements.length == size;
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    private int nextIndex(int index) {
        return index == size - 1 ? 0 : index + 1;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Queue<?> queue = (Queue<?>) o;

        if (size != queue.size) return false;
        return Arrays.equals(elements, queue.elements);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }
}
