package de.hawhamburg.krukenberg_benlemlih.a07.denksport;

class Base {
    private String className = "Base";

    public Base() {
    }

    Base(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}

class Derived extends Base {

    public Derived() {
        super("Derived");
    }
}

public class PrivateMatter {
    public static void main(String[] args) {
        System.out.println(new Derived().getClassName());
        System.out.println(new Base().getClassName());
    }
}
