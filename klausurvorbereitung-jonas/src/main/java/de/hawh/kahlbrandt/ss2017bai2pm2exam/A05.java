package de.hawh.kahlbrandt.ss2017bai2pm2exam;

import java.util.Arrays;
import java.util.stream.IntStream;

public final class A05 {

    private A05() {

    }

    public static int sum1(int... coll) {
        return Math.toIntExact(IntStream.of(coll).sum());
    }

    public static int sum2(int... coll) {
        int sum = 0;
        for (int col : coll) {
            sum = Math.addExact(sum, col);
        }
        return sum;
    }

    public static int sum3(int... coll) {
        return Math.toIntExact(Arrays.stream(coll)
                .sum());
    }

    public static int sum4(int... coll) throws ArithmeticException {
        return Math.toIntExact(IntStream.of(coll)
                .reduce(0, Math::addExact));
    }
}
