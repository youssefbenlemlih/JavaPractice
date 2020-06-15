package de.hawhamburg.krukenberg_benlemlih.a08.streams_io.numeric_integration;

import static de.hawhamburg.krukenberg_benlemlih.a08.streams_io.numeric_integration.NumericIntegration.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

import de.hawhamburg.krukenberg_benlemlih.a08.streams_io.RunnableUtils;

/**
 * @author Youssef Benlehmlih
 * @author Jonas Krukenberg
 */
class NumericIntegrationTest {

    @Test
    public void testSerial() {
        assertEquals(2, integrateSerial(x -> x, 0, 2, .1), 0);
        assertEquals(8.0 / 3, integrateSerial(x -> x*x, 0, 2, 1e-1), 1e-2);
        assertEquals(8.0 / 3, integrateSerial(x -> x*x, 0, 2, 1e-2), 1e-4);
    }

    @Test
    public void testParallel() {
        assertEquals(2, integrateParallel(x -> x, 0, 2, .1), 0);
        assertEquals(8.0 / 3, integrateParallel(x -> x*x, 0, 2, 1e-1), 1e-2);
        assertEquals(8.0 / 3, integrateParallel(x -> x*x, 0, 2, 1e-2), 1e-4);
    }

    @Test
    public void compareRuntime() {
        System.out.println("Execution time measurements:\n");
        System.out.printf("%20s | Interval | stepSize | serial | parallel%n%n", "Formula");

        int leftInterval = -5;
        int rightInterval = 5;

        Map<String, Function<Double,Double>> functions = new HashMap<>();
        functions.put("x^3 + 4", x -> x*x*x + 4);
        functions.put("x^2 + 3x - 10", x -> x*x + 3 * x - 10);
        functions.put("x^4", x -> x*x*x*x);

        functions.forEach((functionStr, function) -> {
            for (double stepSize = 1e-1; stepSize > 1e-7; stepSize *= 1e-1) {
                double finalStepSize = stepSize;
                long runtimeSer = RunnableUtils.countDuration(
                        ()->integrateSerial(function, leftInterval, rightInterval, finalStepSize));
                long runtimePar = RunnableUtils.countDuration(
                        ()-> integrateParallel(function, leftInterval, rightInterval, finalStepSize));

                System.out.printf("%20s | [%2d, %2d] | %8.0e | %4dms | %6dms%n",
                        functionStr, leftInterval, rightInterval, stepSize, runtimeSer, runtimePar);
            }
            System.out.println();
        });

    }
}