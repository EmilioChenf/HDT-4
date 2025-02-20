package ht4.stack;

import ht4.list.IList;
import java.util.EmptyStackException;

public class ListStack<T> extends AbstractStack<T> {
    private final IList<T> items;

    public ListStack(IList<T> list) {
        this.items = list;
    }

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
