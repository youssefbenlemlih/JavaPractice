package A02.src.main.de.hawhamburg.krukenberg_benlemlih;

public class ComplexMath {
    private  ComplexMath(){};

    public static CartesianCoordinate ComplexToCartesianCoordinates(Complex complex) {
        return new CartesianCoordinate(complex.getReal(), complex.getImaginary());
    }

    public static Complex CartesianCoordinateToComplex(CartesianCoordinate coordinate) {
        return new Complex(coordinate.getX(), coordinate.getY());
    }
    public static PolarCoordinate ComplexToPolarCoordinate(Complex complex) {
        double real = complex.getReal();
        double imaginary = complex.getImaginary();
        double angle = Math.atan2(imaginary, real);
        double abs = Math.sqrt(real * real + imaginary * imaginary);
        return new PolarCoordinate(angle,abs);
    }

    public static Complex PolarCoordinateToComplex(PolarCoordinate coordinate) {
        double phi = coordinate.getAngle();
        double abs = coordinate.getAbsolute();
        return new Complex(abs*Math.cos(phi), abs*Math.sin(phi));
    }

    public static CartesianCoordinate PolarToCartesian(PolarCoordinate coordinate) {
        double abs = coordinate.getAbsolute();
        double angle = coordinate.getAngle();
        double x = abs*Math.cos(angle);
        double y = abs*Math.sin(angle);
        return new CartesianCoordinate(x,y);
    }
    public static PolarCoordinate CartesianToPolar(CartesianCoordinate coordinate){
        double x = coordinate.getX(), y = coordinate.getY();
       double angle = Math.atan2(y,x);
       double abs  = Math.sqrt(x*x+y*y);
       return new PolarCoordinate(angle,abs);
    }
}
