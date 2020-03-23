package A02.src.main.de.hawhamburg.krukenberg_benlemlih;

public class PolarCoordinate {
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

    public PolarCoordinate(double angle, double absolute) {
        this.angle = angle;
        this.absolute = absolute;
    }

    private double absolute;
}
