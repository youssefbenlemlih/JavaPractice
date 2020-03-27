package src.main.de.hawhamburg.krukenberg_benlemlih.A02;

import java.util.Objects;

public class CoordinateCartesian {

    private double re;
    private double im;

    public CoordinateCartesian(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public String toString() {
        return "CartesianCoordinate{" +
                "re=" + re +
                ", im=" + im +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoordinateCartesian)) return false;
        CoordinateCartesian that = (CoordinateCartesian) o;
        return ComplexMath.equalDoubles(that.getRe(), getRe()) &&
                ComplexMath.equalDoubles(that.getIm(), getIm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRe(), getIm());
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }
}
