package homework_11_12_2023.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TaskPalindrome {

    public static void main(String[] args) {
        String word = "привет"; // тевирп
        System.out.println(isPalindrome(word));
    }

    public static boolean isPalindrome(String word) {
        List<Character> characterList = new ArrayList<>();
        for (Character chars : word.toCharArray()) {
            characterList.add(chars);
        }

//        ListIterator<Character> forward = characterList.listIterator();
//        ListIterator<Character> backward = characterList.listIterator(characterList.size());
//
//        while (forward.hasNext() && backward.hasPrevious()) {
//            char first = forward.next();
//            char end = backward.previous();
//
//            if (first != end) {
//                return false;
//            }
//        }
//
//        return true;

        ListIterator<Character> iterator = characterList.listIterator(characterList.size());

        StringBuilder temp = new StringBuilder();
        while(iterator.hasPrevious()) {
            temp.append(iterator.previous());
        }

        return word.equals(temp.toString());
    }
}
