package de.hawh.kahlbrandt.ss2019bai2pm2exam;

import de.hawh.kahlbrandt.ss2019bai2pm2exam.interfaces.IQueue;

import java.util.Objects;

public class Queue<E> implements IQueue<E> {

    private Element<E> first;
    private int size;

    private static class Element<E> {

        private final E value;
        private Element<E> next;

        Element(E value, Element<E> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            if (next != null && next.next == this) {
                return value.toString();
            }
            return value.toString() + ", " + next.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Element<?> other = (Element<?>) o;

            if (next != null && next.next == this) {
                if (!(other.next != null && other.next.next == other)) {
                    return false;
                }
                return next.value.equals(other.next.value);
            }
            return Objects.equals(value, other.value);
        }

        @Override
        public int hashCode() {
            int result = value != null ? value.hashCode() : 0;
            result = 31 * result + ((next != null && next.next != this) ? next.hashCode() : 0);
            return result;
        }
    }

    public Queue() {

    }

    @Override
    public IQueue<E> enqueue(E element) {
        size++;
        if (first == null) {
            first = new Element<>(element, null);
            return this;
        }
        if (first.next == null) {
            first.next = new Element<>(element, first);
            return this;
        }
        Element<E> curr = first;
        while (curr.next.next != curr) {
            curr = curr.next;
        }
        curr.next.next = new Element<>(element, curr.next);
        return this;
    }

    @Override
    public IQueue<E> dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("The queue is empty!");
        }
        size--;
        first = first.next;
        return this;
    }

    @Override
    public E peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("The queue is empty!");
        }
        return first.value;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        return "[" + first.toString() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Queue<?> queue = (Queue<?>) o;

        return Objects.equals(first, queue.first);
    }

    @Override
    public int hashCode() {
        return first != null ? first.hashCode() : 0;
    }
}
