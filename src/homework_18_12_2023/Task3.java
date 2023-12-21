package homework_18_12_2023;

import java.util.Optional;

public class Task3 {
//    Создайте функциональный интерфейс SafeDivision с методом divide, который безопасно делит два числа и возвращает Optional<Double>.
//    Реализуйте метод, который делит два числа с использованием SafeDivision, обрабатывая случай деления на ноль.

    public static void main(String[] args) {
        System.out.println(optional(10, 1, (a, b) -> b == 0 ? Optional.empty() : Optional.of(a / b)));
    }

    public static <T> Optional<T> optional(int first, int second, SafeDivision<T> safeDivision) {
        return safeDivision.divide(first, second);
    }
}

@FunctionalInterface
interface SafeDivision<T> {
    Optional<T> divide(int first, int second);
}
