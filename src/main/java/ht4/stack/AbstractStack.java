package ht4.stack;

public abstract class AbstractStack<T> implements IStack<T> {
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
