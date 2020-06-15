package de.hawhamburg.krukenberg_benlemlih.a08.streams_io.numeric_integration;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Youssef Benlehmlih
 * @author Jonas Krukenberg
 */
public class NumericIntegration {

    public static double integrateSerial(Function<? super Double, Double> function, double left, double right,
                                         double stepSize) {

        return iterateInterval(left, right, stepSize)
                .map(function)
                .reduce(0.0, (sum, x) -> sum + x * stepSize);
    }

    public static double integrateParallel(Function<? super Double, Double> function, double left, double right,
                                           double stepSize) {

        return iterateInterval(left, right, stepSize)
                .parallel()
                .map(function)
                .reduce(0.0, (sum, x) -> sum + x * stepSize);
    }

    private static Stream<Double> iterateInterval(double left, double right, double stepSize) {
        return Stream.iterate(left + stepSize / 2, x -> x < right, x -> x + stepSize);
    }
    public static void main(String[] args) {
      System.out.println("f=x², range=[4,5], step=0.1 -> "+integrateSerial((x)->x*x,4,5,0.1));
    }
}
