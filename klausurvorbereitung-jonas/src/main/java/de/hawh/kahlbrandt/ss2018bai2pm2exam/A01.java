package de.hawh.kahlbrandt.ss2018bai2pm2exam;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class A01 {

    private A01() {

    }

    public static LocalDate getAnniversary(LocalDate founding, int years) {
        if (years < 0) {
            throw new IllegalArgumentException("years cannot be negative!");
        }
        return founding.plusYears(years);
    }

    public static ZonedDateTime switchTimeZone(ZonedDateTime zdt, ZoneId zoneId) {
        return zdt.withZoneSameInstant(zoneId);
    }

    public static long factorial(long n) throws ArithmeticException {
        if (n < 0) {
            throw new ArithmeticException("n cannot be lower than zero!");
        }
        if (n == 0) {
            return 1L;
        }
        return Math.multiplyExact(n, factorial(n - 1));
    }
}
