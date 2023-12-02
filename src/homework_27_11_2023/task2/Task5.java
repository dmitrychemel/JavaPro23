package homework_27_11_2023.task2;

import homework_29_11_2023.LibraryItem;

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
