package homework_27_11_2023.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("Слово", "Колба", "Мороженое", "Человек", "Машина", "Машина", "Банан", "Слово", "Слово"));
        System.out.println(listUnique(stringList));
    }

    public static List<String> listUnique(List<String> list) {
        int start = 0;

        while(start < list.size()) {
            for (int i = start + 1; i < list.size(); i++) {
                if (list.get(start).equals(list.get(i))) {
                    list.remove(i);
                    i--;
                }
            }
            start ++;
        }

        return list;
    }
}
