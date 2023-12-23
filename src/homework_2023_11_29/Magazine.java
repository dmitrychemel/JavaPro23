package homework_2023_11_29;

import java.time.LocalDate;

public class Magazine extends LibraryItem implements Comparable<Magazine> {
    private int issueNumber;
    private LocalDate releaseDate;
    private boolean isMonthly;

    private ItemCondition itemCondition;

    public Magazine(String title, String author, Genre genre, int issueNumber, LocalDate releaseDate, boolean isMonthly, ItemCondition itemCondition) {
        super(title, author, genre);
        this.issueNumber = issueNumber;
        this.releaseDate = releaseDate;
        this.isMonthly = isMonthly;
        this.itemCondition = itemCondition;
    }

    public ItemCondition getItemCondition() {
        return itemCondition;
    }

    public boolean isMonthly() {
        return isMonthly;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "Magazine | " +
                " title - " + getTitle() +
                ", author - " + getAuthor() +
                ", genre - " + getGenre() +
                ", issueNumber - " + issueNumber +
                ", releaseDate - " + releaseDate +
                ", isMonthly - " + isMonthly +
                ", itemCondition - " + itemCondition;
    }

    @Override
    public int compareTo(Magazine o) {
        return this.getReleaseDate().compareTo(o.releaseDate);
    }
}
