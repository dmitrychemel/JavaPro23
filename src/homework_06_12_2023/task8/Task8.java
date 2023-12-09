package homework_06_12_2023.task8;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task8 {
//    **Создайте TreeMap<String, Integer> и переберите его, создавая HashMap<Integer, String>,
//    включающий только те записи, где значение больше 50.

    public static final Faker FAKER = new Faker();
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < 4; i++) {
            map.put(FAKER.name().title(), FAKER.number().numberBetween(40, 60));
        }

        System.out.println("Исходное - " + map);
        System.out.println("Метод invertKeyAndValue - " + invertKeyAndValue(map));
    }

    public static Map<Integer, String> invertKeyAndValue (Map<String, Integer> map) {
        Map<Integer, String> newMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 50) {
                newMap.put(entry.getValue(), entry.getKey());
            }
        }

        return newMap;
    }
}
