package homework_2024_01_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskFloats {
//    16. Задача: Найти минимальное число в списке.
//    Сигнатура: Optional<Float> findMin(List<Float> input);
//
//    17. Задача: Получить список чисел, умноженных на заданное число.
//    Сигнатура: List<Float> multiplyBy(List<Float> input, float multiplier);
//
//    18. Задача: Отфильтровать числа, меньшие заданного значения.
//    Сигнатура: List<Float> filterLessThan(List<Float> input, float value);
//
//    19. Задача: Проверить, содержит ли список отрицательные числа.
//    Сигнатура: boolean containsNegative(List<Float> input);
//
//    20. Задача: Округление всех чисел в списке до ближайшего целого.
//    Сигнатура: List<Integer> roundNumbers(List<Float> input);
    public static void main(String[] args) {
        List<Float> floats = new ArrayList<>(List.of(3.12f, 23.8f, 1.91f, -1.4f));
//        System.out.println(containsNegative(floats));
        System.out.println(roundNumbers(floats));
    }

    private static Optional<Float> findMin(List<Float> input) {
        return input.stream().reduce(Float::min);
    }

    private static List<Float> multiplyBy(List<Float> input, float multiplier) {
        return input.stream().map(e -> e * multiplier).toList();
    }

    private static List<Float> filterLessThan(List<Float> input, float value) {
        return input.stream().filter(e -> e < value).toList();
    }

    private static boolean containsNegative(List<Float> input) {
        return input.stream().anyMatch(e -> e < 0f);
    }

    private static List<Integer> roundNumbers(List<Float> input) {
        return input.stream().map(Math::round).toList();
    }
}
