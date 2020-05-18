package main.de.hawhamburg.krukenberg_benlemlih.a06.lambdas_streams;

public class StringUtils {
    public static boolean isPalindrom(String str) {
        return str.equals(reverse(str));
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse()
                .toString();
    }
}
