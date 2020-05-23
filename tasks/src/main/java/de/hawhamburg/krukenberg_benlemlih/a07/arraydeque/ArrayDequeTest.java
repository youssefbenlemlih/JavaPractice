package de.hawhamburg.krukenberg_benlemlih.a07.arraydeque;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
class ArrayDequeTest {

    private ArrayDeque<String> emptyDeque;
    private ArrayDeque<String> deque3;

    @BeforeEach
    void setUp() {
        emptyDeque = new ArrayDeque<>();
        deque3 = new ArrayDeque<>();
        for (int i = 0; i < 3; i++) {
            deque3.push(i + 1 + "");
        }
    }

    @Test
    void addFirst() {
        deque3.addFirst("0");
        deque3.addFirst("-1");
        assertEquals("-1", deque3.get(0));
        assertEquals("0", deque3.get(1));

        emptyDeque.addFirst("first");
        assertEquals("first", emptyDeque.get(0));
        assertThrows(IllegalArgumentException.class, () -> deque3.addFirst(null));
    }

    @Test
    void addLast() {
        deque3.addLast("four");
        deque3.addLast("last");

        assertEquals("last", deque3.getLast());

        emptyDeque.addLast("last");
        assertThrows(IllegalArgumentException.class, () -> deque3.addLast(null));
        assertEquals("last", emptyDeque.getLast());
    }

    @Test
    void offerFirst() {
        assertTrue(deque3.offerFirst("first"));
        assertTrue(emptyDeque.offerFirst("first"));

        assertFalse(deque3.offerFirst(null));
    }

    @Test
    void offerLast() {
        assertTrue(deque3.offerLast("last"));
        assertTrue(emptyDeque.offerLast("last"));

        assertFalse(deque3.offerLast(null));
    }

    @Test
    void removeFirst() {
        deque3.removeFirst();
        deque3.removeFirst();
        assertEquals("3", deque3.removeFirst());
        assertEquals(emptyDeque, deque3);

        assertThrows(NoSuchElementException.class, () -> emptyDeque.removeFirst());
    }

    @Test
    void removeLast() {
        deque3.removeLast();
        deque3.removeLast();
        assertEquals("1", deque3.removeLast());
        assertEquals(emptyDeque, deque3);

        assertThrows(NoSuchElementException.class, () -> emptyDeque.removeLast());
    }

    @Test
    void pollFirst() {
        assertEquals("1", deque3.pollFirst());

        assertNull(emptyDeque.pollFirst());
    }

    @Test
    void pollLast() {
        assertEquals("3", deque3.pollLast());

        assertNull(emptyDeque.pollLast());
    }

    @Test
    void getFirst() {
        assertEquals("1", deque3.getFirst());
        assertThrows(NoSuchElementException.class, () -> emptyDeque.getFirst());
    }

    @Test
    void getLast() {
        assertEquals("3", deque3.getLast());
        assertThrows(NoSuchElementException.class, () -> emptyDeque.getLast());
    }

    @Test
    void peekFirst() {
        assertEquals("1", deque3.peekFirst());
        assertNull(emptyDeque.peekFirst());
    }

    @Test
    void peekLast() {
        assertEquals("3", deque3.peekLast());
        assertNull(emptyDeque.peekLast());
    }

    @Test
    void size() {
        assertEquals(0, emptyDeque.size());
        assertEquals(3, deque3.size());
        deque3.removeLast();
        assertEquals(2, deque3.size());
    }

    @Test
    void testToString() {
        assertEquals("[1, 2, 3]", deque3.toString());
        assertEquals("[]", emptyDeque.toString());
    }

    @Test
    void testStackStream() {
        assertEquals("321", deque3.stackStream().collect(Collectors.joining()));
        assertEquals("", emptyDeque.stackStream().collect(Collectors.joining()));
    }

    @Test
    void testQueueStream() {
        assertEquals("123", deque3.queueStream().collect(Collectors.joining()));
        assertEquals("", emptyDeque.queueStream().collect(Collectors.joining()));
    }

    @Test
    void testEquals() {
        assertEquals(new ArrayDeque<>(), emptyDeque);
        ArrayDeque<String> sameDeque = new ArrayDeque<>();
        sameDeque.push("1");
        sameDeque.push("2");
        sameDeque.push("3");
        assertEquals(sameDeque, deque3);
        assertNotEquals(emptyDeque, deque3);
//        assertNotEquals(new ArrayDeque<Integer>(), emptyDeque);
    }

    @Test
    void testHashCode() {
        List<Object> list = List.of(emptyDeque, deque3);
        ArrayDeque<String> sameDeque = new ArrayDeque<>();
        sameDeque.push("1");
        sameDeque.push("2");
        sameDeque.push("3");
        assertTrue(list.contains(new ArrayDeque<String>()));
        assertTrue(list.contains(sameDeque));
//        assertFalse(list.contains(new ArrayDeque<Integer>()));
    }
}