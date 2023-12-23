package homework_2023_12_18;

public class Task4 {
    //    Создайте функциональный интерфейс UpperCaseConverter с методом convert, который преобразует строку в верхний регистр.
//    Напишите метод, который принимает строку и UpperCaseConverter интерфейс, и преобразует её в верхний регистр.
    public static void main(String[] args) {
        System.out.println(toUpperCase("hello", word -> word.toUpperCase()));
    }

    public static String toUpperCase(String str, UpperCaseConverter converter) {
        return converter.convert(str);
    }
}

@FunctionalInterface
interface UpperCaseConverter {
    String convert(String str);
}
