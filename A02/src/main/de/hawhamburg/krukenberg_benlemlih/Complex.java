package A02.src.main.de.hawhamburg.krukenberg_benlemlih;

import java.util.Objects;

public class Complex {
    public static Complex Zero(){
        return new Complex(0,0);
    }

    public static Complex FromPolar(double abs, double phi){
       return new Complex(abs*Math.cos(phi),
                                abs*Math.sin(phi));
    }

    public void setAngle(double angle){
        Complex fromPolar = FromPolar(getAbs(),angle);
        setReal(fromPolar.getReal());
        setImaginary(fromPolar.getImaginary());
    }
    public void setAbs(double abs){
        multiply(abs/getAbs());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complex)) return false;
        Complex complex = (Complex) o;
        return compareDoubles(complex.getReal(), getReal()) &&
               compareDoubles(complex.getImaginary(), getImaginary());
    }

    private boolean compareDoubles(double d1,double d2){
        return Math.abs(d1-d2)<= 0.00001;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getReal(), getImaginary());
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }

    public double getAngle(){
        return Math.atan2(imaginary,real);
    }

    public double getAbs(){
        return Math.sqrt(real*real+imaginary*imaginary);
    }
    public Complex(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add(Complex other)
    {
        this.real += other.getReal();
        this.imaginary += other.getImaginary();
    }

    public void substract(Complex other)
    {
        this.real -= other.getReal();
        this.imaginary -= other.getImaginary();
    }

    public void multiply(double factor)
    {
        this.real *= factor;
        this.imaginary *= factor;
    }

    public void divide(double factor)
    {
        this.real /= factor;
        this.imaginary /= factor;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

   public double real;
   public double imaginary;
}
