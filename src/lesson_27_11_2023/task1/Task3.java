package lesson_27_11_2023.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task3 {

    public static void main(String[] args) {

        int [] array = {1,2,2,2,3,3,4,4,4,4,4,5,5,6};
        System.out.println("array");
        System.out.println(Arrays.toString(arrayUnique(array)));

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,2,2,3,3,4,4,4,4,4,5,5,6));
        System.out.println();
        System.out.println("list");
        System.out.println(listUnique(list));

    }

    public static int arrayCountUnique(int[] array) {

        Arrays.sort(array);
        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] != array[i + 1]) {
                count++;
            }
        }

        return count;
    }

    public static int[] arrayUnique(int[] array) {

        Arrays.sort(array);
        int[] arrayUnique = new int[arrayCountUnique(array)];
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

    public static List<Integer> listUnique(List<Integer> list) {

        Collections.sort(list);
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
