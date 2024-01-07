package artur;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[][] array = new int[][] {{1,2,4,5},
                                     {6,7,8,9},
                                     {10,11,12,13}};

        int[] array1 = new int[] {1,2,3,4,5,6,7,8,9,10};
        int element = 11;
//        System.out.println(searchElement(5, array1));

        System.out.println(searchElement2(15, array));

//        int[] array2 = new int[] {1,2,3,4};
//        System.out.println(Arrays.toString(array2));
    }

    public static boolean searchElement(int x, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == x) {
                return true;
            }
        }

        return false;
    }

    public static boolean searchElement2(int x, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == x){
                    return true;
                }

            }
        }

        return false;
    }

}
