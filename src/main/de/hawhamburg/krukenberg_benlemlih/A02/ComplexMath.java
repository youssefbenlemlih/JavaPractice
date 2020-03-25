package src.main.de.hawhamburg.krukenberg_benlemlih.A02;

public class ComplexMath {
    private ComplexMath() {
    }

    public static CoordinateCartesian ComplexToCartesianCoordinates(Complex complex) {
        return new CoordinateCartesian(complex.getReal(), complex.getImaginary());
    }

    public static Complex CartesianCoordinateToComplex(CoordinateCartesian coordinate) {
        return new Complex(coordinate.getX(), coordinate.getY());
    }

    public static CoordinatePolar ComplexToPolarCoordinate(Complex complex) {
        double real = complex.getReal();
        double imaginary = complex.getImaginary();
        double angle = Math.atan2(imaginary, real);
        double abs = Math.sqrt(real * real + imaginary * imaginary);
        return new CoordinatePolar(angle, abs);
    }

    public static Complex PolarCoordinateToComplex(CoordinatePolar coordinate) {
        double phi = coordinate.getAngle();
        double abs = coordinate.getAbsolute();
        return new Complex(abs * Math.cos(phi), abs * Math.sin(phi));
    }

    public static CoordinateCartesian PolarToCartesian(CoordinatePolar coordinate) {
        double abs = coordinate.getAbsolute();
        double angle = coordinate.getAngle();
        double x = abs * Math.cos(angle);
        double y = abs * Math.sin(angle);
        return new CoordinateCartesian(x, y);
    }

    public static CoordinatePolar CartesianToPolar(CoordinateCartesian coordinate) {
        double x = coordinate.getX(), y = coordinate.getY();
        double angle = Math.atan2(y, x);
        double abs = Math.sqrt(x * x + y * y);
        return new CoordinatePolar(angle, abs);
    }

    public static boolean equalDoubles(double d1, double d2) {
        return Math.abs(d1 - d2) <= 0.00001;
    }
}
