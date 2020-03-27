package src.main.de.hawhamburg.krukenberg_benlemlih.A02;

import java.util.Objects;

public class CoordinatePolar implements Polar {
    private double absolute;
    private double angle;

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAbsolute() {
        return absolute;
    }

    public void setAbsolute(double absolute) {
        this.absolute = absolute;
    }

    public CoordinatePolar(double angle, double absolute) {
        this.angle = angle;
        this.absolute = absolute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoordinatePolar)) return false;
        CoordinatePolar that = (CoordinatePolar) o;
        return ComplexMath.equalDoubles(that.getAngle(), getAngle()) &&
                ComplexMath.equalDoubles(that.getAbsolute(), getAbsolute());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAngle(), getAbsolute());
    }
}
