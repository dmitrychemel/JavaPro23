package homework_2024_01_24;

import java.io.*;
import java.util.List;

public class TaskTwo {
    /**
     * Десериализуйте список книг из файла,
     * созданного в предыдущем задании, используя ObjectInputStream.
     * Используйте Stream API для фильтрации книг, например, по автору или году издания.
     * Результаты сохраните в новый сериализованный файл
     */
    public static void main(String[] args) {
        List<Book> books = deserializeBooksFromFile("serializedBooks.ser");
        List<Book> filteredBooks = filterListByYear(books, 1900);
        serializeBooksToFile(filteredBooks, "filteredBooks.ser");
    }

    private static List<Book> deserializeBooksFromFile(String file) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Book>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Book> filterListByYear(List<Book> books, int year) {
        return books.stream()
                .filter(e -> e.getYear() > year)
                .toList();
    }

    private static void serializeBooksToFile(List<Book> books, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(books);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
