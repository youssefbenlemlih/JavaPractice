package main.de.hawhamburg.krukenberg_benlemlih.a02;

import java.util.Objects;

/**
 * This class represents a mutable <b>complex number</b>
 * source to arithmetic rules with complex numbers: http://sites.science.oregonstate.edu/~warrenw/COURSES/ph461/H1.pdf
 *
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
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
        Complex complex = ComplexMath.cartesianCoordinateToComplex(coordinateCartesian);
        this.real = complex.getReal();
        this.imaginary = complex.getImaginary();
    }

    public Complex(CoordinatePolar coordinatePolar) {
        Complex complex = ComplexMath.polarCoordinateToComplex(coordinatePolar);
        this.real = complex.getReal();
        this.imaginary = complex.getImaginary();
    }

    public Complex add(Complex other) {
        this.real += other.getReal();
        this.imaginary += other.getImaginary();
        return this;
    }

    public Complex add(Number num) {
        this.real += Double.parseDouble(num.toString());
        return this;
    }

    public Complex subtract(Complex other) {
        this.real -= other.getReal();
        this.imaginary -= other.getImaginary();
        return this;
    }

    public Complex subtract(Number num) {
        this.real -= Double.parseDouble(num.toString());
        return this;
    }

    public Complex multiply(Complex other) {
        double productRe = real * other.real - imaginary * other.imaginary;
        imaginary = real * other.imaginary + other.real * imaginary;
        real = productRe;
        return this;
    }

    public Complex multiply(Number num) {
        double factor = Double.parseDouble(num.toString());
        this.real *= factor;
        this.imaginary *= factor;
        return this;
    }

    public Complex divide(Complex other) {
        multiply(other);
        return divide(Math.pow(other.real, 2) + Math.pow(other.imaginary, 2));
    }

    public Complex divide(Number divisor) {
        multiply(1 / Double.parseDouble(divisor.toString()));
        return this;
    }

    public double getReal() {
        return real;
    }

    public void setReal(Number real) {
        this.real = Double.parseDouble(real.toString());
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(Number imaginary) {
        this.imaginary = Double.parseDouble(imaginary.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Complex)) {
            return false;
        }
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
        if (real == 0 && imaginary == 0) {
            return "0";
        }
        String re = (real == 0.0) ? "" : real + "";
        String im = (imaginary == 0) ? "" : imaginary + "i";
        return re + ((imaginary > 0) ? "+" : "") + im;
    }
}
