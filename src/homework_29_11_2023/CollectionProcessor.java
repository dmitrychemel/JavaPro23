package homework_29_11_2023;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.*;

public class CollectionProcessor {
    public static void main(String[] args) {
        List<LibraryItem> libraryItemList = new ArrayList<>();

        libraryItemList.add(new Book("Война мир", "Толстой", Genre.FICTION, BookStatus.AVAILABLE, LocalDate.of(1009, 7, 22), 600));
        libraryItemList.add(new Book("Человек", "Антон Григорий", Genre.FANTASY, BookStatus.LOST, LocalDate.of(2000, 9, 25), 100));
        libraryItemList.add(new Book("Робин Гуд", "Василий", Genre.NON_FICTION, BookStatus.UNDER_REPAIR, LocalDate.of(2096, 10, 15), 300));
        libraryItemList.add(new Magazine("Робин Гуд", "Василий", Genre.NON_FICTION, 15, LocalDate.of(2096, 10, 15), false, ItemCondition.NEW));

        printAllItems(libraryItemList);
        System.out.println();
        System.out.println("new method listItemsByGenre:");
        listItemsByGenre(libraryItemList, Genre.FANTASY);

        System.out.println();
        System.out.println("new method sortByTitle:");
        sortByTitle(libraryItemList);

        System.out.println();
        System.out.println("new method findOldestItem:");
        System.out.println(findOldestItem(libraryItemList));

        System.out.println();
        System.out.println("new method groupItemsByAuthor:");
        groupItemsByAuthor(libraryItemList);

        System.out.println();
        System.out.println("new method groupItemsByAuthor2 without Map:");
        groupItemsByAuthor2(libraryItemList);

        System.out.println();
        System.out.println("new method listItemsForRepair:");
        System.out.println(listItemsForRepair(libraryItemList));

        System.out.println();
        System.out.println("new method displayItemCount:");
        displayItemCount(libraryItemList);

        System.out.println();
        System.out.println("new method sortItemsByPublicationDate:");
        sortItemsByPublicationDate(libraryItemList);
    }

    static void printInfo(LibraryItem item) {

        System.out.println(item);
    }


