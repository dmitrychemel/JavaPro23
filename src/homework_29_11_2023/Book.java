package homework_29_11_2023;

import java.time.LocalDate;

public class Book extends LibraryItem implements Borrowable, Maintainable {

    private BookStatus status;
    private LocalDate publishDate;
    private int pageCount;

    public Book(String title, String author, Genre genre, BookStatus status, LocalDate publishDate, int pageCount) {
        super(title, author, genre);
        this.status = status;
        this.publishDate = publishDate;
        this.pageCount = pageCount;
    }

    @Override
    public void borrowItem(User user) {

    }

    @Override
    public void returnItem(User user) {

    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void repairItem() {

    }

    @Override
    public void updateItemCondition(ItemCondition condition) {

    }

    @Override
    public ItemCondition checkCondition() {
        return null;
    }

    @Override
    public String toString() {
        return "Book{" +
                "status=" + status +
                ", publishDate=" + publishDate +
                ", pageCount=" + pageCount +
                '}';
    }
}
