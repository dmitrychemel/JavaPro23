package homework_2023_11_27.task1;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Integer[] arary = {1,2,2,2,3,3,4,4,4,4,4,5,5,6};

        Map<Integer,Integer> count = new HashMap<>();

        for(Integer e: arary) {
            count.put(e, count.getOrDefault(e, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : count.entrySet()) {
            System.out.println("Значение " + e.getKey() + " - повтор: " + e.getValue());
        }
    }
}
