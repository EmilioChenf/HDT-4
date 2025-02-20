package ht4.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<T> extends AbstractStack<T> {
    private final ArrayList<T> items = new ArrayList<>();

    @Override
    public void push(T item) {
        items.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.remove(items.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.get(items.size() - 1);
    }

    @Override
    public int size() {
        return items.size();
    }
}
