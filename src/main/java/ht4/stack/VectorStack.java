package ht4.stack;

import java.util.Vector;
import java.util.EmptyStackException;

public class VectorStack<T> extends AbstractStack<T> {
    private Vector<T> items = new Vector<>();

    @Override
    public void push(T item) {
        items.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return items.remove(items.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return items.lastElement();
    }

    @Override
    public int size() {
        return items.size();
    }
}
