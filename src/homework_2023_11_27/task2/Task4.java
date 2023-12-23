package homework_2023_11_27.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Слово", "Человек", "Машина"));
        System.out.println(returnLengthString(list));
    }

    public static List<Integer> returnLengthString(List<String> list) {
        List<Integer> lengthString = new ArrayList<>();

        for(String word: list) {
            lengthString.add(word.length());
        }

        return lengthString;
    }
}
