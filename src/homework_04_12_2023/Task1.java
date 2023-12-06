package homework_04_12_2023;

import java.security.Key;
import java.util.*;

public class Task1 {
//    HashMap<Integer, List<String>>: Для каждого ключа выведите все строки из соответствующего списка, которые начинаются с гласной буквы.

    public static void main(String[] args) {

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("key 1", 12);
        map3.put("key 2", 3);
        map3.put("key 3", 5);

        Map<Integer, List<String>> map4 = new HashMap<>();
        map4.put(12, new ArrayList<>(Arrays.asList("value 1, value 2")));
        map4.put(3, new ArrayList<>(Arrays.asList("value 3, value 4")));
        map4.put(5, new ArrayList<>(Arrays.asList("value 5, value 6")));

        Map<String, String> stringMap2 = new HashMap<>();
        stringMap2.put("asdf", "qwerfsaf");
        stringMap2.put("qwerty", "ytrewq");
        stringMap2.put("gf", "rq");
        stringMap2.put("aaa", "aaa");
        stringMap2.put("rad", "dar");

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
        integerMap.put(1, -12);
        integerMap.put(2, -1);
        integerMap.put(3, -18);
        integerMap.put(4, -9);
        integerMap.put(5, -6);
        integerMap.put(7, -13);

        Map<Integer, List<String>> newMap = new HashMap<>();
        newMap.put(12, new ArrayList<>(Arrays.asList("Hello", "Mom", "Anna")));
        newMap.put(1, new ArrayList<>(Arrays.asList("Ulo", "Uno", "Gym")));
        newMap.put(7, new ArrayList<>(Arrays.asList("Tut", "Home", "Eee")));

        System.out.println("char A sum Value - " + countByFirstChar(map, 'A'));
        System.out.println("Repeat Key and Value - " + repeatKeyValue(stringMap));
        searchByFirstChar(newMap);
        searchTheBiggestValue(integerMap);
        checkReverse(stringMap2);
        System.out.println("New Map<String, String> - " + convertIntegerToString(map3));
        System.out.println("New Map<Integer, Integer> - " + convertListToInteger(newMap));
        valueIsSimple(integerMap);
        keyEqualsValue(map3, map4);


    }

    //HashMap<String, String>: Определите, можно ли преобразовать HashMap в List<String>, где каждый элемент - это конкатенация ключа и значения, так, чтобы все элементы списка были уникальными.

    static void keyEqualsValue(Map<String, Integer> map, Map<Integer, List<String>> map2) {
        for (String entry : map.keySet()) {
            int keyInteger = map.get(entry);
            if (map2.containsKey(keyInteger)) {
                System.out.println("KEY: " + entry + " VALUE: " + map.get(entry) + ", " + map2.get(keyInteger));
            }
        }
    }

    static void valueIsSimple(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (isSimple(entry.getValue())) {
                System.out.println("Value is simple - KEY: " + entry.getKey() + " VALUE: " + entry.getValue());
            }
        }
    }

    static boolean isSimple(int number) {
        if (number >= 0) {
            return false;
        } else if (number == -1 || number == -2) {
            return true;
        }

        for (int i = -2; i > number / 2; i--) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    static Map<Integer, Integer> convertListToInteger(Map<Integer, List<String>> map) {
        Map<Integer, Integer> newMap = new HashMap<>();
        for (Map.Entry<Integer, List<String>> element : map.entrySet()) {
            newMap.put(element.getKey(), calculateLength(element.getValue()));
        }

        return newMap;
    }

    static int calculateLength(List<String> list) {
        int sum = 0;
        for (String string : list) {
            sum += string.length();
        }

        return sum;
    }

    static Map<String, String> convertIntegerToString(Map<String, Integer> map) {
        Map<String, String> newMap = new HashMap<>();
        for (Map.Entry<String, Integer> element : map.entrySet()) {
            newMap.put(element.getKey(), String.valueOf(element.getValue() * 2));
        }

        return newMap;
    }

    static void checkReverse(Map<String, String> map) {
        for (Map.Entry<String, String> element : map.entrySet()) {
            if (isPalindrome(element.getKey(), element.getValue())) {
                System.out.println("Palindrome - KEY: " + element.getKey() + " VALUE: " + element.getValue());
            }
        }
    }

    static boolean isPalindrome(String first, String second) {
//        if (first.length() != second.length()) {
//            return false;
//        }
//        char[] firstChar = first.toCharArray();
//        char[] secondChar = second.toCharArray();
//
//        for (int i = 0; i < firstChar.length; i++) {
//            if (firstChar[i] != secondChar[firstChar.length - i - 1]) {
//                return false;
//            }
//        }

        String reverseFirst = new StringBuilder(first).reverse().toString();

        return reverseFirst.equals(second);
    }

    static void searchTheBiggestValue(Map<Integer, Integer> integerMap) {
        int value = Integer.MIN_VALUE;
        int key = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> element : integerMap.entrySet()) {
            if (element.getValue() > value) {
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
        return characterList.contains(str.charAt(0));
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
