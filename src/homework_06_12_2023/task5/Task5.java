package homework_06_12_2023.task5;

import com.github.javafaker.Faker;
import homework_06_12_2023.task3.User;

import java.util.HashMap;
import java.util.Map;

//        **Создайте два HashMap<String, User> (класс User как в задаче 3) и
//        объедините их в один, удалив дубликаты пользователей.
public class Task5 {
    public static final Faker FAKER = new Faker();
    public static void main(String[] args) {
        Map<String, User> map = new HashMap<>();

        map.put("Key 1", new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,28), FAKER.name().lastName()));
        map.put("Key 2", new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,28), FAKER.name().lastName()));
        map.put("Key 3", new User("Anton", 24, "Antonov"));

        Map<String, User> map2 = new HashMap<>();

        map2.put("Key 4", new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,28), FAKER.name().lastName()));
        map2.put("Key 5", new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,28), FAKER.name().lastName()));
        map2.put("Key 6", new User("Anton", 24, "Antonov"));

        printMap(uniqueMap(map, map2));
    }

    public static void printMap(Map<String, User> map) {
        for(Map.Entry<String, User> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    public static Map<String, User> uniqueMap(Map<String, User> first, Map<String, User> second) {

        for(Map.Entry<String, User> entry : second.entrySet()) {
            if(!first.containsValue(entry.getValue())) {
                first.put(entry.getKey(), entry.getValue());
            }
        }

        return first;
    }
}
