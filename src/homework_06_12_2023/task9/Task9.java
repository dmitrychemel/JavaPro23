package homework_06_12_2023.task9;

import java.util.*;

public class Task9 {
//    **Создайте HashMap<String, List<Integer>>, где ключ - это имя, а значение - список оценок.
//    Используйте TreeMap<Integer, List<String>> для создания отображения
//    "средняя оценка - список студентов с этой оценкой".
    public static void main(String[] args) {

        Map<String, List<Integer>> mapMarks = new HashMap<>();
        mapMarks.put("Irina", new ArrayList<>(Arrays.asList(9,9,9,9,9)));
        mapMarks.put("Vlad", new ArrayList<>(Arrays.asList(7,7,7,7)));
        mapMarks.put("Maks", new ArrayList<>(Arrays.asList(6,6,8,8)));
        mapMarks.put("Stepan", new ArrayList<>(Arrays.asList(5,5,7,7)));
        mapMarks.put("Igor", new ArrayList<>(Arrays.asList(5,5,7,7)));

        System.out.println(averages(mapMarks));
    }

    public static TreeMap<Integer, List<String>> averages(Map<String, List<Integer>> map) {

        TreeMap<Integer, List<String>> treeMap = new TreeMap<>();

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            treeMap.computeIfAbsent(averageMark(entry.getValue()), k -> new ArrayList<>()).add(entry.getKey());
        }

        return treeMap;
    }

    public static int averageMark(List<Integer> marks) {
        int sum = 0;
        for (Integer number : marks) {
            sum += number;
        }

        return sum/marks.size();
    }
}
