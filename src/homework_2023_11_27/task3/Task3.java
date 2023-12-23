package homework_2023_11_27.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("Слово", "Колба", "Мороженое", "Человек", "Машина", "Машина", "Банан", "Слово", "Слово"));
        System.out.println(connectList(stringList));
    }

    public static StringBuilder connectList(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            if(i != list.size() - 1){
                stringBuilder.append(list.get(i));
                stringBuilder.append(",");
            } else {
                stringBuilder.append(list.get(i));
            }
        }

        return stringBuilder;
    }
}
