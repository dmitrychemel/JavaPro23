package lesson_1.exp_2;

public class Counter {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        oddAndEvenCounter(array);
    }

    public static void oddAndEvenCounter(int[] array) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sumEven++;
            } else {
                sumOdd++;
            }
        }

        System.out.println("Четные числа - " + sumEven);
        System.out.println("Нечетные числа - " + sumOdd);
    }
}
