package de.hawhamburg.krukenberg_benlemlih.a05.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
public class PlayGround {
    public static void main(String[] args) {
        Deque<Object> deque1 = new MyDeque<Object>();
        deque1.addFirst(3.0);
        deque1.addFirst("two");
        deque1.addFirst(1);
        deque1.addLast(4);
        System.out.println(deque1);
    }
}
