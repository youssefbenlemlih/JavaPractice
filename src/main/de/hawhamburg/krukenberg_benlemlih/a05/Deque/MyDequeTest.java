package main.de.hawhamburg.krukenberg_benlemlih.a05.Deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
class MyDequeTest {
    Deque<Object> emptyDeque;
    Deque<Object> deque1;
    Deque<Object> deque2;

    @BeforeEach
    void setUp() {
        emptyDeque = new MyDeque<>();
        deque1 = new MyDeque<>(1, "two", 3.0);
        deque2 = new MyDeque<>(deque1, "second");
    }

    @Test
    void addFirst() {
        deque1.addFirst(0);
        deque1.addFirst(-1);
        assertEquals(new MyDeque<>(-1, 0, 1, "two", 3.0), deque1);
        emptyDeque.addFirst("first");

        assertEquals("first", emptyDeque.getFirst());
        assertThrows(IllegalArgumentException.class, () -> deque1.addFirst(null));
    }

    @Test
    void addLast() {
        deque1.addLast("four");
        deque1.addLast("last");

        assertEquals(deque1, new MyDeque<>(1, "two", 3.0, "four", "last"));

        emptyDeque.addLast("last");
        assertThrows(IllegalArgumentException.class, () -> deque1.addLast(null));
        assertEquals(new MyDeque<>("last"), emptyDeque);
    }

    @Test
    void offerFirst() {
        assertTrue(deque1.offerFirst(0));
        assertTrue(emptyDeque.offerFirst("first"));

        assertFalse(deque1.offerFirst(null));
    }

    @Test
    void offerLast() {
        assertTrue(deque1.offerLast("last"));
        assertTrue(emptyDeque.offerLast("last"));

        assertFalse(deque1.offerLast(null));
    }

    @Test
    void removeFirst() {
        deque2.removeFirst();
        deque2.removeFirst();
        assertEquals(emptyDeque, deque2);
        assertEquals(1, deque1.removeFirst());

        assertThrows(NoSuchElementException.class, () -> emptyDeque.removeFirst());
    }

    @Test
    void removeLast() {
        deque2.removeLast();
        deque2.removeLast();
        assertEquals(emptyDeque, deque2);
        assertEquals(3.0, deque1.removeLast());

        assertThrows(NoSuchElementException.class, () -> emptyDeque.removeLast());
    }

    @Test
    void pollFirst() {
        assertEquals(deque1, deque2.pollFirst());
        assertEquals(1, deque1.pollFirst());

        assertNull(emptyDeque.pollFirst());
    }

    @Test
    void pollLast() {
        assertEquals(3.0, deque1.pollLast());

        assertNull(emptyDeque.pollLast());
    }

    @Test
    void getFirst() {
        assertEquals(deque1, deque2.getFirst());
        assertThrows(NoSuchElementException.class, () -> emptyDeque.getFirst());
    }

    @Test
    void getLast() {
        assertEquals("second", deque2.getLast());
        assertThrows(NoSuchElementException.class, () -> emptyDeque.getLast());
    }

    @Test
    void peekFirst() {
        assertEquals(1, deque1.peekFirst());
        assertNull(emptyDeque.peekFirst());
    }

    @Test
    void peekLast() {
        assertEquals(3.0, deque1.peekLast());
        assertNull(emptyDeque.peekLast());
    }

    @Test
    void size() {
        assertEquals(0, emptyDeque.size());
        assertEquals(3, deque1.size());
        assertEquals(2, deque2.size());
        deque2.removeLast();
        assertEquals(1, deque2.size());
    }

    @Test
    void testToString() {
        assertEquals("[MyDeque: 1-> two-> 3.0]", deque1.toString());
        assertEquals("[MyDeque: [MyDeque: 1-> two-> 3.0]-> second]", deque2.toString());
    }

    @Test
    void testEquals() {
        assertEquals(new MyDeque<>(), new MyDeque<>());
        assertEquals(emptyDeque, emptyDeque);
        assertEquals(deque1, new MyDeque<>(1, "two", 3.0));
        assertEquals(deque2, new MyDeque<>(deque1, "second"));
        assertNotEquals(deque2, new MyDeque<>(new MyDeque<>(1, "two", "3.0"), "second"));
    }

    @Test
    void testHashCode() {
        List<Object> list = new ArrayList<>() {
            {
                add(deque1);
                add(deque2);
                add(emptyDeque);
            }
        };
        assertTrue(list.contains(new MyDeque<>(1, "two", 3.0)));
        assertTrue(list.contains(new MyDeque<>(deque1, "second")));
        assertTrue(list.contains(new MyDeque<>()));
    }
}