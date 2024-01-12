package homework_2024_01_10;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskStrings {
//    1. Задача: Фильтрация списка строк по длине.
//    Сигнатура: List<String> filterByLength(List<String> input, int length);
//
//    2. Задача: Преобразование всех строк в верхний регистр.
//    Сигнатура: List<String> toUpperCase(List<String> input);
//
//    3. Задача: Поиск первой строки, начинающейся на заданную букву.
//    Сигнатура: Optional<String> findFirstStartingWith(List<String> input, char letter);
//
//    4. Задача: Соединение строк через запятую.
//    Сигнатура: String joinByComma(List<String> input);
//
//    5. Задача: Подсчёт количества строк, содержащих заданный символ.
//    Сигнатура: long countContainingChar(List<String> input, char ch);
    public static void main(String[] args) {

    }

    private static List<String> filterByLength(List<String> input, int length) {
        return input.stream().filter(e -> e.length() > length).toList();
    }

    private static List<String> toUpperCase(List<String> input) {
        return input.stream().map(String::toUpperCase).toList();
    }

    private static Optional<String> findFirstStartingWith(List<String> input, char letter) {
        return input.stream().filter(e -> letter == e.charAt(0)).findFirst();
    }

    private static String joinByComma(List<String> input) {
        return input.stream().collect(Collectors.joining(", "));
    }

    private static long countContainingChar(List<String> input, char ch) {
        return input.stream().filter(e -> e.contains(String.valueOf(ch))).count();
    }
}
