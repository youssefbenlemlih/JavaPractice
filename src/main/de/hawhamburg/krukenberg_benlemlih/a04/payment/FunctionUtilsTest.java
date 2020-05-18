package main.de.hawhamburg.krukenberg_benlemlih.a04.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
class FunctionUtilsTest {

    private static final double EPSILON = 0.005;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getZeroPoint() {
        assertEquals(1,
                FunctionUtils.getZeroPoint(
                        (x) -> x - 1,
                        -1,
                        5,
                        EPSILON),
                EPSILON);

        assertEquals(9,
                FunctionUtils.getZeroPoint(
                        (x) -> -x * x + 81,
                        0,
                        500,
                        EPSILON),
                EPSILON);

        assertEquals(Double.NaN,
                FunctionUtils.getZeroPoint(
                        (x) -> -x * x + 81,
                        0,
                        8,
                        EPSILON),
                EPSILON);
    }
}