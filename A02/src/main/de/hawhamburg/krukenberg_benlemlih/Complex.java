package A02.src.main.de.hawhamburg.krukenberg_benlemlih;

import java.util.Objects;

public class Complex {
    public static Complex Zero() {
        return new Complex(0, 0);
    }

    public Complex(Complex other) {
        this.real = other.getReal();
        this.imaginary = other.getImaginary();
    }

    public Complex(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add(Complex other) {
        this.real += other.getReal();
        this.imaginary += other.getImaginary();
    }

    public void substract(Complex other) {
        this.real -= other.getReal();
        this.imaginary -= other.getImaginary();
    }

    public void multiply(double factor) {
        this.real *= factor;
        this.imaginary *= factor;
    }

    public void divide(double factor) {
        multiply(1/factor);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double real;
    public double imaginary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complex)) return false;
        Complex complex = (Complex) o;
        return ComplexMath.equalDoubles(complex.getReal(), getReal()) &&
                ComplexMath.equalDoubles(complex.getImaginary(), getImaginary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReal(), getImaginary());
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }
}
