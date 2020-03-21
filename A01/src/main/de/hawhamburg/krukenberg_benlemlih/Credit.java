package main.de.hawhamburg.krukenberg_benlemlih;

public class Credit {

    public static final double RATE_ACCURACY = 0.0001;

    public double baseAmount;
    /**
     * interestRate in decimals. 3% => interestRate = 0.03
     */
    public double interestRate;
    public int durationInMonths;

    private double ratePerMonth;

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
     * @return annual percentage Rate (Jaehrlicher Effektivzins)
     */
    public double getAnnualPercentageRate() {

        double p2 = 0; // %
        double p1 = 0;

        while (f(p2) > 0) {
            p2 += 0.5; // %
        }
//        Interval found!
        double pMiddle;
        do {
            pMiddle = (p1 + p2) / 2;
            if (f(pMiddle) < 0) {
                p2 = pMiddle;
            } else {
                p1 = pMiddle;
            }
        } while (Math.abs(f(p2)) - Math.abs(f(p1)) > RATE_ACCURACY);

        return p2 / 100;
    }

    /**
     * @param p percentage / 100
     * @return f(p)
     */
    private double f(double p) throws IllegalArgumentException {
        p = p / 100;
        if (p < 0 || p > 1) {
            throw new IllegalArgumentException("p must be between 0 and 1 but is " + p);
        }

        return (1 + p) * baseAmount - sigma(p) * ratePerMonth;
    }

    private double sigma(double p) {
        double sum = 0;
        for (int j = 0; j <= durationInMonths / 12 - 1; j++) {
            sum += Math.pow(1 + p, j);
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Credit information: \nBase amount: " + baseAmount + "\nInterest rate: " + interestRate +
                "\nDuration in months: " + durationInMonths + "\nRate per month: " + ratePerMonth +
                "\nAnnual percentage rate: " + getAnnualPercentageRate();
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
