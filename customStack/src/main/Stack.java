package main;

import java.util.EmptyStackException;

public class Stack<T> {
    private int size;
    private Node<T> top;

    public Stack() {

    }

    public void push(T value) {
        Node<T> newNode = new Node(value, null);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T peek() {
        checkStackSize();
        return top.data;
    }

    public T pop() {
        checkStackSize();
        T last = top.data;
        top = top.next;
        size--;
        return last;
    }

    public int size() {
        return size;
    }

    private void checkStackSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}