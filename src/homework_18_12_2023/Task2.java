package homework_18_12_2023;

public class Task2 {
//    Создайте функциональный интерфейс NumberOperation с методом operate, который принимает два целых числа и возвращает целое число.
//    Напишите методы для выполнения базовых арифметических операций (сложение, вычитание, умножение, деление) с использованием этого интерфейса.

    public static void main(String[] args) {
        System.out.println(sum(10, 5, (first, second) -> first + second));
        System.out.println(sub(10, 5, (first, second) -> first - second));
        System.out.println(division(10, 5, (first, second) -> first / second));
        System.out.println(mult(10, 5, (num1, num2) -> num1 * num2));
    }

    public static int sum(int first, int second,NumberOperation operation ) {
        return operation.operate(first, second);
    }

    public static int sub(int first, int second, NumberOperation operation) {
        return operation.operate(first, second);
    }

    public static int division(int first, int second, NumberOperation operation) {
        return operation.operate(first, second);
    }

    public static int mult(int first, int second, NumberOperation operation) {
        return operation.operate(first, second);
    }


}
@FunctionalInterface
interface NumberOperation {
    int operate(int first, int second);
}
