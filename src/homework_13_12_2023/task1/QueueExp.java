package homework_13_12_2023.task1;

import java.util.LinkedList;

public class QueueExp<T> implements Queue23<T> {

    private LinkedList<T> queue;

    public QueueExp() {
        this.queue = new LinkedList<>();
    }
    @Override
    public void put(T element) {
        queue.add(element);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public T get() {
        T obj = queue.getFirst();
        queue.removeFirst();

        return obj;
    }

    @Override
    public T peek() {
        return queue.getFirst();
    }
}
