package de.hawhamburg.krukenberg_benlemlih.a06.comparisons;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
class BetterComparatorTest {
    @Test
    void getBest() {
        assertEquals("123", new BetterComparator<String>()
                .getBest("123", "12345", (String first, String second) -> first.length() < second.length()));
        assertEquals("123", new BetterComparator<String>()
                .getBest("123", "12345", Comparator.comparingInt(String::length)));
    }
}