package lesson_1.exp_4;

public class Mono {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 1, 1, 1, 1};
        int[] array3 = {5, 3, 2, 1, 0};
        int[] array4 = {1, 6, 3, 6, 2};

        System.out.println(checkMono(array1));
        System.out.println(checkMono(array2));
        System.out.println(checkMono(array3));
        System.out.println(checkMono(array4));
    }

    public static boolean checkMono(int[] array) {
        int start = 0;
        int end = array.length - 1;


        if (array[start] >= array[start + 1]) {
            while (true) {
                if (start == end) {
                    return true;
                }
                if (array[start] < array[start + 1]) {
                    return false;
                }
                start++;
            }
        } else {
            while (true) {
                if (start == end) {
                    return true;
                }
                if(array[start] > array[start + 1]){
                    return false;
                }
                start++;
            }
        }
    }
}
