package lesson_1_homework.exp_1;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int[] array1 = {11,23,5,6,32,5,8,55,33,33,1,23,6};
        System.out.println(Arrays.toString(reverseArray(array)));
        System.out.println(searchThirdLargest(array1));
    }

    public static int[] reverseArray(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int temp = 0;
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    public static int searchThirdLargest(int[] array) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if(array[i] >= first) {
                third = second;
                second = first;
                first = array[i];
                continue;
            }

            if(array[i] >= second) {
                third = second;
                second = array[i];
                continue;
            }

            if(array[i] >= third) {
                third = array[i];
            }
        }

        return third;
    }
}
