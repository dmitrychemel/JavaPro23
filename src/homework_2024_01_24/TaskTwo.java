package homework_2024_01_24;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskTwo {
    public static void main(String[] args) {
        List<Book> books = deserializeBooksFromFile("serializedBooks.ser");
        List<Book> filteredBooks = filteredBookByYear(books, 1900);

        serializeBooksToFile(filteredBooks, "filteredBooks.ser");
        serializeBooksToFile(filteredBookByPrice(books, 380), "filteredBooksByPrice.ser");
    }

    public static List<Book> deserializeBooksFromFile(String fileName) {
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Book>) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Book> filteredBookByYear(List<Book> books, int threshold) {
        return books.stream()
                .filter(book -> book.getYear() > threshold)
                .toList();
    }

    public static void serializeBooksToFile(List<Book> books, String nameFile) {
        try(ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(nameFile))) {
            objectOut.writeObject(books);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static List<Book> filteredBookByPrice(List<Book> books, double threshold) {
        return  books.stream()
                .filter(book -> book.getPrice() > threshold)
                .toList();
    }

    public static Map<String, Double> groupingByAuthor(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.averagingDouble(Book::getPrice)));
    }

    public static void serializeStatisticsToFile(Map<String, Double> statistics, String fileName) {
        try(ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOut.writeObject(statistics);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
