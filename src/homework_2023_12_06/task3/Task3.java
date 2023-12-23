package homework_2023_12_06.task3;

import com.github.javafaker.Faker;

import java.util.Map;
import java.util.TreeMap;

public class Task3 {
//    3**Создайте класс User с полями name и age, реализующий Comparable
//    для сортировки по возрасту. Используйте TreeMap<User, String>
//    для хранения информации о пользователях и переберите его, чтобы напечатать имена.
    public static final Faker FAKER = new Faker();
    public static void main(String[] args) {
        Map<User, String> userStringMap = new TreeMap<>();

        User user1 = new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,30), FAKER.name().lastName());
        User user2 = new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,30), FAKER.name().lastName());
        User user3 = new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,30), FAKER.name().lastName());
        User user4 = new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,30), FAKER.name().lastName());
        userStringMap.put(user1, user1.getLastName());
        userStringMap.put(user2, user2.getLastName());
        userStringMap.put(user3, user3.getLastName());
        userStringMap.put(user4, user4.getLastName());

        System.out.println(userStringMap);
        System.out.print("Names: ");
        for (User human : userStringMap.keySet()) {
            System.out.print(human.getFirstName() + " ");
        }
    }
}

