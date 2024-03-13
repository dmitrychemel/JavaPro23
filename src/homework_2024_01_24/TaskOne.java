package homework_2024_01_24;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        List<Book> books = createBookFromFile("task_2024_01_24.txt");

        serializeBooks(books, "serializedBooks.ser");
    }

    public static List<Book> createBookFromFile(String fileName) {
        try (FileInputStream inputStream = new FileInputStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines()
                    .map(currentLine -> currentLine.split(", "))
                    .map(parts -> new Book(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4])))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serializeBooks(List<Book> books, String file) {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOut.writeObject(books);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
