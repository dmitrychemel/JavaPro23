package homework_27_11_2023.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("Капуста", "Машина", "Капуста","Капуста","Капуста", "Машина", "Картошка"));
        System.out.println(repeatString(stringList, 3));
    }

    public static List<String> repeatString(List<String> list, int countUp) {
        List<String> repatList = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(i).equals(list.get(j))){
                    count++;
                }
            }
            if(count > countUp & !repatList.contains(list.get(i))) {
                repatList.add(list.get(i));
            }
        }

        return repatList;
    }
}
