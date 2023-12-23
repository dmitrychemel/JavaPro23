package homework_2023_11_29;


public interface Borrowable {
    void borrowItem(User user);
    void returnItem(User user);
    boolean isAvailable();
}
