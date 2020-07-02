package de.hawh.kahlbrandt.ss2018bai2pm2exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class A03 {

    public static int adornoWinner(Path path) {
        try {
            int row = -1;
            int index = -1;
            final String[] lines = Files.lines(path).toArray(String[]::new);
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].indexOf("sich") > index) {
                    row = i;
                }
            }
            return row;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static Stream<Integer> collatz(int n) {
        if (n <= 0) {
            throw new RuntimeException("n has to be >= 0");
        }
        return Stream.iterate(n, next -> next > 0, A03::c);
    }

    private static int c(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return c(n - 1) / 2;
        }
        return 3 * c(n - 1);
    }
}
