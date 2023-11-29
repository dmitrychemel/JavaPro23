package lesson_29_11_2023;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionProcessor {
    public static void main(String[] args) {
        List<LibraryItem> libraryItemList = new ArrayList<>();

        libraryItemList.add(new Book("Война мир", "Толстой", Genre.FICTION, BookStatus.AVAILABLE, LocalDate.of(1009, 7, 22), 600));
        libraryItemList.add(new Book("Человек", "Антон Григорий", Genre.FANTASY, BookStatus.LOST, LocalDate.of(2000, 9, 25), 100));
        libraryItemList.add(new Book("Робин Гуд", "Василий", Genre.NON_FICTION, BookStatus.BORROWED, LocalDate.of(2096, 10, 15), 300));
        libraryItemList.add(new Magazine("Робин Гуд", "Василий", Genre.NON_FICTION, 15, LocalDate.of(2096, 10, 15), false));

        printAllItems(libraryItemList);
        System.out.println();
        System.out.println("new method");
        listItemsByGenre(libraryItemList, Genre.FANTASY);
        System.out.println();
        System.out.println("new method");
        sortByTitle(libraryItemList);
    }

    static void printInfo(LibraryItem item) {
        System.out.print(item);
        System.out.print(" " + item.getTitle());
        System.out.print(" " + item.getAuthor());
        System.out.println(" " + item.getGenre());
    }
    static void printAllItems(List<LibraryItem> items) {
        for(LibraryItem item: items){
            printInfo(item);
        }
    }
    static void listItemsByGenre(List<LibraryItem> items, Genre genre) {
        for (LibraryItem item: items) {
            if(item.getGenre().equals(genre)) {
                printInfo(item);
            }
        }
    }
    static void sortByTitle(List<LibraryItem> items) {
        Collections.sort(items, Comparator.comparing(LibraryItem::getTitle));
        for(LibraryItem item: items){
            printInfo(item);
        }
    }
    void filterByAuthor(List<LibraryItem> items, String author) {}
    void countItemsByStatus(List<LibraryItem> items, BookStatus status) {}
    void updateStatus(List<LibraryItem> items, BookStatus oldStatus, BookStatus newStatus) {}
    void listAvailableItems(List<LibraryItem> items) {}
    void findOldestItem(List<LibraryItem> items) {}
    void groupItemsByAuthor(List<LibraryItem> items) {}
    void listItemsForRepair(List<LibraryItem> items) {}
    void displayItemCount(List<LibraryItem> items) {}
    void listBorrowedItemsByUser(List<LibraryItem> items, User user) {}
    void removeLostItems(List<LibraryItem> items) {}
    void addItemToList(List<LibraryItem> items, LibraryItem item) {}
    void removeItemFromList(List<LibraryItem> items, LibraryItem item) {}
    void sortItemsByPublicationDate(List<LibraryItem> items) {}
    void findMostPopularGenre(List<LibraryItem> items) {}
    void calculateAveragePageCount(List<Book> books) {}
    void listMonthlyMagazines(List<Magazine> magazines) {}
    void listItemsByCondition(List<LibraryItem> items, ItemCondition condition) {}
}
