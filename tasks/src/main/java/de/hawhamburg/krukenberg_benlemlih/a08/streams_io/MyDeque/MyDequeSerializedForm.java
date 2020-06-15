package de.hawhamburg.krukenberg_benlemlih.a08.streams_io.MyDeque;

import de.hawhamburg.krukenberg_benlemlih.a05.Deque.Deque;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A class representing an implementation of a Deque Interface
 *
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
public class MyDequeSerializedForm<E> extends MyDeque<E> implements Serializable {

    private static final long serialVersionUID = 7268762268813798513L;
    private transient int modCount = 0;

    public MyDequeSerializedForm() {
        super();
    }

    public MyDequeSerializedForm(List<E> initialElements) {
        super(initialElements);
    }

    @Override
    public void addFirst(E e) throws IllegalArgumentException {
        super.addFirst(e);
        increaseModCount();
    }

    @Override
    public void push(E e) {
        super.push(e);
        increaseModCount();
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        E result = super.removeFirst();
        increaseModCount();
        return result;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        E result = super.removeLast();
        increaseModCount();
        return result;
    }

    private void increaseModCount() {
        modCount++;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        // Write out element count, and any hidden stuff
        int expectedModCount = modCount;
        out.defaultWriteObject();
        out.writeInt(size());

        // Write out all elements in the proper order
        bottom.writeObject(out);

        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    @SuppressWarnings("unchecked")
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        // Read in any hidden stuff
        in.defaultReadObject();

        // clear this Deque
        bottom = null;

        // Get size
        int size = in.readInt();

        if (size >= 0) {
            // Read in all elements in the proper order
            for (int i = 0; i < size; i++) {
                push((E) in.readObject());
            }
        } else {
            throw new java.io.InvalidObjectException("Invalid size: " + size);
        }
    }
}
