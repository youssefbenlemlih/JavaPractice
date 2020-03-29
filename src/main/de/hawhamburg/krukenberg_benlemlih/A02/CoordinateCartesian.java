package src.main.de.hawhamburg.krukenberg_benlemlih.A02;

import java.util.Objects;

public class CoordinateCartesian implements IComplexContext{

    private double real;
    private double imaginary;

    public CoordinateCartesian(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        return "CartesianCoordinate{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoordinateCartesian)) return false;
        CoordinateCartesian that = (CoordinateCartesian) o;
        return ComplexMath.equalDoubles(that.getReal(), getReal()) &&
                ComplexMath.equalDoubles(that.getImaginary(), getImaginary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReal(), getImaginary());
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
}