    static void printAllItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            printInfo(item);
        }
    }

    static void listItemsByGenre(List<LibraryItem> items, Genre genre) {
        for (LibraryItem item : items) {
            if (item.getGenre().equals(genre)) {
                printInfo(item);
            }
        }
    }

    static void sortByTitle(List<LibraryItem> items) {
        items.sort(Comparator.comparing(LibraryItem::getTitle));
        printAllItems(items);
    }

    static void filterByAuthor(List<LibraryItem> items, String author) {
        for (LibraryItem item : items) {
            if (item.getAuthor().equals(author)) {
                printInfo(item);
            }

        }
    }

    static int countItemsByStatus(List<LibraryItem> items, BookStatus status) {
        int count = 0;
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                if (((Book) item).getStatus().equals(status)) {
                    count++;
                }
            }
        }
        return count;
    }

    static void updateStatus(List<LibraryItem> items, BookStatus oldStatus, BookStatus newStatus) {
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                Book temp = (Book) item;
                if (temp.getStatus().equals(oldStatus)) {
                    temp.setStatus(newStatus);
                }
            }
        }
    }

    static List<LibraryItem> listAvailableItems(List<LibraryItem> items) {
        List<LibraryItem> listAvailableItems = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                Book temp = (Book) item;
                if (temp.isAvailable()) {
                    listAvailableItems.add(temp);
                }
            }
        }

        return listAvailableItems;
    }

    static LibraryItem findOldestItem(List<LibraryItem> items) {
        LocalDate current = LocalDate.now(); // 1998
        LibraryItem oldestItem = null; // mag 2
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                Book temp = (Book) item;
                if (temp.getPublishDate().isBefore(current)) {
                    current = temp.getPublishDate();
                    oldestItem = temp;
                }
            } else {
                Magazine temp = (Magazine) item;
                if (temp.getReleaseDate().isBefore(current)) { // 1998  // mag2
                    current = temp.getReleaseDate();
                    oldestItem = temp;
                }
            }
        }

        return oldestItem;
    }

    static void groupItemsByAuthor(List<LibraryItem> items) {
        Map<String, List<LibraryItem>> mapAuthor = new HashMap<>();

        for (LibraryItem item : items) {
            mapAuthor.computeIfAbsent(item.getAuthor(), k -> new ArrayList<>()).add(item);
        }

        System.out.println(mapAuthor);
    }

    static void groupItemsByAuthor2(List<LibraryItem> items) {
        List<String> author = new ArrayList<>();
        for (LibraryItem item : items) {
            if (!author.contains(item.getAuthor())) {
                author.add(item.getAuthor());
            }
        }

        for (String s : author) {
            System.out.print("Автор: " + s + " Книги: ");
            for (LibraryItem item : items) {
                if (s.equals(item.getAuthor())) {
                    System.out.print(item.getTitle() + " ");
                }
            }
            System.out.println();
        }
    }

    static List<LibraryItem> listItemsForRepair(List<LibraryItem> items) {
        List<LibraryItem> listForRepair = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                Book temp = (Book) item;
                if (temp.getStatus().equals(BookStatus.UNDER_REPAIR)) {
                    listForRepair.add(item);
                }
            }
        }

        return listForRepair;
    }

    static void displayItemCount(List<LibraryItem> items) {
        System.out.println("Число предметов " + items.size());
    }

    static List<LibraryItem> listBorrowedItemsByUser(List<LibraryItem> items, User user) {
        List<LibraryItem> listBorrowedByUser = new ArrayList<>();
        for (LibraryItem item : user.getBorrowedItems()) {
            if (items.contains(item)) {
                listBorrowedByUser.add(item);
            }
        }

        return listBorrowedByUser;
    }

    static void removeLostItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                Book temp = (Book) item;
                if (temp.getStatus().equals(BookStatus.LOST)) {
                    items.remove(item);
                }
            }
        }
    }

    static void addItemToList(List<LibraryItem> items, LibraryItem item) {
        items.add(item);
    }

    static void removeItemFromList(List<LibraryItem> items, LibraryItem item) {
        items.remove(item);
    }

    static void sortItemsByPublicationDate(List<LibraryItem> items) {
        Collections.sort(items, (o1, o2) -> {
            if (o1 instanceof Book && o2 instanceof Book) {
                return ((Book) o1).compareTo((Book) o2);
            } else if (o1 instanceof Magazine && o2 instanceof Magazine) {
                return ((Magazine) o1).compareTo((Magazine) o2);
            } else if (o1 instanceof Book) {
                return 1;
            } else if (o2 instanceof Book) {
                return -1;
            }
            return 0;
        });

        printAllItems(items);
    }

    static Genre findMostPopularGenre(List<LibraryItem> items) {
        List<Genre> genres = new ArrayList<>();

        for (LibraryItem item: items) {
            if(!genres.contains(item.getGenre())) {
                genres.add(item.getGenre());
            }
        }

        int countGenres = 1;
        Genre popular = null;

        for (Genre genre: genres) {
            int temp = 1;
            for (LibraryItem item: items) {
                if(genre.equals(item.getGenre())) {
                    temp++;
                }
            }
            if(countGenres < temp) {
                countGenres = temp;
                popular = genre;
            }
        }

        return popular;
    }

    static void calculateAveragePageCount(List<Book> books) {
        int sum = 0;
        for (Book book : books) {
            sum += book.getPageCount();
        }
    }

    static List<Magazine> listMonthlyMagazines(List<Magazine> magazines) {
        List<Magazine> monthlyMagazines = new ArrayList<>();
        for (Magazine magazine : magazines) {
            if(magazine.isMonthly()) {
                monthlyMagazines.add(magazine);
            }
        }

        return monthlyMagazines;
    }

    static List<LibraryItem> listItemsByCondition(List<LibraryItem> items, ItemCondition condition) {
        List<LibraryItem> listByCondition = new ArrayList<>();

        for (LibraryItem item: items) {
            if(item instanceof Magazine) {
                Magazine temp = (Magazine) item;
                if(temp.getItemCondition().equals(condition)) {
                    listByCondition.add(temp);
                }
            }
        }

        return listByCondition;
    }
}
