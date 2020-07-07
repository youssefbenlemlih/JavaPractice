package de.hawh.kahlbrandt.ss2019bai2pm2exam;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class A01 {
    private A01() {
    }

    public static Comparator<Integer> naturalOrder() {
        return Integer::compare;
    }

    public static long[] generateCoprimes(int number) throws ArithmeticException {
        long[] primes = new long[number];
        for (int i = 0; i < number; i++) {
            long prime;
            if (i == 0) {
                prime = 3;
            } else {
                long previous = primes[i - 1];
                if (i % 2 == 1) {
                    prime = 2 * previous + 1;
                } else {
                    prime = (previous * previous - 3) / 2;
                }
                if (prime < previous) {
                    throw new ArithmeticException("Out of range!, cannot compute value past "+(number-1));
                }
            }
            primes[i] = prime;
        }
        return primes;
    }

    public static Map<String, Long> wordFrequency(String filename) throws IOException {
        Map<String, Long> frequency = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filename)))) {
            br.lines().flatMap(line -> Stream.of(line.split("\\s")))
                        .map(String::toLowerCase).map(s->s.replaceAll("[.,/;]",""))
                        .forEach((word) -> frequency.put(word, frequency.getOrDefault(word, 0L) + 1));
        }
        return frequency;
    }

}
