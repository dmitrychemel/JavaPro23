package homework_2023_12_13;

import java.util.*;

public class Task8 {
    //    List<String> перебрать и собрать все возможные комбинации стрингов без повторений
    public static void main(String[] args) {

    }

    public static List<String> stringCombination(List<String> list) {
        List<String> combinationList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>(list);
        stack.addAll(list);

        while (stack.isEmpty()) {
            while(queue.isEmpty()) {
                sb.append(stack.peek()).append(", ").append(queue.peek());
                if(!combinationList.contains(sb.toString())) {
                    combinationList.add(sb.toString());
                    stack.pop();
                    queue.poll();
                }
                sb.delete(0,sb.length());
            }
        }

        return combinationList;
    }
}
