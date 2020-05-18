package de.hawhamburg.krukenberg_benlemlih.a06.predicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredicatesUtilsTest {

    @Test
    void anyPredicate() {
        assertTrue(new PredicatesUtils<Integer>().anyPredicate(
                (i)->i%3==0,
                (i)->i%4==0,
                (i)->i%5==0,
                (i)->i%13==0
        ).test(30));
        assertTrue(new PredicatesUtils<String>().anyPredicate(
                (a)->false,
                (a)->true,
                (a)->false,
                (a)->false
        ).test(""));
        assertFalse(new PredicatesUtils<String>().anyPredicate(
                (a)->false,
                (a)->false,
                (a)->false,
                (a)->false
        ).test(""));
    }

    @Test
    void allPredicates() {
        assertTrue(new PredicatesUtils<String>().allPredicates(
                (a)->true,
                (a)->true,
                (a)->true,
                (a)->true
        ).test(""));
        assertFalse(new PredicatesUtils<String>().allPredicates(
                (a)->true,
                (a)->false,
                (a)->true,
                (a)->true
        ).test(""));
        assertFalse(new PredicatesUtils<Integer>().allPredicates(
                (i)->i%3==0,
                (i)->i%4==0,
                (i)->i%5==0,
                (i)->i%13==0
        ).test(30));
    }
}