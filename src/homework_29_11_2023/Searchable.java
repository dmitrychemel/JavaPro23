package homework_29_11_2023;

import java.util.List;

public interface Searchable {

    List<LibraryItem> findByTitle(String title);
    List<LibraryItem> findByAuthor(String author);
    List<LibraryItem> findByGenre(Genre genre);
}
