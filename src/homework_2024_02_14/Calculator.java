package homework_2024_02_14;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(double a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }

        return a / b;
    }

    public double power(double num, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            return num * power(num, exponent - 1);
        } else if (exponent < 0) {
            return 1 / num * power(num, exponent + 1);
        }
        return num;
    }

    public int factorial(int num) {
        if (num < 0) {
            throw new ArithmeticException();
        } else if (num == 0) {
            return 1;
        }

        return num * factorial(num - 1);
    }

    public double absolute(double num) {
        if (num < 0) {
            return num * -1;
        } else {
            return num;
        }
    }

    public double sqrt(double num) {
        if (num < 0) {
            throw new ArithmeticException();
        } else if (num == 0) {
            return 0;
        }
        double guess = num / 2.0;

        while (true) {
            double newGuess = 0.5 * (guess + num / guess);
            if (closeEnough(guess, newGuess)) {
                break;
            }
            guess = newGuess;
        }

        return guess;


    }

    private boolean closeEnough(double guess, double newGuess) {
        double epsilon = 0.0001;
        return absolute(guess - newGuess) < epsilon;
    }

    public double logarithm(double base, double number) {
        if (base <= 0 || base == 1 || number <= 0) {
            throw new ArithmeticException();
        }

        double result = 0;

        result = logarithmBaseE(number) / logarithmBaseE(base);

        return result;
    }

    private double logarithmBaseE(double number) {
        double result = 0;

        if (number <= 0) {
            throw new ArithmeticException();
        }

        double x = (number - 1) / (number + 1);
        double term = x;
        for (int i = 1; i <= 1000; i += 2) {
            result += term / i;
            term *= x * x;
        }
        result *= 2;

        return result;
    }

    public double sin(double angle) {

        while (angle > Math.PI) {
            angle -= 2 * Math.PI;
        }
        while (angle < -Math.PI) {
            angle += 2 * Math.PI;
        }

        double result = 0;
        for (int n = 0; n < 10; n++) {
            result += Math.pow(-1, n) * Math.pow(angle, 2 * n + 1) / factorial(2 * n + 1);
        }

        return result;

    }
}

