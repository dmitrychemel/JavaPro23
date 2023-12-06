package marat.list;

import marat.oop.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TasjList {
    public static void main(String[] args) {
        List<String> ghghgh = new ArrayList<>(Arrays.asList("gdge","ggsdg"));
        int[] array = {1,23,521,52,5};
        int[] array1 = new int[15];



        ghghgh.add("first");
        ghghgh.add("second");
        ghghgh.add("third");


        System.out.println(ghghgh);

//        list.remove("second");
        System.out.println(ghghgh);

        for (int i = 0; i < ghghgh.size(); i++) {
            System.out.println(ghghgh.get(i)); // array[i];
        }

        System.out.println(ghghgh.contains("first"));
    }
}
