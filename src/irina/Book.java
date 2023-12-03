package irina;

public class Book {
    private String name;
    private int publication;

    public Book(String name, int publication) {
        this.name = name;
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", publication=" + publication +
                '}';
    }
}
