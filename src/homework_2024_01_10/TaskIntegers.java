package homework_2024_01_10;

import java.util.List;
import java.util.Optional;

public class TaskIntegers {
//    6. Задача: Найти сумму всех чисел в списке.
//    Сигнатура: int sumOfList(List<Integer> input);
//
//    7. Задача: Получить список квадратов чисел.
//    Сигнатура: List<Integer> getSquares(List<Integer> input);
//
//    8. Задача: Фильтрация чисел, больших заданного значения.
//    Сигнатура: List<Integer> filterGreaterThan(List<Integer> input, int minValue);
//
//    9. Задача: Проверка, содержит ли список заданное число.
//    Сигнатура: boolean containsNumber(List<Integer> input, int number);
//
//    10. Задача: Найти максимальное число в списке.
//    Сигнатура: Optional<Integer> findMax(List<Integer> input);
    public static void main(String[] args) {
    }

    private static int sumOfList(List<Integer> input) {
        return input.stream().reduce(0,Integer::sum);
    }

//    private static List<Integer> getSquares(List<Integer> input) {
//        return
//    }
//
//    private static List<Integer> filterGreaterThan(List<Integer> input, int minValue) {
//
//    }
//
//    private static boolean containsNumber(List<Integer> input, int number) {
//
//    }
//
//    private static Optional<Integer> findMax(List<Integer> input) {
//
//    }
}
