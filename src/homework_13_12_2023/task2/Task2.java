package homework_13_12_2023.task2;

import java.util.Stack;

public class Task2 {
//    Реализуйте функцию, которая использует Stack<String> для реверса строки.
//    public static String reverse(String str)

    public static void main(String[] args) {
        System.out.println(reverse("Hello"));

    }

    public static String reverse(String str) {
        char[] characters = str.toCharArray();

        Stack<String> stack = new Stack<>();
        for (char chars : characters) {
            stack.push(String.valueOf(chars));
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
