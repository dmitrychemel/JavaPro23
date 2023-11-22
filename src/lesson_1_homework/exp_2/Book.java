package lesson_1_homework.exp_2;

public class Book {
    private String name;
    private String author;
    private int publication;

    public Book(String name, String author, int publication) {
        this.name = name;
        this.author = author;
        this.publication = publication;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublication() {
        return publication;
    }

    public String infoBook(Book book) {
        return "Book{" +
                "name='" + book.name + '\'' +
                ", author='" + book.author + '\'' +
                ", publication=" + book.publication +
                '}';
    }

    public void checkPublication(Book book) {
        int nowYear = 2023;
        if(nowYear - book.publication > 50) {
            System.out.println("Книга старше 50 лет");
        }
        System.out.println("Книга не старше 50 лет");
    }

}
