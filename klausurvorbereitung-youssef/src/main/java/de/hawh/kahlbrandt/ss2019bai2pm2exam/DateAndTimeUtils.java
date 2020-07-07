package de.hawh.kahlbrandt.ss2019bai2pm2exam;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateAndTimeUtils {
    public static Map<TemporalUnit, Long> getAge(LocalDate birthday) {
        TemporalUnit[] units = new TemporalUnit[]{
                ChronoUnit.DAYS, ChronoUnit.MONTHS, ChronoUnit.YEARS
        };
        Period period = Period.between(birthday, LocalDate.of(2019,7,3));
        return Stream.of(units).collect(Collectors.toMap(temporalUnit -> temporalUnit, period::get));
    }

    public static Stream<String> getBinaryPalindromYears(LocalDate begin, LocalDate end) {
        return begin.datesUntil(end, Period.ofYears(1))
                .filter(DateAndTimeUtils::isPalindromeYear)
                .filter(date -> date.withMonth(7).withDayOfMonth(25).getDayOfWeek() == DayOfWeek.SUNDAY)
                .map(date -> date.getYear() + "");
    }

    private static boolean isPalindromeYear(LocalDate date) {
        String binary = Integer.toBinaryString(date.getYear());
        return binary.equals(new StringBuilder(binary).reverse().toString());
    }

    public static void main(String[] args) {
        long count = DateAndTimeUtils.getBinaryPalindromYears(
                LocalDate.of(1428, 7, 25),
                LocalDate.of(2427, 7, 25))
                .count();
        //.forEach(System.out::println);
    }
}
