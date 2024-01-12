package homework_2024_01_08;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        filterOddAndEven(numbers, 5);
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi");

    }

    public static void filterOddAndEven(List<Integer> numbers, int x) {
        Optional<Integer> sum;
        if (x % 2 == 0) {
            sum = numbers.stream()
                    .filter(e -> e % 2 == 0)
                    .reduce(Integer::sum);
        } else {
            sum = numbers.stream()
                    .filter(e -> e % 2 != 0)
                    .reduce(Integer::sum);
        }
        sum.ifPresent(System.out::println);
    }

    static void sumNumbers5And3(List<Integer> numbers) {
        Optional<Integer> sum = numbers.stream().filter(e -> e % 3 == 0 && e % 5 == 0).reduce(Integer::sum);
        sum.ifPresent(System.out::println);
    }

    static void averageNum(List<Integer> numbers) {
        OptionalDouble average = numbers.stream().mapToDouble(Integer::doubleValue).average();
        average.ifPresent(System.out::println);
    }

    static List<Integer> StringToInteger(List<String> numbers) {
        List<Integer> list = numbers.stream().map(Integer::parseInt).collect(Collectors.toList());

        return list;
    }
    static Set<String> filterList(List<String> words) {

        return words.stream()
                .filter(e -> 'a' == e.toLowerCase().charAt(0))
                .collect(Collectors.toSet());
    }
}
