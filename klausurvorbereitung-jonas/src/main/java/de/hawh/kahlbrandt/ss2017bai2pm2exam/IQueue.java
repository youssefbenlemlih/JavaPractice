package de.hawh.kahlbrandt.ss2017bai2pm2exam;

import de.hawh.kahlbrandt.QueueEmptyException;
import de.hawh.kahlbrandt.QueueFullException;

import java.util.Optional;

/**
 * Ein sehr einfaches Interface für eine Queue (First In - First Out Speicher) mit einer beschränkten
 * Kapazität.
 * @author Bernd Kahlbrandt
 *
 */
public interface IQueue<E> {
    int DEFAULT_CAPACITY = 42;
    /**
     * Fügt ein neues Element in die Queue ein. Wirft eine {@link QueueFullException}, wenn die Kapazität
     * der Queue erschöpft ist.
     * @param element
     */
    void enqueue(E element) throws QueueFullException;
    /**
     * Entfernt das zuerst eingefügte Element aus der Queue. Wirft eine {@link QueueEmptyException},
     * wenn die Queue leer ist.
     */
    void dequeue();
    /**
     * Liefert das zuerst eingefügte Element der Queue, das sich noch in der Queue  befindet, via eines {@link Optional}.
     * @return {@link Optional}.
     */
    Optional<E> peek();
    /**
     * Tests if the Queue is full.
     * @return true, iff the Queue is full.
     */
    boolean isFull();
    /**
     * Tests if the Queue is empty.
     * @return true, iff the Queue is empty.
     */
    boolean isEmpty();
}
