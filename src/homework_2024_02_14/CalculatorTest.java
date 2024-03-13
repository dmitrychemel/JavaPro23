package homework_2024_02_14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static final Calculator CALCULATOR = new Calculator();
    @Test
    void addTest() {
        Assertions.assertEquals(5, CALCULATOR.add(3, 2));
        Assertions.assertEquals(-5, CALCULATOR.add(-7, 2));
    }

    @Test
    void subtractTest() {
        Assertions.assertEquals(5, CALCULATOR.subtract(7, 2));
        Assertions.assertEquals(-9, CALCULATOR.subtract(-7, 2));
    }

    @Test
    void multiplyTest() {
        Assertions.assertEquals(2, CALCULATOR.multiply(1, 2));
        Assertions.assertEquals(-14, CALCULATOR.multiply(-7, 2));
        Assertions.assertEquals(0, CALCULATOR.multiply(0, 2));
    }

    @Test
    void dividePositiveTest() {
        Assertions.assertEquals(2.5, CALCULATOR.divide(5, 2));
        Assertions.assertEquals(-5, CALCULATOR.divide(-10, 2));
    }

    @Test
    void divideWithArithmeticExceptionTest() {
        Assertions.assertThrows(ArithmeticException.class,() -> CALCULATOR.divide(5, 0));
    }

    @Test
    void powerTest() {
        Assertions.assertEquals(1, CALCULATOR.power(10, 0));
        Assertions.assertEquals(4, CALCULATOR.power(2, 2));
        Assertions.assertEquals(0.5, CALCULATOR.power(2, -1));
    }

    @Test
    void factorialTest() {
        Assertions.assertEquals(2, CALCULATOR.factorial(2));
        Assertions.assertEquals(1, CALCULATOR.factorial(0));
    }

    @Test
    void factorialWithArithmeticExceptionTest() {
        Assertions.assertThrows(ArithmeticException.class,() -> CALCULATOR.factorial(-1));
    }

    @Test
    void absoluteTest() {
        Assertions.assertEquals(2, CALCULATOR.absolute(2));
        Assertions.assertEquals(2, CALCULATOR.absolute(-2));
    }

    @Test
    void sqrtPositiveTest() {
        Assertions.assertEquals(2, CALCULATOR.sqrt(4));
        Assertions.assertEquals(0, CALCULATOR.sqrt(0));
    }

    @Test
    void sqrtWithArithmeticExceptionTest() {
        Assertions.assertThrows(ArithmeticException.class,() -> CALCULATOR.sqrt(-1));
    }

    @Test
    void logarithmTest() {
        Assertions.assertEquals(3, CALCULATOR.logarithm(2,8), 0.00001);
    }

    @Test
    void logarithmWithArithmeticExceptionTest() {
        Assertions.assertThrows(ArithmeticException.class,() -> CALCULATOR.logarithm(0, 10));
        Assertions.assertThrows(ArithmeticException.class,() -> CALCULATOR.logarithm(10, 0));
    }

    @Test
    void sinTest() {
        Assertions.assertEquals(Math.sin(0), CALCULATOR.sin(0), 0.00001);
        Assertions.assertEquals(Math.sin(30), CALCULATOR.sin(30), 0.01);
//        Assertions.assertEquals(Math.sin(-60), CALCULATOR.sin(-60), 0.00001);
    }
}