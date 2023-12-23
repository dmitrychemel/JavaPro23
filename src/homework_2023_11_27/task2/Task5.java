package homework_2023_11_27.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("Слово", "Колба", "Мороженое", "Человек", "Машина", "Машина", "Банан", "Слово", "Слово"));
        System.out.println(listUnique(stringList));
    }

    public static List<String> listUnique(List<String> list) {
        List<String> listUnique = new ArrayList<>();

        for (String word: list) {
            if(!listUnique.contains(word)) {
                listUnique.add(word);
            }
        }

        return listUnique;
    }
}
