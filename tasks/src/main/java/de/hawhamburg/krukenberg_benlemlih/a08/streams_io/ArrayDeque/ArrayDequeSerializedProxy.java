package de.hawhamburg.krukenberg_benlemlih.a08.streams_io.ArrayDeque;


import de.hawhamburg.krukenberg_benlemlih.a08.streams_io.MyDeque.MyDequeSerializedProxy;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;

/**
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
public class ArrayDequeSerializedProxy<E> extends ArrayDeque<E> implements Serializable {
    private static final long serialVersionUID = -5560697263996538177L;

    ArrayDequeSerializedProxy(List<E> elements) {
        super(elements);
    }

    ArrayDequeSerializedProxy() {
        super();
    }

    ArrayDequeSerializedProxy(int capacity) {
        super(capacity);
    }

    public Object writeReplace() throws ObjectStreamException {
        return new ArrayDequeProxy<>(this);
    }
    public static class ArrayDequeProxy<E> implements Serializable {

        private static final long serialVersionUID = 1327495565597967210L;
        private final E[] elements;

        public ArrayDequeProxy(ArrayDeque<E> arrayDeque) {
            elements = arrayDeque.elements;
        }

        private Object readResolve() throws ObjectStreamException {
            return new ArrayDeque<>(List.of(elements));
        }
    }

}
