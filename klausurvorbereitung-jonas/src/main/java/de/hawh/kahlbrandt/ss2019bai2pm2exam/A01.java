package de.hawh.kahlbrandt.ss2019bai2pm2exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A01 {

    public static Comparator<Integer> naturalOrder() {
        return (o1, o2) -> o1.equals(o2) ? 0 : (o1 < o2 ? -1 : 1);
    }

    public static long[] generateCoprimes(int number) {
        long[] result = new long[number];
        for (int n = 0; n < number; n++) {
            result[n] = getCoPrimeN(n);
        }
        return result;
    }

    private static long getCoPrimeN(int n) {
        if (n == 0) {
            return 3;
        }
        if (n % 2 == 1) {
            return 2 * getCoPrimeN(n - 1) + 1;
        }
        try {
            return (Math.multiplyExact(getCoPrimeN(n - 1), getCoPrimeN(n - 1)) - 3) / 2;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Long value is too high at n=" + n);
        }
    }

    public static Map<String, Long> wordFrequency(String filename) {
        try {
            return Files.lines(Path.of(filename))
                    .flatMap(l -> Stream.of(l.split("\\W+")))
                    .filter(l -> !l.isBlank())
                    .collect(Collectors.toMap(String::toLowerCase, w -> 1L, Long::sum));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }
}
