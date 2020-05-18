package de.hawhamburg.krukenberg_benlemlih.a06.denksport;

import java.util.Random;

public class RandomNumbers {
    static Random rand = new Random();

    static int random(int n) {
        return Math.abs(rand.nextInt(n));
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (random(n) < n / 2) {
                low++;
            }
        }
        System.out.println(low);
    }
}
