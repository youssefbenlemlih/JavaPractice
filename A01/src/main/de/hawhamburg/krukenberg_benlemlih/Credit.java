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
     * @param baseAmount total credit amount in Euros
     * @param interestRate in percent
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

        double p1 = 0;
        double p2 = 0;

        while (f(p1) > 0) {
            p1 += 0.5;
        }
//        Interval found!
        do {
            if (f(p2) > f(p1)) {
                p2 = (p1 + p2) / 2;
            } else {
                p1 = (p1 + p2) / 2;
            }
        } while (Math.abs(f(p1)) - Math.abs(f(p2)) > RATE_ACCURACY);

        return p1;
    }

    private double f(double p) {
        return (1 + p) * baseAmount - sigma(p) * ratePerMonth;
    }

    private double sigma(double p) {
        double sum = 0;
        for (int j = 0; j < durationInMonths / 12 - 1; j++) {
            sum += Math.pow(1 + p, j);
        }
        return sum;
    }

    public String toString() {
        return "Credit information: \nBase amount: " + baseAmount + "\nInterest rate: " + interestRate +
                "\nDuration in months: " + durationInMonths + "\nRate per month: " + ratePerMonth +
                "\nAnnual percentage rate: " + getAnnualPercentageRate();
    }

    /**
     * source of formula: https://www.finanzen-rechner.net/kredit/monatsrate-berechnen.html
     * @return rate to pay per month
     */
    private double getRatePerMonth() {
        double exactRate = baseAmount * (interestRate / 12) / (1 - Math.pow(1 + interestRate / 12, -durationInMonths));
        return Math.ceil(exactRate * 100) / 100;
    }
}
