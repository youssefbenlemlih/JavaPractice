package src.main.de.hawhamburg.krukenberg_benlemlih.A01;

/**
 * Starts application for credit calculations
 *
 * @author Jonas Krukenberg
 * @author Youssef Benlemlih
 */
public class Application {
    public static void main(String[] args) {
        Credit credit = new Credit(10000, 3.88, 84);
        System.out.println(credit);
    }
}
