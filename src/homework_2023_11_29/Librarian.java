package homework_2023_11_29;

import java.util.List;

public class Librarian implements Searchable {
    private String name;
    private String employeeId;
    private List<LibraryItem> managedItems;

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
