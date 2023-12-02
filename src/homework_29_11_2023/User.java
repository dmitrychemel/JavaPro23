package homework_29_11_2023;

import java.util.List;

public class User implements Searchable{

    private String name;
    private String id;
    private List<LibraryItem> borrowedItems;

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    @Override
    public List<LibraryItem> findByTitle(String title) {
        return null;
    }

    @Override
    public List<LibraryItem> findByAuthor(String author) {
        return null;
    }

    @Override
    public List<LibraryItem> findByGenre(Genre genre) {
        return null;
    }
}
