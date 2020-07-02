package de.hawh.kahlbrandt.ss2018bai2pm2exam;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.util.Optional;

public class Stack<E> implements IStack<E>, Serializable {

    private static final int DEFAULT_CAPACITY = 11;
    private static final long serialVersionUID = 3366065152721695939L;

    private E[] elements;

    private transient int modCount;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * everything can be casted from Object to E
     *
     * @throws NegativeArraySizeException If capacity is lower than zero
     */
    @SuppressWarnings("unchecked")
    public Stack(int capacity) throws NegativeArraySizeException {
        if (capacity < 0) {
            throw new NegativeArraySizeException("capacity has to be greater or equals zero!");
        }
        elements = (E[]) new Object[capacity];
    }

    @Override
    public void push(E element) {
        if (elements.length == size()) {
            modCount++;
            increaseCapacity();
        }
        elements[size()] = element;
    }

    private void increaseCapacity() {
        elements = Arrays.copyOf(elements, elements.length + 1);
    }

    @Override
    public E pop() {
        if (size() == 0) {
            return null;
        }
        E last = elements[size() - 1];
        elements[size() - 1] = null;
        modCount++;
        return last;
    }

    @Override
    public Optional<E> peek() {
        if (size() == 0) {
            return Optional.empty();
        }
        return Optional.of(pop());
    }

    @Override
    public int size() {
        return Math.toIntExact(Arrays.stream(elements)
                .filter(Objects::nonNull)
                .count());
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + Arrays.toString(elements) +
                ", capacity=" + elements.length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stack<?> other = (Stack<?>) o;

        if (elements.length != other.elements.length) return false;
        return Arrays.equals(elements, other.elements);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(elements);
        result = 31 * result + elements.length;
        return result;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        // Write out element count, and any hidden stuff
        int expectedModCount = modCount;
        out.defaultWriteObject();

        out.writeInt(size());
        out.writeInt(elements.length);

        // Write out all elements in the proper order.
        for (int i=0; i < size(); i++) {
            out.writeObject(elements[i]);
        }

        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        // Read in size, and any hidden stuff
        in.defaultReadObject();

        int size = in.readInt();
        int capacity = in.readInt();

        if (size > 0) {
            elements = (E[]) new Object[capacity];

            // Read in all elements in the proper order.
            for (int i = 0; i < size; i++) {
                elements[i] = (E) in.readObject();
            }

        } else if (size == 0) {
            elements = (E[]) new Object[capacity];
        } else {
            throw new java.io.InvalidObjectException("Invalid size: " + size);
        }
    }
}
