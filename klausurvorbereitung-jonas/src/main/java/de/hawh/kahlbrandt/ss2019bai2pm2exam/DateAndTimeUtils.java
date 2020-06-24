package de.hawh.kahlbrandt.ss2019bai2pm2exam;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DateAndTimeUtils {

    public static Map<TemporalUnit, Long> getAge(LocalDate date) {
        Period period = date.until(LocalDate.now());
        HashMap<TemporalUnit, Long> ageMap = new HashMap<>();

        ageMap.put(ChronoUnit.YEARS, (long) period.getYears());
        ageMap.put(ChronoUnit.MONTHS, (long) period.getMonths());
        ageMap.put(ChronoUnit.DAYS, (long) period.getDays());

        return ageMap;
    }

    public static Stream<LocalDate> getBinaryPalindromYears(LocalDate date1, LocalDate date2) {
        return Stream.iterate(date1, date -> date.compareTo(date2) < 1, date -> date.plusYears(1L))
                .filter(date ->
                    LocalDate.of(date.getYear(), 7, 25).getDayOfWeek() == DayOfWeek.SUNDAY &&
                    isPalindrom(Integer.toBinaryString(date.getYear()))
                );
    }

    private static boolean isPalindrom(String string) {
        return string.equals(new StringBuilder(string)
                .reverse()
                .toString());
    }
}
