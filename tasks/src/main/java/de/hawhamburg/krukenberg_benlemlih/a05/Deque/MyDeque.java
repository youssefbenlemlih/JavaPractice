package de.hawhamburg.krukenberg_benlemlih.a05.Deque;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * A class representing an implementation of a Deque Interface
 *
 * @author Youssef Benlehmlih
 * @author Jonas Krukenberg
 */
public class MyDeque<E> implements Deque<E> {

    public MyDeque() {
    }

    @SafeVarargs
    public MyDeque(E... initialElements) {
        for (E element : initialElements) {
            addLast(element);
        }
    }

    public MyDeque(List<E> initialElements) {
        initialElements.forEach(this::addLast);
    }

    MyEntry<E> bottom = null;

    private static class MyEntry<E> {

        private final E value;
        private MyEntry<E> next;

        public MyEntry(E value, MyEntry<E> next) {
            this(value);
            this.next = next;
        }

        MyEntry(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString() + (next == null ? "" : "-> " + next);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MyEntry<?> other = (MyEntry<?>) o;

            if (next != null) {
                return value.equals(other.value) && next.equals(other.next);
            }
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            if (next != null) {
                return value.hashCode() + next.hashCode();
            }
            return value.hashCode();
        }

        public E getValue() {
            return value;
        }

        public MyEntry<E> getNext() {
            return next;
        }

        public void setNext(MyEntry<E> next) {
            this.next = next;
        }

        public MyEntry<E> getBeforeHead() {
            return (next.equals( getHead())) ? this:
                    next.getBeforeHead();
        }

        public MyEntry<E> getHead() {
            return (next == null) ? this : next.getHead();
        }

        public int countUntillHead() {
            if (this.equals(getHead())) {
                return 1;
            }
            return next.countUntillHead() + 1;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFirst(E e) throws IllegalArgumentException {
        if (e == null) {
            throw new IllegalArgumentException("e darf nicht null sein");
        }
        if (bottom == null) {
            bottom = new MyEntry<>(e);
        } else {
            bottom = new MyEntry<>(e, bottom);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addLast(E e) throws IllegalArgumentException {
        push(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(E e) {
        if (e == null) {
            throw new IllegalArgumentException("e darf nicht null sein");
        }
            if (bottom == null) {
                bottom = new MyEntry<>(e);
            } else {
                bottom.getHead()
                        .setNext(new MyEntry<>(e));
            }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean offerFirst(E e) {
        try {
            addLast(e);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean offerLast(E e) {
        try {
            addLast(e);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeFirst() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException("Deque is empty!");
        }
        MyEntry<E> first = bottom;
        bottom = bottom.getNext();
        return first.getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E removeLast() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException("Deque is already empty");
        }
        if(size()==1){
            MyEntry<E> last = bottom;
            bottom = null;
            return last.getValue();
        }
        MyEntry<E> head = bottom.getHead();
        MyEntry<E> beforeLast = bottom.getBeforeHead();
        if (beforeLast.equals(bottom)) {
            bottom = beforeLast;
        }
        beforeLast.setNext(null);
        return head.getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E pop() {
        return removeLast();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E pollFirst() {
        try {
            return removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E pollLast() {
        try {
            return removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public E getFirst() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException("This Deque is empty!");
        }
        return bottom.getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E getLast() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException("This Deque is empty!");
        }
        return bottom.getHead()
                .getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E peekFirst() {
        try {
            return getFirst();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E peekLast() {
        try {
            return getLast();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return bottom == null ? 0 : bottom.countUntillHead();
    }

    @Override
    public String toString() {
        return "[MyDeque: " + bottom + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyDeque<?> myDeque = (MyDeque<?>) o;
        if (bottom == null) {
            return myDeque.bottom == null;
        }
        return bottom.equals(myDeque.bottom);
    }

    @Override
    public int hashCode() {
        return bottom.hashCode();
    }
}
