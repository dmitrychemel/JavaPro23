package homework_18_12_2023;

import java.util.Arrays;

public class Task10 {
    //    Создайте функциональный интерфейс ArrayRotator с методом rotate, который выполняет циклический сдвиг элементов массива.
    //    Напишите метод, который принимает массив и ArrayRotator и шаг сдвига, и выполняет сдвиг массива на заданную позицию влево.
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(shiftArray(array, 3, Task10::rotate)));
    }

    public static int[] shiftArray(int[] array, int shift, ArrayRotator rotate) {
        return rotate.rotate(array, shift);
    }

    public static int[] rotate(int[] array, int shift) {
        if(shift < 1) {
            return array;
        }

        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i -1] = array[i];
        }
        array[array.length - 1] = temp;

        return rotate(array, shift - 1);
    }


}

interface ArrayRotator {
    int[] rotate(int[] array, int shift);
}
