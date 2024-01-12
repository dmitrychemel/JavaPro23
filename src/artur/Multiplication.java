package artur;

import java.util.Arrays;

public class Multiplication {
    public static void main(String[] args) {
//        Проинициализируй массив MULTIPLICATION_TABLE значением new int[10][10], заполни его таблицей умножения и выведи в консоли в следующем виде:
//
//        1 2 3 4 …
//        2 4 6 8 …
//        3 6 9 12 …
//        4 8 12 16 …
//        Числа в строке разделены пробелом
//
//                Требования:
//•    В методе main массив MULTIPLICATION_TABLE должен быть заполнен таблицей умножения.
//•    Выведенный текст должен содержать 10 строк.
//•    Каждая выведенная строка должна содержать 10 чисел, разделенных пробелом.
//•    Выведенные числа должны быть таблицей умножения.
        ;
        int [][] array = multiplicationTable();

        System.out.println(Arrays.deepToString(array));

    }

    public static int[][] multiplicationTable() {
        int [][] array = new int[10][10];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (i + 1) * (j + 1);
            }
        }

        return array;
    }

    public static void newArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 1;
            }
        }
    }
}
