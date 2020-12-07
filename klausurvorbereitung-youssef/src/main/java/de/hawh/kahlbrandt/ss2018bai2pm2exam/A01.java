package de.hawh.kahlbrandt.ss2018bai2pm2exam;

import java.math.BigInteger;
import java.time.*;
import java.util.Objects;

/**
 * @author Youssef Benlemlih
 */
public class A01 {
    private A01(){}
    public static LocalDate getAnniversary(LocalDate founding, int years) {
        if(years <0)
            throw new RuntimeException("No!");
        return founding.plusYears(years);
    }

    public static ZonedDateTime switchTimeZone(ZonedDateTime zdt, ZoneId zoneId) {
        return ZonedDateTime.of(LocalDateTime.from(zdt), zoneId);
    }

    public static long factorial(long n) {
        if (n < 0) {
            throw new ArithmeticException("noo!");
        }

        return n == 0 ? 1 : Math.multiplyExact(factorial(n - 1), n);
    }

    public static BigInteger factorialBig(int i) {
        if (i < 0) {
            throw new ArithmeticException("noo!");
        }


        return i==0 ? BigInteger.ONE : BigInteger.valueOf(i).multiply(factorialBig(i-1));
    }
}
