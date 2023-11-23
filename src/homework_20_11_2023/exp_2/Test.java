package homework_20_11_2023.exp_2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Book book1 = new Book("Гарри Поттер", "Дж. К. Роулинг", 1997);
        Book book2 = new Book("Зеленая миля", "Стивен Кинг", 1996);
        Book book3 = new Book("Война и Мир", "Лев Толстой", 1967);

        Librarian librarian1 = new Librarian("Игорь", 20);

        librarian1.addBookToLibrarian(book1);
        librarian1.addBookToLibrarian(book2);
        librarian1.addBookToLibrarian(book3);

        Reader reader1 = new Reader("Антон", 32);
        reader1.takeBook(book1, librarian1);
        reader1.takeBook(book2, librarian1);
        System.out.println("Книги - reader1" + Arrays.toString(reader1.getBookList()));

        System.out.println("Книги - livrarian1" + Arrays.toString(librarian1.getBooksLibrary()));

        reader1.returnBook(book1, librarian1);
        System.out.println("Книги - reader1" + Arrays.toString(reader1.getBookList()));

        System.out.println("Книги - livrarian1" + Arrays.toString(librarian1.getBooksLibrary()));


    }
}
