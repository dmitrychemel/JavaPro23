package lesson_27_11_2023.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11};
        List<Integer> list= new ArrayList<>(Arrays.asList(12,13,14,15,16,17,18,19,20));

        System.out.println("Array - " + Arrays.toString(reverseOrderArray(array)));

    }

    public static int[] reverseOrderArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }

        return array;
    }

    public static List<Integer> reverseOrderList(List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            int temp = list.get(i);
            list.set(list.get(i), list.get(list.size() - 1));
            list.set(list.get(list.size() - 1), temp);
        }

        return list;
    }
}
