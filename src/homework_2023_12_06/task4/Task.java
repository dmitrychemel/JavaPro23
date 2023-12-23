package homework_2023_12_06.task4;

import com.github.javafaker.Faker;
import homework_2023_12_06.task3.User;

import java.util.Map;
import java.util.TreeMap;

public class Task {
    public static final Faker FAKER = new Faker();
    public static void main(String[] args) {
        NameComparator nameComparator = new NameComparator();
        Map<User, String> userStringMap = new TreeMap<>(nameComparator);

        User user1 = new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,30), FAKER.name().lastName());
        User user2 = new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,30), FAKER.name().lastName());
        User user3 = new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,30), FAKER.name().lastName());
        User user4 = new User(FAKER.name().firstName(), FAKER.number().numberBetween(18,30), FAKER.name().lastName());
        userStringMap.put(user1, user1.getLastName());
        userStringMap.put(user2, user2.getLastName());
        userStringMap.put(user3, user3.getLastName());
        userStringMap.put(user4, user4.getLastName());
        userStringMap.put(new User("aaa", 21, "bbbb"), "bbbb");

        System.out.println(userStringMap);
    }
}
