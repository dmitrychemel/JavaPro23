package lesson_29_11_2023;

import java.time.LocalDate;

public class Magazine extends LibraryItem {
    private int issueNumber;
    private LocalDate releaseDate;
    private boolean isMonthly;

    public Magazine(String title, String author, Genre genre, int issueNumber, LocalDate releaseDate, boolean isMonthly) {
        super(title, author, genre);
        this.issueNumber = issueNumber;
        this.releaseDate = releaseDate;
        this.isMonthly = isMonthly;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "issueNumber=" + issueNumber +
                ", releaseDate=" + releaseDate +
                ", isMonthly=" + isMonthly +
                '}';
    }
}
