package src.main.de.hawhamburg.krukenberg_benlemlih.A02;

import java.util.Objects;

public class Complex {

    protected double real;
    protected double imaginary;

    public Complex(Complex other) {
        this.real = other.getReal();
        this.imaginary = other.getImaginary();
    }

    public Complex(Number real) {
        setReal(real);
        this.imaginary = 0;
    }

    public Complex(Number real, Number imaginary) {
        setReal(real);
        setImaginary(imaginary);
    }

    public Complex(CoordinateCartesian coordinateCartesian) {
        Complex complex = ComplexMath.CartesianCoordinateToComplex(coordinateCartesian);
        this.real = complex.getReal();
        this.imaginary = complex.getImaginary();
    }

    public Complex(CoordinatePolar coordinatePolar) {
        Complex complex = ComplexMath.PolarCoordinateToComplex(coordinatePolar);
        this.real = complex.getReal();
        this.imaginary = complex.getImaginary();
    }

    public void add(Complex other) {
        this.real += other.getReal();
        this.imaginary += other.getImaginary();
    }

    public void add(Number num) {
        this.real += Double.parseDouble(num.toString());
    }

    public void subtract(Complex other) {
        this.real -= other.getReal();
        this.imaginary -= other.getImaginary();
    }

    public void subtract(Number num) {
        this.real -= Double.parseDouble(num.toString());
    }

    public void multiply(Complex other) {
// TODO
    }

    public void multiply(Number num) {
        double factor = Double.parseDouble(num.toString());
        this.real *= (double) factor;
        this.imaginary *= (double) factor;
    }

    public void divide(Complex other) {
// TODO
    }

    public void divide(Number divisor) {
        multiply(1 / Double.parseDouble(divisor.toString()));
    }

    public double getReal() {
        return real; // FIXME: Kapselung?
    }

    public void setReal(Number real) {
        this.real = Double.parseDouble(real.toString());
    }

    public void setImaginary(Number imaginary) {
        this.imaginary = Double.parseDouble(imaginary.toString());
    }

    public double getImaginary() {
        return imaginary; // FIXME: Kapselung?
    }

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
        return real + ((Math.signum(imaginary) >= 0) ? "+" : "") + imaginary + "i";
    }
}
