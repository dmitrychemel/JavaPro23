package homework_2024_01_08;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("John", 25), new Person("Alice", 22), new Person("Bob", 30));
    }
    private static List<Integer> m1(List<Integer> numbers) {
        return numbers.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
    }

    private static List<Integer> m2(List<String> strings) {
        return strings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private static Integer m3(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum); //reduce(Integer::sum)
    }

    private static List<String> m6(List<String> words, int length) {
        return words.stream().filter(e -> e.length() > length).collect(Collectors.toList());
    }

    private static List<String> m7(List<Person> people) {
        return people.stream().sorted(Comparator.comparingInt(p -> p.age)).map(p -> p.name).toList();
    }

    private static Integer m8(List<Integer> numbers) {
        return numbers.stream().filter(e -> e % 3 == 0 && e % 5 == 0).reduce(0, Integer::sum);
    }

    private static List<String> m9(List<String> words) {
        return words.stream().filter(Task2::helperM9).toList();
    }

    private static boolean helperM9(String word) {
        Set<Character> setChar = new HashSet<>();
        for(Character ch : word.toCharArray()) {
            setChar.add(ch);
        }

        return setChar.size() == word.length();
    }
}
