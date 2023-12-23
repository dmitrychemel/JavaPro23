package homework_2023_12_06.task1;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
//    **Создайте HashMap<String, Integer>, заполните его парами
//    "имя-возраст". Используйте цикл for-each для удвоения возраста каждого человека.
    public static final Faker FAKER = new Faker();
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(FAKER.name().firstName(), FAKER.number().numberBetween(18,65));
        }

        System.out.println(map);
        System.out.println(doubleAge(map));
    }

    public static Map<String, Integer> doubleAge(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            entry.setValue(entry.getValue() * 2);
        }

        return map;
    }
}
