package homework_2023_11_27.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 14, 15, 16, 17, 18, 19, 20));
        System.out.println(selectNumbers(list, 16));
    }

    public static List<Integer> selectNumbers(List<Integer> list, int number) {
        List<Integer> newList = new ArrayList<>();
        for (Integer num : list) {
            if (num > number) {
                newList.add(num);
            }
        }

        return newList;
    }

}
