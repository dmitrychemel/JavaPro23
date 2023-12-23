package homework_2023_11_27.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 16, 15, 19};
        arrayTwoSum(array, 12);
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 56, 7, 3, 6, 3, 2));
        listTwoSum(list, 7);
    }

    public static void arrayTwoSum(int[] array, int sum) {
        Arrays.sort(array);
        int start = 0;
        int end = array.length - 1;

        while (!(start == end)) {
            if (array[start] + array[end] > sum) {
                end--;
            } else if (array[start] + array[end] < sum) {
                start++;
            } else {
                System.out.println("индексы: " + start + ", " + end);
                start++;
            }
        }
    }

    public static void listTwoSum(List<Integer> list, int sum) {

        Collections.sort(list);
        int start = 0;
        int end = list.size() - 1;

        while (!(start == end)) {
            if (list.get(start) + list.get(end) > sum) {
                end--;
            } else if (list.get(start) + list.get(end) < sum) {
                start++;
            } else {
                System.out.println("индексы: " + start + ", " + end);
                start++;
            }
        }
    }
}
