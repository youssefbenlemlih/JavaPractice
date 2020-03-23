package A02.src.main.de.hawhamburg.krukenberg_benlemlih;

import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

    @org.junit.jupiter.api.Test
    void testEquality() {
        Complex c1 = new Complex(0,1);
        Complex c2 = new Complex(0,1);
        Complex c3 = new Complex(0,9);
        assertEquals(c1,c2);
        assertNotEquals(c1,c3);
    }

    @org.junit.jupiter.api.Test
    void testFromPolar() {
        assertEquals(new Complex(5,0),Complex.FromPolar(5,0));
        assertEquals(new Complex(-5,0),Complex.FromPolar(5,Math.PI));
        assertEquals(new Complex(0,5),Complex.FromPolar(5,Math.PI/2));

    }
    @org.junit.jupiter.api.Test
    void test() {
    }
}