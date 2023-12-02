package homework_27_11_2023.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task2_Variant2 {

    public static void main(String[] args) {

        int [] array = {1,2,2,2,3,3,4,4,4,4,4,5,5,6};
        System.out.println("array");
        System.out.println();
        arrayCountInt(array);

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,2,2,3,3,4,4,4,4,4,5,5,6));
        System.out.println();
        System.out.println("list");
        System.out.println();
        listCountInt(list);
    }

    public static void arrayCountInt(int[] array) {

        Arrays.sort(array);
        int[] arrayUnique = arrayUnique(array,arrayCountUnique(array));
        for (int e : arrayUnique) {
            int count = 0;
            for (int num : array) {
                if (e == num) {
                    count++;
                }
            }
            System.out.println("Число " + e + " встречается: " + count);
        }
    }

    public static int arrayCountUnique(int[] array) {

        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] != array[i + 1]) {
                count++;
            }
        }

        return count;
    }

    public static int[] arrayUnique(int[] array, int length) {

        int[] arrayUnique = new int[length];
        arrayUnique[0] = array[0];
        int index = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] != array[i + 1]) {
                arrayUnique[index] = array[i + 1];
                index++;
            }
        }

        return arrayUnique;
    }
    public static void listCountInt(List<Integer> list) {

        Collections.sort(list);
        List<Integer> listUnique = listUnique(list);
        for (Integer integer : listUnique) {
            int count = 0;
            for (Integer value : list) {
                if (integer.equals(value)) {
                    count++;
                }
            }
            System.out.println("Число " + integer + " встречается: " + count);
        }
    }

    public static List<Integer> listUnique(List<Integer> list) {

        List<Integer> listUnique = new ArrayList<>();
        listUnique.add(list.get(0));
        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) != list.get(i + 1)) {
                listUnique.add(list.get(i + 1));
            }
        }

        return listUnique;
    }
}
