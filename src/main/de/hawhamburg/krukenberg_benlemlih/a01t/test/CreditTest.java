package src.main.de.hawhamburg.krukenberg_benlemlih.A01.test;

import src.main.de.hawhamburg.krukenberg_benlemlih.A01.Credit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for credit calculations on class Credit
 *
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
public class CreditTest {

    private Credit credit;

    @BeforeEach
    public void before() {
        credit = new Credit(10000, 3.88, 84);
    }

    @Test
    public void ratePerMonth() {
        assertEquals(136.14, credit.ratePerMonth, 1E-6);
    }

    @Test
    public void annualPercentageRate() {
        assertEquals(credit.getAnnualPercentageRate(), credit.getAnnualPercentageRate2(), 1E-6);
    }

    @Test
    public void tostring() {
        assertEquals(credit.toString().getClass(), String.class);
    }
}