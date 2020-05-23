package de.hawhamburg.krukenberg_benlemlih.a07.denksport;

public class Equiv {

    public static void main(String[] args) {
        System.out.println((int) (double) Math.PI == 3);         // x == y
        System.out.println(3 == (int) (float) Math.PI);          // y == z
        System.out.println((double) Math.PI == (float) Math.PI); // x == z
    }
}
