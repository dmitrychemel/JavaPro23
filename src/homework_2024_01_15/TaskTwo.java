package homework_2024_01_15;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        List<String> stringList = List.of("hello", "my", "super", "kaif", "rok", "pop", "dog");
//        System.out.println(uniqueSortedWords(stringList));

        System.out.println(uniqueChars(stringList));
    }

    public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number)
                .reduce(0,Integer::sum);
    }

    public static List<String> uniqueSortedWords(List<String> strings) {
        return strings.stream()
                .distinct()
                .sorted()
                .toList();
    }

    public static <T> List<T> filterByField(List<T> objects, String fieldName, Object value) throws NoSuchFieldException {
        return objects.stream()
                .filter(obj -> {
                    try {
                        Field field = obj.getClass().getDeclaredField(fieldName);
                        field.setAccessible(true);
                        Object fieldValue = field.get(obj);
                        return fieldValue != null && fieldValue.equals(value);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }

    public static List<Character> uniqueChars(List<String> strings) {
        return strings.stream()
                .flatMapToInt(CharSequence::chars)
                .distinct()
                .mapToObj(element -> (char) element)
                .toList();
    }

    public static String longestString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }

    public static <T> double averageFieldValue(List<T> objects, String fieldName) throws NoSuchFieldException {
        return objects.stream()
                .mapToDouble(obj -> {
                    try {
                        Field field = obj.getClass().getDeclaredField(fieldName);
                        field.setAccessible(true);
                        Object value = field.get(fieldName);
                        if(value instanceof Number) {
                            return ((Number)value).doubleValue();
                        }
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    return 0;
                })
                .average().orElse(0);
    }
}
