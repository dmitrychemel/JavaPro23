package lesson_1_homework.exp_2;

import java.util.Arrays;

public class Librarian {

    private String name;
    private int workExperience;
    private Book[] booksLibrary;

    public Librarian(String name, int workExperience) {
        this.name = name;
        this.workExperience = workExperience;
        booksLibrary = new Book[0];
    }

    public String getName() {
        return name;
    }

    public Book[] getBooksLibrary() {
        return booksLibrary;
    }

    public void setBooksLibrary(Book[] booksLibrary) {
        this.booksLibrary = booksLibrary;
    }

    public boolean giveBook(Book book) {
        // поиск книги и выдать true | false
        // удалить книгу
        if(searchBook(book)){
            deleteBook(book);
            return true;
        }
        return false;
    }

    public void takeBook(Book book) {
        addBook(book);
    }

    private boolean searchBook(Book book) {
        for (int i = 0; i < booksLibrary.length; i++) {
            if(booksLibrary[i].equals(book)){
                return true;
            }
        }
        return false;
    }

    private void addBook(Book book) {
        Book[] newBooksLibrary = new Book[booksLibrary.length + 1];
        System.arraycopy(booksLibrary, 0, newBooksLibrary, 0, booksLibrary.length);
        newBooksLibrary[booksLibrary.length] = book;
        setBooksLibrary(newBooksLibrary);
    }

    private void deleteBook(Book book) {
        for (int i = 0; i < booksLibrary.length ; i++) {
            if(booksLibrary[i].equals(book)){
                Book[] newBooksLibrary = new Book[booksLibrary.length - 1];
                System.arraycopy(booksLibrary, 0, newBooksLibrary, 0, i);
                System.arraycopy(booksLibrary, i + 1, newBooksLibrary, 0, booksLibrary.length - i - 1);
                setBooksLibrary(newBooksLibrary);
            }
        }
    }

    public void addBookToLibrarian(Book book) {
        addBook(book);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                ", workExperience=" + workExperience +
                ", booksLibrary=" + Arrays.toString(booksLibrary) +
                '}';
    }
}
