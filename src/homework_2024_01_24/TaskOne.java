package homework_2024_01_24;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TaskOne {
    /**
     * Прочитайте данные из файла data.txt используя FileInputStream и Scanner.
     * Создайте объекты класса Book для каждой строки.
     * Используйте Stream API для преобразования строк в объекты.
     * Сериализуйте список книг в файл с использованием ObjectOutputStream.
     */

    public static void main(String[] args) {
        List<Book> books = createBooks("taski.txt");

        serializeBooks(books, "serializedBooks.ser");
    }

    public static List<Book> createBooks(String file) {
        try (FileInputStream inputStream = new FileInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            return reader.lines()
                    .map(line -> line.split(", "))
                    .map(book -> new Book(Integer.parseInt(book[0]), book[1], book[2], Integer.parseInt(book[3]), Double.parseDouble(book[4])))
                    .toList();

        } catch (IOException e) {
        }
        return null;
    }

    public static void serializeBooks(List<Book> books, String file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(books);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
