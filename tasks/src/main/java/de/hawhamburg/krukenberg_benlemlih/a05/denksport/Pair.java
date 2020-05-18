package de.hawhamburg.krukenberg_benlemlih.a05.denksport;

import java.util.Arrays;
import java.util.List;

public class Pair<T> {
    private final T first;
    private final T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T first() {
        return first;
    }

    public T second() {
        return second;
    }

    public List<String> stringList() {
        return Arrays.asList(String.valueOf(first), String.valueOf(second));
    }

    public static void main(String[] args) {
//        Pair p = new Pair<Object>(23, "skidoo");
        Pair<Object> p = new Pair<Object>(23, "skidoo");
        for (String s : p.stringList()) {
            System.out.print(s + " ");
        }
    }
}