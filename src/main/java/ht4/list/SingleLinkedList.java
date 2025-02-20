package ht4.list;

public class SingleLinkedList<T> implements IList<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        if (index == 0) {
            T data = head.data;
            head = head.next;
            return data;
        }

        Node<T> current = head;
        Node<T> previous = null;
        int count = 0;

        while (current != null) {
            if (count == index) {
                assert previous != null;
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
            count++;
        }

        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
    }

    @Override
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        Node<T> current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            current = current.next;
            count++;
        }

        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
