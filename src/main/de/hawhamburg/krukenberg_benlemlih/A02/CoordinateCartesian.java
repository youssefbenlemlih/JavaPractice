package src.main.de.hawhamburg.krukenberg_benlemlih.A02;

import java.util.Objects;

public class CoordinateCartesian implements Cartesian{
    private double x;

    public CoordinateCartesian(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "CartesianCoordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoordinateCartesian)) return false;
        CoordinateCartesian that = (CoordinateCartesian) o;
        return ComplexMath.equalDoubles(that.getX(), getX()) &&
                ComplexMath.equalDoubles(that.getY(), getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    private double y;
}
