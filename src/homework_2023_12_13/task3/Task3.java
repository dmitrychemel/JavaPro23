package homework_2023_12_13.task3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Task3 {
//    Печать элементов Queue в обратном порядке
//    public static void printInReverse(Queue<String> queue)

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>(Arrays.asList("Hello", "How"));
        printInReverse(queue);
    }

    public static void printInReverse(Queue<String> queue) {
        while(!queue.isEmpty()){
            char[] characters = queue.poll().toCharArray();

            Stack<String> stack = new Stack<>();
            for (char chars : characters) {
                stack.push(String.valueOf(chars));
            }

            StringBuilder sb = new StringBuilder();
            while(!stack.empty()) {
                sb.append(stack.pop());
            }

            System.out.print(sb + " ");
        }
    }
}
