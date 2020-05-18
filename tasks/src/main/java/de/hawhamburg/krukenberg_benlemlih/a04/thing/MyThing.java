package de.hawhamburg.krukenberg_benlemlih.a04.thing;

import java.util.function.IntSupplier;

/**
 * A subclass of {@link Thing}, its main method initializes a {@link Thing} with a random param value
 *
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
public class MyThing extends Thing {

    /**
     * we need a supplier Interface with an Integer type because we cannot call directly lambdas with Integer/int
     * because they don't implement a functional Interface.
     */
    private static final IntSupplier something = ()-> (int) System.currentTimeMillis();

    private final int initParam;

    public MyThing() {
        this(something.getAsInt());
    }

    private MyThing(int i) {
        super(i);
        initParam = i;
    }

    public int getParameter() {
        return initParam;
    }

    public static void main(String[] args)  {
        MyThing myThing = new MyThing();
        System.out.println("Thing1 has been initiated with i=" + myThing.getParameter());
        System.out.println("Thing1 has been initiated with i=" + myThing.getParameter());
        System.out.println("Thing2 has been initiated with i=" + new MyThing().getParameter());
    }
}