package homework_13_12_2023.task6;

import java.util.HashMap;
import java.util.Map;

public class Task6 {
//    - Написать функцию, которая выполняет факторизацию(погуглить) числа и возвращает
//    ее в виде Map, где ключ - это простой множитель, а значение - степень этого множителя.
//    public Map<Integer, Integer> primeFactorization(int number)

    public static void main(String[] args) {

        Map<Integer, Integer> map = primeFactorization(36);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Prime number - " + entry.getKey() + ", degree - " + entry.getValue());
        }
    }

    public static Map<Integer, Integer> primeFactorization(int num) {
        Map<Integer, Integer> newMap = new HashMap<>();

        int primeNum = 2;

        while (num > 1) {
            if(num % primeNum == 0) {
                int count = 0;
                while (num % primeNum == 0) {
                    num /= primeNum;
                    count++;
                }
                newMap.put(primeNum, count);
            }
            primeNum++;
        }

        return newMap;
    }

}
