package homework_2024_02_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MathUtils {
    // оставил как и было
    public static int calculateSum(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int num : numbers) {
            list.add(num);
        }
        return calculateSum(list);
    }
    
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }

}
