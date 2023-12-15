package homework_13_12_2023.task5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Task5 {
//    Инвертируйте Map<String, String>, чтобы ключи стали значениями, а значения ключами.
//    public static Map<String, String> invert(Map<String, String> map)

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Key 1", "Value 1");
        map.put("Key 2", "Value 2");
        map.put("Key 3", "Value 3");
        map.put("Key 4", "Value 4");
        map.put("Key 5", "Value 5");

        System.out.println(invert(map));

    }

    public static Map<String, String> invert(Map<String, String> map) {
        Map<String, String> newMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            queue.add(entry.getKey());
            queue.add(entry.getValue());
        }

        while (!queue.isEmpty()) {
            String key = queue.poll();
            String value = null;
            if (!queue.isEmpty()) {
                value = queue.poll();
            }
            newMap.put(value, key);
        }

        return newMap;
    }

}
