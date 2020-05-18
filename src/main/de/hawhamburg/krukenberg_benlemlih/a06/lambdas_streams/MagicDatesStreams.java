package main.de.hawhamburg.krukenberg_benlemlih.a06.lambdas_streams;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.util.stream.Stream;

import static main.de.hawhamburg.krukenberg_benlemlih.a06.lambdas_streams.StringUtils.isPalindrom;

/**
 * A utility class that works with streams and years
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
public class MagicDatesStreams {
    private MagicDatesStreams() {
    }

    /**
     * @return an infinite Stream of years starting from the given one
     */
    public static Stream<Year> getYearsStartingFrom(Year startYear) {
        return Stream.iterate(startYear,
                (_y) -> true,
                year -> year.plusYears(1));

    }
    public static Stream<Year> getYearsStartingFrom(int startYear) {
        return getYearsStartingFrom(Year.of(startYear));

    }

    public static void printFirstBinaryPalindromeYear(Year startingYear) {
        Year palindrome = getYearsStartingFrom(startingYear)
                .takeWhile(year -> !isPalindrom(Integer.toBinaryString(year.getValue())))
                .map((year) -> year.plusYears(1))
                .reduce((first, second) -> second).orElse(null);
        System.out.println(
                "The first (binary) palindrome year after " + startingYear + " is: "
                        + palindrome.toString()
                        + ", Binary: "
                        + Integer.toBinaryString(palindrome.getValue()));
    }

    public static Stream<LocalDate> getFriday13Dates(LocalDate startingDate) {
        return Stream.iterate(getNextFriday13Date(startingDate),
                year -> true,
                MagicDatesStreams::getNextFriday13Date);
    }

    public static Stream<LocalDate> getFriday13Dates(LocalDate startingDate, int count) {
        return getFriday13Dates(startingDate).limit(count);
    }

    public static Stream<LocalDate> getFriday13Dates(LocalDate startingDate, LocalDate endingDate) {
        return getFriday13Dates(startingDate).takeWhile(date -> date.isBefore(endingDate));
    }

    public static LocalDate getNextFriday13Date(LocalDate startingDate) {
        LocalDate date = startingDate;
        do {
            date = date.plusMonths(1)
                    .plusDays(13 - date.getDayOfMonth());
        }
        while (!(date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13));
        return date;
    }
}
