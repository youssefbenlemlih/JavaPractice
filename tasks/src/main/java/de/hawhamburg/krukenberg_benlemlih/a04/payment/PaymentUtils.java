package de.hawhamburg.krukenberg_benlemlih.a04.payment;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A utility class for calculating with Collections of {@link Payment} instances
 *
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
public class PaymentUtils {

    /**
     * @return effective rate for a list of {@link Payment}s making use of {@link FunctionUtils}.getZeroPoint(x)
     */
    public static double getEffectiveRate(ArrayList<Payment> payments, LocalDate now) {
        return FunctionUtils.getZeroPoint(
                (x) -> getCashValueOfAllPayments(payments, now, x), 0, 1, Payment.EPSILON
        );
    }

    /**
     * @return cash value of all payments for specified LocalDate now with the given rate of each {@link Payment}
     * instance
     */
    public static double getCashValueOfAllPayments(ArrayList<Payment> payments, LocalDate now) {
        return getCashValueOfAllPayments(payments, now, null);
    }

    /**
     * @param effectiveRate a constant rate to calculate with. Otherwise if null, the rate of each {@link Payment}
     *                      instance is used
     * @return cash value of all payments for specified LocalDate now with the given rate
     */
    private static double getCashValueOfAllPayments(ArrayList<Payment> payments, LocalDate now, Double effectiveRate) {
        double amount = 0;
        double rate;
        for (Payment payment : payments) {
            rate = (effectiveRate == null) ? payment.getRate() : effectiveRate;
            amount += payment.getCashValueOfFuturePaymentWithRate(rate, now);
        }
        return amount;
    }
}
