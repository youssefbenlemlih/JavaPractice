package de.hawhamburg.krukenberg_benlemlih.a08.streams_io.MyDeque;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;

/**
 * A class representing an implementation of a Deque Interface
 *
 * @author Youssef Benlehmlih
 * @author Jonas Krukenberg
 */
public class MyDequeSerializedProxy<E> extends MyDeque<E> implements Serializable {

    private static final long serialVersionUID = 9063402925697206126L;

    public MyDequeSerializedProxy(MyDequeProxy<E> proxy) {
        bottom = proxy.bottom;
    }

    public MyDequeSerializedProxy() {
        super();
    }

    public MyDequeSerializedProxy(List<E> initialElements) {
        super((initialElements));
    }

    public Object writeReplace() throws ObjectStreamException {
        return new MyDequeProxy<>(this);
    }

    public static class MyDequeProxy<E> implements Serializable {


        private static final long serialVersionUID = -9208974947863552446L;
        MyEntry<E> bottom;

        public MyDequeProxy(MyDequeSerializedProxy<E> deque) {
            bottom = deque.getBottom();
        }

        private Object readResolve() throws ObjectStreamException {
            return new MyDequeSerializedProxy<>(this);
        }
    }

    private MyEntry<E> getBottom() {
        return bottom;
    }

}
