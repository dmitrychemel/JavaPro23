package lesson_1_homework.exp_2;

public class Reader {

    private String name;
    private int age;
    private Book[] bookList;

    public Reader(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Book[] getBookList() {
        return bookList;
    }

    public void setBookList(Book[] bookList) {
        this.bookList = bookList;
    }

    public void takeBook(Book book, Librarian librarian) {
        // вызвать метод у библиотекаря
        // выдает мне true
        // добавляю книгу
        if(librarian.giveBook(book)){
            addBook(book);
        } else {
            System.out.println("Нет книги в наличии");
        }
    }

    public void returnBook(Book book, Librarian librarian) {
        // удалить книгу
        // вызвать метод у библиотекаря
        deleteBook(book);
        librarian.takeBook(book);
    }

    private void addBook(Book book){
        Book[] newBooksLibrary = new Book[bookList.length + 1];
        System.arraycopy(bookList, 0, newBooksLibrary, 0, bookList.length - 1);
        newBooksLibrary[bookList.length] = book;
        setBookList(newBooksLibrary);
    }

    private void deleteBook(Book book){
        for (int i = 0; i < bookList.length ; i++) {
            if(bookList[i].equals(book)){
                Book[] newBooksLibrary = new Book[bookList.length - 1];
                System.arraycopy(bookList, 0, newBooksLibrary, 0, i);
                System.arraycopy(bookList, i + 1, newBooksLibrary, 0, bookList.length - i - 1);
                setBookList(newBooksLibrary);
            }
        }
    }
}
