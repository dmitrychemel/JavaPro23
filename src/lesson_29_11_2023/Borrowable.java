package lesson_29_11_2023;


public interface Borrowable {
    void borrowItem(User user);
    void returnItem(User user);
    boolean isAvailable();
}
