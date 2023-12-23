package homework_2023_12_13.task4;

import java.util.LinkedList;
import java.util.Queue;

public class Task4 {
//    - Реализуйте функцию, которая осуществляет циклический сдвиг элементов в Queue<String>.
//    public static void rotate(Queue<String> queue, int k) {

        public static void main(String[] args) {
            Queue<String> queue = new LinkedList<>();
            queue.add("1");
            queue.add("2");
            queue.add("3");
            queue.add("4");
            queue.add("5");
            queue.add("6");

            System.out.println(rotate(queue, 13));
        } //   1 2 3 4 5

    public static Queue<String> rotate(Queue<String> queue, int k) {
       int rotateCount = queue.size() - k % queue.size();

        for (int i = 0; i < rotateCount; i++) {
            String temp = queue.remove();
            queue.add(temp);
        }

        return queue;
    }
}
