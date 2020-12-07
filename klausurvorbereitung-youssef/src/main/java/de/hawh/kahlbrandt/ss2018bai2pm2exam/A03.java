package de.hawh.kahlbrandt.ss2018bai2pm2exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class A03 {
    public static int adornoWinner(Path path) {
        try {
            List<Integer> positions = Files.lines(path)
                    .map(l -> l.indexOf("sich"))
                    .collect(Collectors.toList());
            Optional<Integer> max = positions.stream()
                    .max(Integer::compareTo);
            return max.map(e -> e != -1 ? positions.indexOf(e) : e)
                    .orElse(-1);
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found!", e);
        }
    }

    public static Stream<Integer> collatz(int start) {
        return Stream.iterate(0,
                s->collatzFunction(s,start)!=1,
                s->s++);
    }

    private static int collatzFunction(int n, int start){
        if (n < 0) {
            throw new RuntimeException("n has to be >= 0");
        }
        if (n == 0) {
            return start;
        }
        if (n % 2 == 0) {
            return collatzFunction(n,start) / 2;
        }
        return 3 * collatzFunction(n,start);
    }
}
