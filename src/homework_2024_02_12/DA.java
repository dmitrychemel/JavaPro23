package homework_2024_02_12;//package PROF.dryKissYagni;


import java.util.List;
import java.util.function.ToIntFunction;

public class DA {
    // Нарушение DRY: Дублирование кода
    public void processData(List<Integer> data) {
        int totalAge = calculateSum(data, Integer::intValue);
        double averageAge = calculateAverage(data, Integer::intValue);
    }

    public void processUserData(List<User> users) {
        int totalAge = calculateSum(users, User::getAge);
        double averageAge = calculateAverage(users, User::getAge);
    }

    private <T> int calculateSum(List<T> list, ToIntFunction<? extends T> function) {
        return list.stream()
                .mapToInt((ToIntFunction<? super T>) function)
                .sum();
    }


    private <T> double calculateAverage(List<T> list, ToIntFunction<? extends T> function) {
        return list.stream()
                .mapToInt((ToIntFunction<? super T>) function)
                .average()
                .orElse(0.0);

    }
}

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

