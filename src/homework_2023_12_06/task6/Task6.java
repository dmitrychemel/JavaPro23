package homework_2023_12_06.task6;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task6 {
//    **Создайте HashMap<Integer, String> и перепишите его в TreeMap<String, Integer>,
//    инвертируя ключи и значения.

    public static final Faker FAKER = new Faker();
    public static void main(String[] args) {
        Map<Integer, String> firstMap = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            firstMap.put(FAKER.number().randomDigit(), FAKER.name().title());
        }

        System.out.println("Искходные данные - " + firstMap);
        System.out.println("Использование метода - " + invertKeyToValue(firstMap));

    }

    public static Map<String, Integer> invertKeyToValue(Map<Integer, String> map) {
        Map<String, Integer> invertMap = new TreeMap<>();

        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            invertMap.put(entry.getValue(), entry.getKey());
        }

        return invertMap;
    }
}
