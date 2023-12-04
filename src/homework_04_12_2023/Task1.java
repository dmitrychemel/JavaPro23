package homework_04_12_2023;

import java.util.*;

public class Task1 {
//    HashMap<Integer, List<String>>: Для каждого ключа выведите все строки из соответствующего списка, которые начинаются с гласной буквы.

    public static void main(String[] args) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("ddd", "dd");
        stringMap.put("ddddd", "ddddd");
        stringMap.put("dd", "dd");
        stringMap.put("d", "dd");
        stringMap.put("dddd", "dd");

        Map<String, Integer> map = new HashMap<>();
        map.put("America", 1);
        map.put("Afgan", 10);
        map.put("Belarus", 4);
        map.put("Poland", 7);

        Map<Integer, Integer> integerMap = new HashMap<>();
        integerMap.put(1, 12);
        integerMap.put(2, 1);
        integerMap.put(3, 18);
        integerMap.put(4, 9);
        integerMap.put(5, 6);

        Map<Integer, List<String>> newMap = new HashMap<>();
        newMap.put(12, new ArrayList<>(Arrays.asList("Hello", "Mom", "Anna")));
        newMap.put(1, new ArrayList<>(Arrays.asList("Ulo", "Uno", "Gym")));
        newMap.put(7, new ArrayList<>(Arrays.asList("Tut", "Home", "Eee")));

        System.out.println("char A sum Value - " + countByFirstChar(map, 'A'));

        System.out.println("Repeat Key and Value - " + repeatKeyValue(stringMap));

        searchByFirstChar(newMap);
        searchTheBiggestValue(integerMap);

    }
    // HashMap<Integer, List<String>>: Для каждого ключа выведите все строки из соответствующего списка, которые начинаются с гласной буквы.
    // HashMap<String, String>: Определите, содержит ли HashMap такую пару ключ-значение, где ключ является обратной строкой значения (например, ключ "abc", значение "cba").


    static void searchTheBiggestValue(Map<Integer, Integer> integerMap) {
        int value = Integer.MIN_VALUE;
        int key = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> element : integerMap.entrySet()) {
            if(element.getValue() > value) {
                value = element.getValue();
                key = element.getKey();
            }
        }

        System.out.println("The biggest value - KEY: " + key + ", VALUE: " + value);
    }

    static void searchByFirstChar(Map<Integer, List<String>> newMap) {
        for (Map.Entry<Integer, List<String>> element : newMap.entrySet()) {
            System.out.print("Key " + element.getKey() + " : ");
            for (String str : element.getValue()) {
                if (checkByFirstChar(str)) {
                    System.out.print(str + " ");
                }
            }
            System.out.println();
        }
    }

    static boolean checkByFirstChar(String str) {
        List<Character> characterList = new ArrayList<>(Arrays.asList('E', 'U', 'I', 'O', 'A', 'e', 'u', 'i', 'o', 'a'));
        if (characterList.contains(str.charAt(0))) {
            return true;
        }
        return false;
    }

    static int repeatKeyValue(Map<String, String> map) {
        int count = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().length() == entry.getValue().length()) {
                count++;
            }
        }
        return count;
    }

    static int countByFirstChar(Map<String, Integer> map, char ch) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().charAt(0) == ch) {
                sum += entry.getValue();
            }
        }

        return sum;
    }
}
