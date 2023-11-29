package lesson_27_11_2023.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,16,15,19};
        arrayTwoSum(array,12);
        List<Integer> list = new ArrayList<>(Arrays.asList(1,5,56,7,3,6,3,2));
    }

    public static void arrayTwoSum(int[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] + array[j] == sum) {
                    System.out.println("индексы: " + i + ", "+ j);
                }
            }
        }
    }

    public static void ListTwoSum(List<Integer> list, int sum) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(i) + list.get(j) == sum) {
                    System.out.println("индексы: " + i + ", "+ j);
                }
            }
        }
    }
}
