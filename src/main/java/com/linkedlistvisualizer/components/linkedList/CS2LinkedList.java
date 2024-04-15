package com.linkedlistvisualizer.components.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CS2LinkedList<T> implements CS2ListInterface<T>, Iterable<T> {

    private Node<T> head;
    private int size;

    class LinkedListIterator implements Iterator<T> {
        private Node<T> currentNode = head;

        @Override
        public T next() {
            if (hasNext()) {
                T temp = currentNode.data;
                currentNode = currentNode.next;
                return temp;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public boolean hasNext() {
            return (currentNode != null);
        }
    }

    public CS2LinkedList() {
        size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public void printLinkedList() {
        Node<T> running = head;
        while (running != null) {
            System.out.println(running.data);
            running = running.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public void add(T value) {
        Node<T> running = head;
        if (head == null) {
            head = new Node<T>(value, null);
        } else {
            while (running.next != null) {
                running = running.next;
            }
            running.next = new Node<T>(value, null);

        }
        size++;
    }

    @Override
    public T get(int index) {

        Node<T> currentNode = head;
        if (index < 1) {
            return currentNode.data;
        }
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, T value) {
        Node<T> running = head;
        int i = 0;
        if (index > size) {
            throw new IndexOutOfBoundsException("Index is larger than List size!");
        } else {

            if (index < 1) {
                Node<T> newHead = new Node<T>(value, running);
                head = newHead;
            } else {

                while (running != null) {
                    if (i == index - 1) {
                        Node<T> insertNode = new Node<T>(value, running.next);
                        running.next = insertNode;
                    }
                    running = running.next;
                    i++;

                }
            }

            size++;
        }
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean contains(T value) {
        for (T element : this) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {

        int i = 0;
        int result = 0;
        for (T element : this) {
            if (element == value) {
                result = i;
            } else {
                i++;
            }
        }

        if (i == size) {
            throw new IllegalArgumentException("List does not contain value!");
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        if (size < 1) {
            return true;
        }
        return false;
    }

    @Override
    public void removeValue(T value) {
        Node<T> running = head;
        while (running != null) {
            if (running.data == value) {
                head = running.next;
                break;
            } else if (running.next.data == value) {
                Node<T> removeNode = running.next;
                running.next = removeNode.next;
                break;
            } else {
                running = running.next;
            }

        }

        size--;
    }

    @Override
    public void removeIndex(int index) {

        Node<T> running = head;
        int i = 0;
        if (index < 1) {
            head = running.next;
        } else if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        while (running != null) {
            if (i == index - 1) {
                Node<T> removeNode = running.next;
                if (removeNode.next == null) {
                    running.next = null;
                } else {
                    running.next = running.next.next;
                }
                break;
            }
            running = running.next;
            i++;
        }
        size--;

    }

    @Override
    public void set(int index, T value) {
        Node<T> running = head;
        int i = 0;
        if (index < 1) {
            running.data = value;
        } else if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        while (running != null) {
            if (i == index) {
                running.data = value;
            }
            running = running.next;
            i++;
        }

    }
}

interface CS2ListInterface<T> {

    void add(T value);

    void add(int index, T value);

    void clear();

    boolean contains(T value);

    T get(int index);

    int indexOf(T value);

    boolean isEmpty();

    void removeValue(T value);

    void removeIndex(int index);

    void set(int index, T value);

    int size();

}