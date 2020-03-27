package src.main.de.hawhamburg.krukenberg_benlemlih.A02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Tests for Complex Class
 *
 * @link https://keisan.casio.com/exec/system/1223527679 source for comparing values
 */
class ComplexTest {

    private static Complex complex;
    private static Complex complexOperand;
    private static CoordinateCartesian coordinateCartesian;
    private static CoordinatePolar coordinatePolar;

    @BeforeEach
    void setUp() {
        complex = new Complex(2.3, 4.5);
        complexOperand = new Complex(-2, -3);
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
// TODO
    }

    @Test
    void testToString() {
        assertEquals("0.0+0.0i", new Complex(0).toString());
        assertEquals("2.3+4.5i", complex.toString());
        assertEquals("-2.0-3.0i", complexOperand.toString());
    }

    @Test
    void testPolarComplexConversion() {
        assertEquals(complex, ComplexMath.PolarCoordinateToComplex(coordinatePolar));
        assertEquals(coordinatePolar, ComplexMath.ComplexToPolarCoordinate(complex));
    }

    @Test
    void testCartesianComplexConversion() {
        assertEquals(complex, ComplexMath.CartesianCoordinateToComplex(coordinateCartesian));
        assertEquals(coordinateCartesian, ComplexMath.ComplexToCartesianCoordinates(complex));
    }

    @Test
    void testCartesianPolarConversion() {
        assertEquals(coordinatePolar, ComplexMath.CartesianToPolar(coordinateCartesian));
        assertEquals(coordinateCartesian, ComplexMath.PolarToCartesian(coordinatePolar));
    }

    @Test
    void testComplexAddition() {
        complex.add(complexOperand);
        assertEquals(new Complex(0.2999999, 1.5), complex);
    }

    @Test
    void testNumberAddition() {
        complex.add(2);
        assertEquals(new Complex(4.3, 4.5), complex);
    }

    @Test
    void testComplexSubtraction() {
        complex.subtract(complexOperand);
        assertEquals(new Complex(4.3, 7.5), complex);
    }

    @Test
    void testNumberSubtraction() {
        complex.subtract(2);
        assertEquals(new Complex(0.3, 4.5), complex);
    }

    @Test
    void testComplexMultiplication() {
        complex.multiply(complexOperand);
        assertEquals(new Complex(0, 0), complex); // TODO: expected value to be estimated
    }

    @Test
    void testNumberMultiplication() {
        complex.multiply(2);
        assertEquals(new Complex(4.6, 9), complex);
    }

    @Test
    void testComplexDivision() {
        complex.divide(complexOperand);
        assertEquals(new Complex(0, 0), complex); // TODO: expected value to be estimated
    }

    @Test
    void testNumberDivision() {
        complex.divide(2);
        assertEquals(new Complex(1.15, 2.25), complex);
    }
}