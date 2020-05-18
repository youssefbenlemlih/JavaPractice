package de.hawhamburg.krukenberg_benlemlih.a04.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
public class DateFormattings {
    public static void main(String[] args) {
        Locale arabicLocal = new Locale("ar");
        Locale germanLocal = new Locale("de");
        DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(germanLocal);
        DateTimeFormatter arabicFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(arabicLocal);
        String arabDate = LocalDate.now().format(arabicFormatter);
        String germanDate = LocalDate.now().format(germanFormatter);
        System.out.println("Arabisches Format :" + arabDate);
        System.out.println("Deutsches Format  :" + germanDate);
    }
}
