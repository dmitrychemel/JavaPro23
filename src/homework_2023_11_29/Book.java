package homework_2023_11_29;

import java.time.LocalDate;

public class Book extends LibraryItem implements Borrowable, Maintainable, Comparable<Book> {

    private BookStatus status;
    private LocalDate publishDate;
    private int pageCount;

    public Book(String title, String author, Genre genre, BookStatus status, LocalDate publishDate, int pageCount) {
        super(title, author, genre);
        this.status = status;
        this.publishDate = publishDate;
        this.pageCount = pageCount;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public BookStatus getStatus() {
        return status;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public void borrowItem(User user) {
        user.getBorrowedItems().add(this);
        this.status = BookStatus.BORROWED;
    }

    @Override
    public void returnItem(User user) {
        user.getBorrowedItems().remove(this);
        this.status = BookStatus.AVAILABLE;
    }

    @Override
    public boolean isAvailable() {
        if(this.status.equals(BookStatus.AVAILABLE)) {
            return  true;
        }

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
        return "Book | " +
                " title - " + getTitle() +
                ", author - " + getAuthor() +
                ", genre - " + getGenre() +
                ", status - " + status +
                ", publishDate - " + publishDate +
                ", pageCount  - " + pageCount;
    }

    @Override
    public int compareTo(Book o2) {
        return this.publishDate.compareTo(o2.publishDate);
    }

}
