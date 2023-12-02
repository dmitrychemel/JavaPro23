package homework_27_11_2023.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(11, 11, 99, 15, 16, 17, 18, 19, 20, 21));
        allMethods(list);

    }

    public static void allMethods(List<Integer> list) {
        System.out.println("Cреднее значение " + middleArithmetic(list));
        System.out.println("Медиана " + median(list));
        System.out.println("Стандартное отклонение " + standardDeviation(list));
    }

    public static double middleArithmetic(List<Integer> list) {
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }

        return (double) sum / list.size();
    }

    public static double median(List<Integer> list) {
        Collections.sort(list);
        if (list.size() % 2 != 0) {
            return list.get(list.size() / 2 + 1);
        } else {
            return (double) (list.get(list.size() / 2) + list.get(list.size() / 2 + 1)) / 2;
        }
    }

    public static double standardDeviation(List<Integer> list) {

        double middleArithmetic = middleArithmetic(list);
        double sum = 0;
        for (Integer num : list) {
            sum += (num - middleArithmetic) * (num - middleArithmetic);
        }

        return Math.sqrt(sum / list.size());
    }
}
