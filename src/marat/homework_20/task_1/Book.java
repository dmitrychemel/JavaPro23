package marat.homework_20.task_1;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private LocalDate publication;

    public Book(String name, String author, LocalDate publication) {
        this.name = name;
        this.author = author;
        this.publication = publication;
    }

    public void infoBook() {

    }

    public void oldThan50() {

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(publication, book.publication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publication);
    }
}
