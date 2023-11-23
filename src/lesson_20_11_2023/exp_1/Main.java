package lesson_20_11_2023.exp_1;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int sum = 0;
        for (int i = 0; i < array.length / 2; i++) {
            sum = array[i] + array[array.length - 1 - i] + sum;
        }
        if (array.length % 2 != 0) {
            sum = sum + array[array.length / 2];
        }
        System.out.println(sum);
    }
}