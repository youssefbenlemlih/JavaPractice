package de.hawhamburg.krukenberg_benlemlih.a04.payment;

import java.util.function.DoubleUnaryOperator;

/**
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
public class FunctionUtils {
    public FunctionUtils() {
    }

    /**
     * Calculates the first found zero point of a monotonic function
     * in the given range
     *
     * @param function   the function for which zero point is calculated.
     *                   The function should be strictly either ascending or descending
     *                   in the given range
     * @param rangeStart the start of the range
     * @param rangeEnd   the end of the range
     * @param precision  the maximum difference between the result and
     *                   the mathematically correct zero point
     * @return the zero point. <c>Double.Nan</c> if none is found
     */
    public static double getZeroPoint(DoubleUnaryOperator function,
                                      double rangeStart,
                                      double rangeEnd,
                                      double precision) {
        double rStart = rangeStart;
        double rEnd = rangeEnd;
        if (rangeEnd < rangeStart) {
            throw new IllegalArgumentException("rangeStart cannot be greater than rangeEnd");
        }
        double rMiddle = Double.NaN;
        boolean ascending = function.applyAsDouble(rStart) < function.applyAsDouble(rEnd);
        while (Math.abs(rStart - rEnd) > precision
                && thereIsZeroPointInRange(function, rStart, rEnd)) {
            rMiddle = (rEnd + rStart) / 2;
            if (function.applyAsDouble(rMiddle) > 0 == ascending) {
                rEnd = rMiddle;
            } else {
                rStart = rMiddle;
            }
        }
        return rMiddle;
    }

    /**
     * This function can be used to estimate whether there is a zero point within an interval of a <b>monotonic</b> function
     */
    public static boolean thereIsZeroPointInRange(DoubleUnaryOperator function, double rangeStart, double rangeEnd) {
        double valueStart = function.applyAsDouble(rangeStart);
        double valueEnd = function.applyAsDouble(rangeEnd);
        return (valueEnd >= 0 && valueStart <= 0) ||
                (valueEnd <= 0 && valueStart >= 0);
    }
}
