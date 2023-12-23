package homework_2023_11_27.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Слово", "Человек", "Машина"));
        String delete = "Машина";
        System.out.println(deleteWord(list, delete));
    }

    public static List<String> deleteWord(List<String> list, String word) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)){
                list.remove(i);
            }
        }

        return list;
    }
}
