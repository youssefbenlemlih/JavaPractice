package de.hawh.kahlbrandt.ss2017bai2pm2exam;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class A03 {

    private A03() {

    }

    private static Stream<Integer> holyYears(int start) {
        return Stream.iterate(start, y -> y + 1)
                .filter(y -> LocalDate.of(y, 7, 25).getDayOfWeek() == DayOfWeek.SUNDAY);
    }

    private static List<Integer> pickHolyYears(int startYear, int endYear) {
        return holyYears(startYear)
                .limit(endYear - startYear + 1)
                .filter(y -> y < endYear)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> years = pickHolyYears(2000, 2100);

        IntStream.range(0, years.size() - 1)
                .forEach(i -> System.out.println("Jahr: " + years.get(i) +
                        "\nAbstand: " + (years.get(i + 1) - years.get(i))));
        System.out.println("Jahr: " + years.get(years.size() - 1));
    }
}
