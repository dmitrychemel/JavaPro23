package homework_2023_12_06.task2;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task2 {
//    ***Создайте HashMap<Integer, String>, представляющий
//    "ID-имя пользователя". Используйте цикл для фильтрации
//    пользователей с ID больше 100 и копируйте их в TreeMap.
    public static final Faker FAKER = new Faker();
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            map.put(FAKER.number().numberBetween(50,165), FAKER.name().firstName());
        }
        System.out.println(map);
        System.out.println(filterById(map));
    }

    public static TreeMap<Integer, String> filterById(Map<Integer, String> map) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if(entry.getKey() > 100) {
                treeMap.put(entry.getKey(), entry.getValue());
            }
        }

        return treeMap;
    }
}
