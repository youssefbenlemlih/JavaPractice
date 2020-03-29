package src.main.de.hawhamburg.krukenberg_benlemlih.A02;

/**
 * Utility class for...
 * <ul>
 *     <li>conversions between complex numbers, cartesian coordinates, polar coordinates</li>
 *     <li>equality for doubles with an epsilon</li>
 * </ul>
 * source of calculations:
 * https://www.ingenieurkurse.de/hoehere-mathematik-analysis-lineare-algebra/komplexe-zahlen/komplexe-zahlen-und
 * -polarkoordinaten.html
 *
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
public final class ComplexMath {

    private ComplexMath() {}

    public static CoordinateCartesian complexToCartesianCoordinate(Complex complex) {
        return new CoordinateCartesian(complex.getReal(), complex.getImaginary());
    }

    public static Complex cartesianCoordinateToComplex(CoordinateCartesian coordinate) {
        return new Complex(coordinate.getReal(), coordinate.getImaginary());
    }

    public static CoordinatePolar complexToPolarCoordinate(Complex complex) {
        double real = complex.getReal();
        double imaginary = complex.getImaginary();
        double angle = Math.toDegrees(Math.atan2(imaginary, real));
        double abs = Math.sqrt(real * real + imaginary * imaginary);
        return new CoordinatePolar(angle, abs);
    }

    public static Complex polarCoordinateToComplex(CoordinatePolar coordinate) {
        double phi = Math.toRadians(coordinate.getAngle());
        double abs = coordinate.getAbsolute();
        return new Complex(abs * Math.cos(phi), abs * Math.sin(phi));
    }

    /**
     * Perform transitive conversion: polar -> complex -> cartesian
     */
    public static CoordinateCartesian polarToCartesian(CoordinatePolar coordinate) {
        Complex complex = polarCoordinateToComplex(coordinate);
        return complexToCartesianCoordinate(complex);
    }

    /**
     * Perform transitive conversion: cartesian -> complex -> polar
     */
    public static CoordinatePolar cartesianToPolar(CoordinateCartesian coordinate) {
        Complex complex = cartesianCoordinateToComplex(coordinate);
        return complexToPolarCoordinate(complex);
    }

    public static boolean equalDoubles(double d1, double d2) {
        return Math.abs(d1 - d2) <= 0.00001;
    }
}
