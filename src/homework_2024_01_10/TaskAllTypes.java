package homework_2024_01_10;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskAllTypes {
//    21. Задача: Найти количество уникальных элементов в списке.
//    Сигнатура: <T> long countUnique(List<T> input);
//
//    22. Задача: Определить, является ли список отсортированным.
//    Сигнатура: <T extends Comparable<T>> boolean isSorted(List<T> input);
//
//    23. Задача: Получить последний элемент списка, если он существует.
//    Сигнатура: <T> Optional<T> getLastElement(List<T> input);
//
//    24. Задача: Перемешать элементы списка.
//    Сигнатура: <T> List<T> shuffleList(List<T> input);
//
//    25. Задача: Подсчитать частоту каждого элемента в списке.
//    Сигнатура: <T> Map<T, Long> countFrequency(List<T> input);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("a", "b", "b", "c", "d", "d"));
//        System.out.println(isSorted(list));
//        getLastElement(list).ifPresentOrElse(System.out::println, () -> System.out.println("null"));
//        System.out.println(shuffleList(list));

        for (Map.Entry<String, Long> entry : countFrequency(list).entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static <T> long countUnique(List<T> input) {
        return input.stream().distinct().count();
    }

    public static <T extends Comparable<T>> boolean isSorted(List<T> input) {
        return IntStream.range(0, input.size() - 1)
                .noneMatch(i -> input.get(i).compareTo(input.get(i + 1)) > 0);
    }

    public static <T> Optional<T> getLastElement(List<T> input) {
        return input.stream().reduce((first, second) -> second);
    }

    public static <T> List<T> shuffleList(List<T> input) {
        return input.stream().collect(Collectors.collectingAndThen(Collectors.toList(),
                list -> {
                    Collections.shuffle(list);
                    return list;
                }));
    }

    public static <T> Map<T, Long> countFrequency(List<T> input) {
        return input.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
    }
}
