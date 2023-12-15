package homework_13_12_2023.task1;

import java.util.LinkedList;

public class StackExp<T> implements Stack23<T> {
    private LinkedList<T> stack;

    public StackExp() {
        this.stack = new LinkedList<>();
    }

    @Override
    public void put(T element) {
        stack.add(element);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public T get() {
        T obj = stack.getLast();
        stack.removeLast();

        return obj;
    }

    @Override
    public T peek() {
        return stack.getLast();
    }
}
