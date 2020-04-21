package src.main.de.hawhamburg.krukenberg_benlemlih.a04.payment;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * A class representing a Payment
 *
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
public class Payment {

    public static final double EPSILON = 1E-3;

    private final double amount;
    private final double rate;
    private final LocalDate paydate;

    public Payment(double amount, double rate, LocalDate paydate) {
        this.amount = amount;
        this.rate = rate;
        this.paydate = paydate;
    }

    /**
     * @return cash value at the given <b>date</b>
     */
    public double getCashValueOfFuturePayment(LocalDate now) {
        return getCashValueOfFuturePaymentWithRate(rate, now);
    }

    /**
     * source to formula: <a href="https://de.wikipedia.org/wiki/Barwert">Wikipedia</a>
     *
     * @return cash value at the given <b>date</b>
     */
    double getCashValueOfFuturePaymentWithRate(double rate, LocalDate now) {
        return amount / Math.pow(1 + rate, Period.between(now, paydate).getYears());
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Payment{" + "amount=" + amount + ", rate=" + rate + ", paydate=" + paydate + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Payment payment = (Payment) o;
        return Double.compare(payment.amount, amount) == 0 && Double.compare(payment.rate, rate) == 0 &&
                Objects.equals(paydate, payment.paydate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, rate, paydate);
    }
}
