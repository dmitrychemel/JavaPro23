package homework_2024_01_10;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskCharacters {
//    11. Задача: Преобразование списка символов в список строк.
//    Сигнатура: List<String> convertToStringList(List<Character> input);
//
//    12. Задача: Фильтрация символов по ASCII-значению.
//    Сигнатура: List<Character> filterByAsciiValue(List<Character> input, int ascii);
//
//    13. Задача: Проверка, все ли символы в списке заглавные.
//    Сигнатура: boolean areAllUpperCase(List<Character> input);
//
//    14. Задача: Найти первый повторяющийся символ.
//    Сигнатура: Optional<Character> findFirstDuplicate(List<Character> input);
//
//    15. Задача: Получить обратный список символов.
//    Сигнатура: List<Character> reverseList(List<Character> input);

    public static void main(String[] args) {
        List<Character> ch = new ArrayList<>(List.of('a', 'r', 'l', 'k', 'e', 'm'));
        System.out.println(ch);
        System.out.println(reverseList(ch));

    }

    private static List<String> convertToStringList(List<Character> input) {
        return input.stream().map(String::valueOf).toList();
    }

    private static List<Character> filterByAsciiValue(List<Character> input, int ascii) {
        return input.stream().filter(e -> e > ascii).toList();
    }

    private static boolean areAllUpperCase(List<Character> input) {
        return input.stream().anyMatch(e -> e.equals(Character.toUpperCase(e)));
    }

    private static Optional<Character> findFirstDuplicate(List<Character> input) {
        Set<Character> set = input.stream().collect(Collectors.toSet());

        return input.stream().filter(e -> !set.add(e)).findFirst();
    }

    private static List<Character> reverseList(List<Character> input) {
        return IntStream.range(0,input.size()).mapToObj(i -> input.get(input.size() - 1 - i)).toList();
//        return input.stream()
//                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {Collections.reverse(list); return list;}));
    }
}
