package homework_2024_01_15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskOne {
    public static void main(String[] args) {
        List<String> stringList = Stream.of("Good", "Better", "Best", "Like", "Home").toList();
    }

    public static Set<String> deleteDuplicationCollectToSet(List<String> list) {
        return list.stream()
                .collect(Collectors.toSet());
    }

    public static Map<Integer, List<String>> groupingByLengthWord(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    public static Map<String, Long> countingRecurringElements(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    public static List<String> deleteDuplicationCollectToList(List<String> list) {
        List<String> uniqueList = list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), ArrayList::new));

        return uniqueList;
    }

    public static String createCommonString(List<String> list) {
        return list.stream()
                .collect(Collectors.joining(""));
    }

    public static Set<Character> splittingIntoCharactersCollectToSet(String word) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }

    public static Map<String, char[]> groupingByCharactersToMap(List<String> list) {
        return list.stream()
                .collect(Collectors.toMap(word -> word, String::toCharArray));
    }

    public static int countingAllAgePerson(List<Person> list) {
        return list.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum);
    }

    public static void gropingPersonByAge(List<Person> list) {
        Map<Integer, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
    }


}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
