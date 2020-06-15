package de.hawhamburg.krukenberg_benlemlih.a08.streams_io.ArrayDeque;

import de.hawhamburg.krukenberg_benlemlih.a07.arraydeque.Deque;
import jdk.dynalink.linker.LinkerServices;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
public class ArrayDequeSerializedForm<E> extends ArrayDeque<E> implements Serializable {
    private static final long serialVersionUID = 5877005011480483767L;

    ArrayDequeSerializedForm(List<E> elements) {
        super(elements);
    }

    ArrayDequeSerializedForm() {
        super();
    }

    ArrayDequeSerializedForm(int capacity) {
        super(capacity);
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(elements.length);
        for (E element : elements) {
            out.writeObject(element);
        }
    }

    @SuppressWarnings("unchecked")
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int capacity = in.readInt();
        elements = (E[]) new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            elements[i] = (E) in.readObject();
        }
    }

}
