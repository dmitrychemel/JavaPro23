package marat.map;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class Task23 {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            map.put(faker.number().numberBetween(16,30), faker.name().name());
        }



//        map.put(1234, "Катя");
//        map.put(121, "Лена");
//        map.put(1235, "Катя");
//
//        System.out.println(map);
//        map.put(1234, "Ирина");
//        System.out.println(map);
//        map.put(1234, " ");
//        System.out.println(map);

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key is " + entry.getKey() + " Value is " +entry.getValue());
        }
    }

}
