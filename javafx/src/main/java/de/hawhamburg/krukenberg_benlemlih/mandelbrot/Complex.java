/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package de.hawhamburg.krukenberg_benlemlih.mandelbrot;


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

    public Complex plus(Complex other) {
        return add(other);
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

    public Complex times(Complex other) {
        return multiply(other);
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

    public double lengthSQ() {
        return ComplexMath.square(this);
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