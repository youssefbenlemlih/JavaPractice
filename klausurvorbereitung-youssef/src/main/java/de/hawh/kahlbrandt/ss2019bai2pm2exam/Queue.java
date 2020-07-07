package de.hawh.kahlbrandt.ss2019bai2pm2exam;

import de.hawh.kahlbrandt.ss2019bai2pm2exam.interfaces.IQueue;

import java.util.Objects;

public class Queue<T> implements IQueue<T> {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue<?> queue = (Queue<?>) o;
        return Objects.equals(start, queue.start);
    }

    @Override
    public String toString() {
        return "Queue :" + start == null ? "[]" : ("[" + start.toString() + "]");
    }

    @Override
    public int hashCode() {
        return Objects.hash(start);
    }

    QueueElement<T> start;

    public Queue() {
    }

    @Override
    public IQueue<T> enqueue(T element) {
        if (isEmpty()) {
            start = new QueueElement<>(element);
        } else {
            start.enqueue(element);
        }
        return this;
    }

    @Override
    public IQueue<T> dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Empty queue! Cant be deuqued");
        } else {
            start = start.next;
        }
        return this;
    }

    @Override
    public T peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Empty queue! Cant be deuqued");
        } else {
            return start.value;
        }
    }

    @Override
    public int size() {
        if (start == null) {
            return 0;
        }
        return 1 + start.countUntillHead();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private static class QueueElement<E> {
        private QueueElement<E> next;
        private final E value;

        public QueueElement(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString() + ((next == null) ? "" : (", " + next.toString()));
        }

        public void enqueue(E value) {
            if (next != null) {
                next.enqueue(value);
            } else {
                next = new QueueElement<>(value);
            }
        }

        private boolean isHead() {
            return next == null;
        }

        public int countUntillHead() {
            if (this.isHead()) {
                return 0;
            }
            return 1 + next.countUntillHead();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            QueueElement<?> that = (QueueElement<?>) o;
            return Objects.equals(next, that.next) &&
                    value.equals(that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(next, value);
        }
    }
}
