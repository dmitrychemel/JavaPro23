package lesson_1_homework.exp_2;

public class Test {
    public static void main(String[] args) {
        Book book1 = new Book("Гарри Поттер", "Дж. К. Роулинг", 1997);
        Book book2 = new Book("Зеленая миля", "Стивен Кинг", 1996);
        Book book3 = new Book("Война и Мир", "Лев Толстой", 1967);

        Librarian librarian1 = new Librarian("Игорь", 20);

        librarian1.addBookToLibrarian(book1);
        librarian1.addBookToLibrarian(book2);
        librarian1.addBookToLibrarian(book3);
    }
}
