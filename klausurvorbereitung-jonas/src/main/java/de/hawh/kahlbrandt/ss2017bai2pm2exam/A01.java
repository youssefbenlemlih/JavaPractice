package de.hawh.kahlbrandt.ss2017bai2pm2exam;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class A01 {

    private static long studiesDuration(LocalDate start, int semesterCount) {
        return Duration.between(start, start.plusMonths(semesterCount * 6).plusDays(1)).toDays();
    }

    private static LocalDate latestTestDate(LocalDate start, int semester) {
        return start.plusMonths(semester + 6 * 3).minusDays(1);
    }

    private static long minutesLonger(LocalDate start) {
        LocalDate regularEnd = start.plusDays(studiesDuration(start, 6));
        return Duration.between(start, latestTestDate(start, 3).plusDays(1)).toMinutes();
    }

    public static void main(String[] args) {

        LocalDate studyStart = LocalDate.of(2016, 9, 1);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println("1.");
        System.out.println(studiesDuration(studyStart, 6));

        System.out.println("2.");
        System.out.println(latestTestDate(studyStart, 3).format(dateFormat));

        System.out.println("3.");
        System.out.println(minutesLonger(studyStart));
    }
}
