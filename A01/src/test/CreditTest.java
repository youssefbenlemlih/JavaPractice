package test;

import static org.junit.jupiter.api.Assertions.*;

import main.de.hawhamburg.krukenberg_benlemlih.Credit;

class CreditTest {

    private Credit credit;

    @org.junit.jupiter.api.Test
    void setUp() {
        credit = new Credit(10000, 3.88, 84);
    }

    @org.junit.jupiter.api.Test
    void getAnnualPercentageRate() {
        credit = new Credit(10000, 3.88, 84);
        assertEquals(credit.f(0.03), credit.f2(0.03));
        for (double p = 0.001; p < 1; p++) {
            assertEquals(credit.f(p), credit.f2(p));
        }
    }
}