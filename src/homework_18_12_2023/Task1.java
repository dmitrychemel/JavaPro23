package homework_18_12_2023;

public class Task1 {
//    Создайте функциональный интерфейс StringLength с методом getLength, который принимает строку и возвращает её длину.
//    Напишите метод, который принимает строку и StringLength интерфейс и выводит длину строки.

    public static void main(String[] args) {
        String str = "Hello";

        System.out.println(stringLength(str, str1 -> str1.length()));
    }

    public static int stringLength (String str, StringLength inter) {
       int length = inter.getLength(str);

       return length;
    }


}
@FunctionalInterface
interface StringLength {
    int getLength(String str);
}
