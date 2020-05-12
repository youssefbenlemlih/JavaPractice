package src.main.de.hawhamburg.krukenberg_benlemlih.a06.lambdas_streams;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class MagicDatesStreamsTest {
    @Test
    void getYearsStartingFrom() {
        assertArrayEquals(new Year[]{
                Year.of(2012),
                Year.of(2013),
                Year.of(2014),
                Year.of(2015),
                Year.of(2016),
                Year.of(2017),
                Year.of(2018),
                Year.of(2019),
                Year.of(2020),
                Year.of(2021),
        }, MagicDatesStreams.getYearsStartingFrom(2012).limit(10).toArray());
    }

    @Test
    void getFriday13Dates() {
        assertArrayEquals(new LocalDate[]{
                LocalDate.of(2020,11,13),
                LocalDate.of(2021,8,13),
                LocalDate.of(2022,5,13),
                LocalDate.of(2023,1,13),
                LocalDate.of(2023,10,13),
        }, MagicDatesStreams.getFriday13Dates(LocalDate.of(2020,5,12),5).toArray());
    }
}