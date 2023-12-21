package homework_18_12_2023;

public class Task5 {
    //    Создайте функциональный интерфейс Logger с методом log, который принимает строку и выводит её в консоль.
//    Напишите метод, который использует Logger для логирования различных сообщений.
    public static void main(String[] args) {
        method(word -> System.out.println(word), "hello");
    }

    public static void method(Logger logger, String str) {
        logger.log(str);
    }
}

interface Logger {
    void log(String str);
}
