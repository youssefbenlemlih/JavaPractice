package de.hawhamburg.krukenberg_benlemlih.a07.arraydeque;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
public class ArrayDeque<E> implements Deque<E> {

    public static int DEFAULT_CAPACITY = 5;

    private E[] elements;
    private int capacity;

    /**
     * Default capacity is 5 elements
     */
    ArrayDeque() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * cast warning can be suppressed because everything extends Object
     */
    @SuppressWarnings("unchecked")
    ArrayDeque(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    @Override
    public void addFirst(E e) throws IllegalArgumentException {
        if (e == null) {
            throw new IllegalArgumentException("e darf nicht null sein");
        }
        if (size() == capacity) {
            increaseCapacity();
        }
        if (size() >= 0) {
            System.arraycopy(elements, 0, elements, 1, size());
        }
        elements[0] = e;
    }

    @Override
    public void addLast(E e) throws IllegalArgumentException {
        push(e);
    }

    public void push(E e) {
        if (e == null) {
            throw new IllegalArgumentException("e darf nicht null sein");
        }
        if (size() == capacity) {
            increaseCapacity();
        }
        elements[size()] = e;
    }

    @Override
    public boolean offerFirst(E e) {
        try {
            addLast(e);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public boolean offerLast(E e) {
        try {
            addLast(e);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException("Deque is empty!");
        }
        E first = elements[0];
        System.arraycopy(elements, 1, elements, 0, size() - 1);
        elements[size() - 1] = null;
        return first;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException("Deque is already empty");
        }
        E last = elements[size() - 1];
        elements[size() - 1] = null;
        return last;
    }

    @Override
    public E pop() {
        return removeLast();
    }

    @Override
    public E pollFirst() {
        try {
            return removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public E pollLast() {
        try {
            return removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException("This Deque is empty!");
        }
        return elements[0];
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException("This Deque is empty!");
        }
        return elements[size() - 1];
    }

    @Override
    public E peekFirst() {
        try {
            return getFirst();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    @Override
    public E peekLast() {
        try {
            return getLast();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    @Override
    public int size() {
        int size = 0;
        for (E element : elements) {
            if (element != null) {
                size++;
            }
        }
        return size;
    }

    @Override
    public E get(int index) throws ArrayIndexOutOfBoundsException {
        return elements[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public Stream<E> stackStream() {
        if (size() == 0) {
            return Stream.empty();
        }
        E[] reversed = (E[]) new Object[size()];
        for (int i = size() - 1; i >= 0; i--) {
            reversed[size() - 1 - i] = elements[i];
        }
        return Arrays.stream(reversed);
    }

    @Override
    public Stream<E> queueStream() {
        return Arrays.stream(elements)
                .filter(Objects::nonNull);
    }

    private void increaseCapacity() {
        elements = Arrays.copyOf(elements, ++capacity);
    }

    @Override
    public String toString() {
        E[] notNullElements = Arrays.copyOf(elements, size());
        return Arrays.toString(notNullElements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayDeque<?> that = (ArrayDeque<?>) o;
        return toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }
}
