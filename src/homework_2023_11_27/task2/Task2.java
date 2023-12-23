package homework_2023_11_27.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Слово", "Человек", "Машина"));
        System.out.println(connectionString(list));
    }

    public static StringBuilder connectionString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String word: list) {
            stringBuilder.append(word);
            stringBuilder.append(" ");
        }

        return stringBuilder;
    }
}
