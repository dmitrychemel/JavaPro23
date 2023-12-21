package homework_18_12_2023;

public class Task6 {
    //    Создайте функциональный интерфейс ArrayTransformer с методом transform, который принимает массив
//    целых чисел и выполняет операцию возведения каждого элемента в квадрат.
//    Напишите метод, который принимает массив и ArrayTransformer, и изменяет массив, возведя каждый его элемент в квадрат.
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        arrayToPowerTwo(array, array1 -> {
            for (Integer num: array1) {
                System.out.println(num * num);
            }
        });
    }

    public static void arrayToPowerTwo(int[] array, ArrayTransformer transformer) {
        transformer.transform(array);
    }
}

@FunctionalInterface
interface ArrayTransformer {
    void transform(int[] array);
}
