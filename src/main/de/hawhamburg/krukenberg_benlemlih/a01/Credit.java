package main.de.hawhamburg.krukenberg_benlemlih.a01;

/**
 * Credit class representing a bank credit
 *
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
public class Credit {

    public static final double RATE_ACCURACY = 0.000001;

    public double baseAmount;
    /**
     * interestRate in decimals. 3% => interestRate = 0.03
     */
    public double interestRate;
    public int durationInMonths;
    public double ratePerMonth;

    /**
     * @param baseAmount       total credit amount in Euros
     * @param interestRate     in percent
     * @param durationInMonths duration of credit payment in months
     */
    public Credit(double baseAmount, double interestRate, int durationInMonths) {
        this.baseAmount = baseAmount;
        this.interestRate = interestRate / 100;
        this.durationInMonths = durationInMonths;
        this.ratePerMonth = getRatePerMonth();
    }

    /**
     * this is the main calculation for the task
     *
     * @return annual percentage Rate (Jaehrlicher Effektivzins)
     */
    public double getAnnualPercentageRate() {

        double p1 = 0, p2 = 0; // percentage / 100

        while (f(p2) < 0) {
            p1 = p2;
            p2 += 0.005;
        }

        double pMiddle;
        do {
            pMiddle = (p1 + p2) / 2;
            if (f(pMiddle) > 0) {
                p2 = pMiddle;
            } else {
                p1 = pMiddle;
            }
        } while (Math.abs(f(p2) - f(p1)) > RATE_ACCURACY);

        return Math.round(((p1 + p2) / 2) * 10000) / 10000.0;
    }

    /**
     * because there are more different formulas for calculation we setup this one to compare both in test cases
     * if we find a working method, there will be no need of a second one
     *
     * @return annual percentage Rate (Jaehrlicher Effektivzins)
     */
    public double getAnnualPercentageRate2() {

        double p1 = 0, p2 = 0; // percentage / 100

        while (f2(p2) < 0) {
            System.out.println(f2(p2));
            p1 = p2;
            p2 += 0.005;
        }

        double pMiddle;
        do {
            pMiddle = (p1 + p2) / 2;
            if (f2(pMiddle) > 0) {
                p2 = pMiddle;
            } else {
                p1 = pMiddle;
            }
        } while (Math.abs(f2(p2) - f2(p1)) > RATE_ACCURACY);

        return Math.round(((p1 + p2) / 2) * 10000) / 10000.0;
    }

    @Override
    public String toString() {
        return "Credit information: \nBase amount: " + baseAmount + "\nInterest rate: " + interestRate +
                "\nDuration in months: " + durationInMonths + "\nRate per month: " + ratePerMonth +
                "\nAnnual percentage rate: " + getAnnualPercentageRate();
    }

    /**
     * @param p percentage / 100
     * @return f(p)
     * @link https://de.wikipedia.org/wiki/Effektiver_Jahreszins
     */
    private double f(double p) throws IllegalArgumentException {
        if (p < 0 || p > 1) {
            throw new IllegalArgumentException("p must be between 0 and 1 but is " + p);
        }

        return baseAmount * (1 + p) - ratePerMonth *
                (durationInMonths + (((durationInMonths - 1.0) * durationInMonths) / (2 * durationInMonths)) * p);
    }

    /**
     * alternate calculation for f(p)
     *
     * @param p percentage / 100
     * @return f(p)
     * @link https://www.gesetze-im-internet.de/pangv/anlage.html
     */
    private double f2(double p) throws IllegalArgumentException {
        if (p < 0 || p > 1) {
            throw new IllegalArgumentException("p must be between 0 and 1 but is " + p);
        }

//
        double leftSum = 0;
        for (int k = 1; k <= durationInMonths; k++) {
            leftSum += baseAmount * Math.pow(1 + p * 100, -(k - 1) / 12.0);
        }

        double rightSum = 0;
        for (int l = 1; l < durationInMonths; l++) {
            rightSum += ratePerMonth * Math.pow(1 + p * 100, -(l - 1) / 12.0);
        }

        return leftSum - rightSum;
    }

    /**
     * source of formula: https://www.finanzen-rechner.net/kredit/monatsrate-berechnen.html
     *
     * @return rate to pay per month
     */
    private double getRatePerMonth() {
        double exactRate = baseAmount * (interestRate / 12) / (1 - Math.pow(1 + interestRate / 12, -durationInMonths));
        return Math.ceil(exactRate * 100) / 100;
    }
}
