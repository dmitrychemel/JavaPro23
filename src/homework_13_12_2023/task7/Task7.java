package homework_13_12_2023.task7;

import java.util.HashMap;
import java.util.Map;

public class Task7 {
//    - Написать функцию, которая проверяет, являются ли две строки анаграммами друг друга.
//    public boolean areAnagrams(String str1, String str2) {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Лунь","нуль");
        map.put("Хомяк","коряк");
        map.put("Воз","зов");
        map.put("Рим","Риб");

        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(areAnagrams(entry.getKey(), entry.getValue()));
        }
    }

    public static boolean areAnagrams(String str1, String str2) {
        Map<Character, Integer> mapFirst = getLetter(str1);
        Map<Character, Integer> mapSecond = getLetter(str2);

        return mapFirst.equals(mapSecond);
    }

    private static Map<Character, Integer> getLetter(String word) {
        Map<Character, Integer> mapLetter = new HashMap<>();
        char[] charsWord = word.toLowerCase().toCharArray();

        for (Character chars : charsWord) {
            mapLetter.put(chars, mapLetter.getOrDefault(chars, 0) + 1);
        }

        return mapLetter;
    }
}
