package homework_13_12_2023;

import java.util.List;
import java.util.Stack;

public class Task9 {
    //    List<List<Integer>> - найти список с максимальной суумой элементов
    public static void main(String[] args) {

    }

    public static List<Integer> maxSumList(List<List<Integer>> list) {
        Stack<List<Integer>> stack = new Stack<>();
        stack.addAll(list);

        List<Integer> max = null;
        int maxSum = 0;

        while (stack.isEmpty()) {
            int count = 0;
            for (Integer num : stack.peek()) {
                count += num;
            }

            if (count > maxSum) {
                max = stack.pop();
                maxSum = count;
            }
        }

        return max;
    }
}
