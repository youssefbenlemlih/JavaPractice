package main.de.hawhamburg.krukenberg_benlemlih.a04.payment;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for {@link Payment}
 *
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
class PaymentTest {

    private static final double EPSILON = .5;

    @BeforeEach
    void setUp() {
    }

    /**
     * expected values from
     * <a href="https://n-heydorn.de/barwertrechner.html">Online calculator</a>
     */
    @Test
    void getCashValueOfOnePayment() {
        Payment p = new Payment(10404, 0.02, LocalDate.of(2022, 12, 31));
        assertEquals(10000, p.getCashValueOfFuturePayment(LocalDate.now()), EPSILON);
        assertEquals(10200, p.getCashValueOfFuturePayment(LocalDate.now().plusYears(1)), EPSILON);
        assertEquals(10404, p.getCashValueOfFuturePayment(LocalDate.now().plusYears(2)), EPSILON);
    }

    @Test
    void getCashValueOfPaymentList() {
        ArrayList<Payment> payments = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            payments.add(new Payment(594, 0.02, LocalDate.now().plusYears(i)));
        }
        assertEquals(2800, PaymentUtils.getCashValueOfAllPayments(payments, LocalDate.now()), EPSILON);
        assertEquals(2912.9, PaymentUtils.getCashValueOfAllPayments(payments, LocalDate.now().plusYears(2)), EPSILON);
    }

    @Test
    void getEffectiveRate() {
        ArrayList<Payment> payments = new ArrayList<>();
        payments.add(new Payment(-2800, 0.02, LocalDate.now()));
        for (int i = 1; i <= 5; i++) {
            payments.add(new Payment(594, 0.02, LocalDate.now().plusYears(i)));
        }
        assertEquals(0.02, PaymentUtils.getEffectiveRate(payments, LocalDate.now()), EPSILON / 100);
    }
}