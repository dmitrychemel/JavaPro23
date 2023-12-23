package homework_2023_12_11.task2;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {

    }

    public static void printMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("KEY: " + entry.getKey() + " VALUE: " + entry.getValue());
        }
    }

    public static Set<String> findKeysByValue(Map<String, String> map, String value) {
        Set<String> keysByValue = new HashSet<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                keysByValue.add(entry.getKey());
            }
        }

        return keysByValue;
    }

    public static Map<String, String> mergeMapsIfUniqueKeys(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> mergeMap = new HashMap<>(map1);

        for (Map.Entry<String, String> entry : map2.entrySet()) {
            if (!mergeMap.containsKey(entry.getKey())) {
                mergeMap.put(entry.getKey(), entry.getValue());
            }
        }

        return mergeMap;
    }

    public static Map<String, String> invertMap(Map<String, String> map) {
        Map<String, String> invert = new HashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            invert.put(entry.getValue(), entry.getKey());
        }

        return invert;
    }

    public static int countUniqueValues(Map<String, String> map) {
        List<String> uniqueValues = new ArrayList<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!uniqueValues.contains(entry.getValue())) {
                uniqueValues.add(entry.getValue());
            }
        }
        return uniqueValues.size();
    }

    public static Set<String> findAllValues(Set<Map<Integer, String>> setOfMaps) {
        Set<String> allValues = new HashSet<>();

        for (Map<Integer, String> element : setOfMaps) {
            for (Map.Entry<Integer, String> entry : element.entrySet()) {
                allValues.add(entry.getValue());
            }
        }

        return allValues;
    }

    public static int sumAllKeys(Set<Map<Integer, String>> setOfMaps) {
        int sum = 0;
        for (Map<Integer, String> element : setOfMaps) {
            for (Integer entry : element.keySet()) {
                sum += entry;
            }
        }

        return sum;
    }

    public static boolean containsValue(Set<Map<Integer, String>> setOfMaps, String value) {

        for (Map<Integer, String> element : setOfMaps) {
            for (String entry : element.values()) {
                if (value.equals(entry)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static Set<String> findAllStringsWithChar(Set<Map<Character, Set<String>>> complexSet, char c) {
        Set<String> allStringsWithChar = new HashSet<>();

        for (Map<Character, Set<String>> element : complexSet) {
            for (Set<String> entry : element.values()) {
                for (String word : entry) {
                    if (word.charAt(0) == c) {
                        allStringsWithChar.add(word);
                    }
                }
            }
        }

        return allStringsWithChar;
    }

    public static Map<Character, Integer> countStringOccurrences(Set<Map<Character, Set<String>>> complexSet) {
        Map<Character, Integer> countString = new HashMap<>();

        for (Map<Character, Set<String>> element : complexSet) {
            for (Map.Entry<Character, Set<String>> entry : element.entrySet()) {
                int count = 0;
                for (String word : entry.getValue()) {
                    if (entry.getKey() == word.charAt(0)) {
                        count++;
                    }
                }
                countString.put(entry.getKey(), count);
            }
        }

        return countString;
    }
}
