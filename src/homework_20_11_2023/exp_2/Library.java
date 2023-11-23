package homework_20_11_2023.exp_2;

public class Library {
    private String name;
    private String address;
    private Librarian[] listLibrarians;

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        listLibrarians = new Librarian[0];
    }

    public Librarian[] getListLibrarians() {
        return listLibrarians;
    }

    private void setListLibrarians(Librarian[] listLibrarians) {
        this.listLibrarians = listLibrarians;
    }

    public void addLibrarian(Librarian librarian) {
        Librarian[] newLibrarians = new Librarian[listLibrarians.length + 1];
        System.arraycopy(listLibrarians, 0, newLibrarians, 0, listLibrarians.length - 1);
        newLibrarians[listLibrarians.length] = librarian;
        setListLibrarians(newLibrarians);
    }

    public Librarian searchLibrarian(String name) {
        for (int i = 0; i < listLibrarians.length; i++) {
            if (listLibrarians[i].getName().equals(name)) {
                return listLibrarians[i];
            }
        }
        return null;
    }
}
