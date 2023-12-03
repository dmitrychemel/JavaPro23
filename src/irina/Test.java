package irina;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Book book = new Book("Name", 1999);
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));

        System.out.println(book);
    }
}
