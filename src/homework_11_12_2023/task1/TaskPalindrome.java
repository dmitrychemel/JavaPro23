package homework_11_12_2023.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TaskPalindrome {

    public static void main(String[] args) {
        String word = "texxet";
        System.out.println(isPalindrome(word));
    }

    public static boolean isPalindrome(String word) {
        List<Character> characterList = new ArrayList<>();
        for (Character chars : word.toCharArray()) {
            characterList.add(chars);
        }

        ListIterator<Character> iterator = characterList.listIterator(characterList.size());

        StringBuilder temp = new StringBuilder();
        while(iterator.hasPrevious()) {
            temp.append(iterator.previous());
        }

        return word.equals(temp.toString());
    }
}
