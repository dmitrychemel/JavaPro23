package lesson_29_11_2023;

import java.util.List;

public class LibraryCatalogue implements Searchable {
    private List<Book> books;
    private List<Magazine> magazines;

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
