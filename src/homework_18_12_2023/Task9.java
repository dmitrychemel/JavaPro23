package homework_18_12_2023;

import java.util.Arrays;

public class Task9 {

//    Создайте функциональный интерфейс NumberProcessor с методом process, который выполняет операцию над массивом чисел.
//    Напишите метод, который принимает массив чисел и NumberProcessor, и возвращает массив после умножения каждого элемента на -1

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(multiplication(array, Task9::multiplicationInterface)));
    }

    public static int[] multiplication(int[] array, NumberProcessor numberProcessor) {
        return numberProcessor.process(array);
    }

    public static int[] multiplicationInterface(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * -1;
        }

        return array;
    }
}

interface NumberProcessor {
    int[] process(int[] array);
}
