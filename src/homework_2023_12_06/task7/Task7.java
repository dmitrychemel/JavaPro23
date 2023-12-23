package homework_2023_12_06.task7;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task7 {
//    **Создайте HashMap<String, Integer>, переберите её и создайте List<Integer>,
//    содержащий все значения HashMap.
public static final Faker FAKER = new Faker();
    public static void main(String[] args) {
        Map<String, Integer> firstMap = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            firstMap.put(FAKER.name().title(), FAKER.number().randomDigit());
        }
        System.out.println(firstMap);

        System.out.println(listValue(firstMap));
    }

    public static List<Integer> listValue(Map<String, Integer> map) {
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }
}
