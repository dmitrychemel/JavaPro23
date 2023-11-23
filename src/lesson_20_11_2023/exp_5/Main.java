package lesson_20_11_2023.exp_5;

public class Main {
    public static void main(String[] args) {


    }
    public static int findMin(int[] array) {
        int minFirst = Integer.MAX_VALUE;
        int minSecond = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            if(minFirst <= array[i]) {
                minSecond = minFirst;
                minFirst = array[i];
            }

            if(minSecond < array[i]){
                minSecond = array[i];
            }
        }

        return minSecond;
    }
}
