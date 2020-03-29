package src.main.de.hawhamburg.krukenberg_benlemlih.A02.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

/**
 * Tests for Complex Class
 *
 * @author Youssef Benlemlih
 * @author Jonas Krukenberg
 */
class ComplexTest {

    private static Complex complex;
    private static Complex complexOther;
    private static CoordinateCartesian coordinateCartesian;
    private static CoordinatePolar coordinatePolar;

    @BeforeEach
    void setUp() {
        complex = new Complex(2.3, 4.5);
        complexOther = new Complex(-2, -3);
        coordinateCartesian = new CoordinateCartesian(2.3, 4.5);
        coordinatePolar = new CoordinatePolar(62.927919762007, 5.0537115073973);
    }

    @Test
    void testEquality() {
        assertNotEquals(complex, new Complex(2.3, -4.5));
        assertEquals(complex, new Complex(2.3, 4.5));
        assertEquals(new Complex(4), new Complex(4));
        assertEquals(complex, new Complex(complex));
        assertEquals(complex, new Complex(coordinateCartesian));
        assertEquals(complex, new Complex(coordinatePolar));
        assertEquals(coordinateCartesian, new CoordinateCartesian(2.3, 4.5));
        assertEquals(coordinatePolar, new CoordinatePolar(62.927919762007, 5.0537115073973));
    }

    @Test
    void testHashCode() {
        Set<IComplexContext> s = new HashSet<>();
        s.add(complex);
        s.add(new CoordinateCartesian(1,-2));
        s.add(new CoordinatePolar(30,8));
        assertTrue(s.contains(new Complex(2.3,4.5)));
        assertTrue(s.contains(new CoordinateCartesian(1,-2)));
        assertTrue(s.contains(new CoordinatePolar(30,8)));
    }

    @Test
    void testToString() {
        assertEquals("0.0+0.0i", new Complex(0).toString());
        assertEquals("2.3+4.5i", complex.toString());
        assertEquals("-2.0-3.0i", complexOther.toString());
    }

    @Test
    void testPolarComplexConversion() {
        assertEquals(complex, ComplexMath.polarCoordinateToComplex(coordinatePolar));
        assertEquals(coordinatePolar, ComplexMath.complexToPolarCoordinate(complex));
    }

    @Test
    void testCartesianComplexConversion() {
        assertEquals(complex, ComplexMath.cartesianCoordinateToComplex(coordinateCartesian));
        assertEquals(coordinateCartesian, ComplexMath.complexToCartesianCoordinate(complex));
    }

    @Test
    void testCartesianPolarConversion() {
        assertEquals(coordinatePolar, ComplexMath.cartesianToPolar(coordinateCartesian));
        assertEquals(coordinateCartesian, ComplexMath.polarToCartesian(coordinatePolar));
    }

    @Test
    void testComplexAddition() {
        complex.add(complexOther);
        assertEquals(new Complex(0.2999999, 1.5), complex);
    }

    @Test
    void testNumberAddition() {
        complex.add(2);
        assertEquals(new Complex(4.3, 4.5), complex);
    }

    @Test
    void testComplexSubtraction() {
        complex.subtract(complexOther);
        assertEquals(new Complex(4.3, 7.5), complex);
    }

    @Test
    void testNumberSubtraction() {
        complex.subtract(2);
        assertEquals(new Complex(0.3, 4.5), complex);
    }

    @Test
    void testComplexMultiplication() {
        complex.multiply(complexOther);
        assertEquals(new Complex(8.9, -15.9), complex);
    }

    @Test
    void testNumberMultiplication() {
        complex.multiply(2);
        assertEquals(new Complex(4.6, 9), complex);
    }

    @Test
    void testComplexDivision() {
        complex.divide(complexOther);
        assertEquals(new Complex(8.9 / 13, -15.9 / 13), complex); // TODO: expected value to be estimated
    }

    @Test
    void testNumberDivision() {
        complex.divide(2);
        assertEquals(new Complex(1.15, 2.25), complex);
    }
}