package org.mps.deque;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void prepend(T value) {
        LinkedNode<T> newNode = new LinkedNode<T>(value, null, first);
        if (first != null) {
            first.setPrevious(newNode);
        } else {
            last = newNode; // Si es el primer elemento, last también apunta a él
        }
        first = newNode;
        size++;
    }

    @Override
    public void append(T value) {
        LinkedNode<T> newNode = new LinkedNode<T>(value, last, null);
        if (last != null) {
            last.setNext(newNode);
        } else {
            first = newNode; // Si es el primer elemento, first también apunta a él
        }
        last = newNode;
        size++;
    }

    @Override
    public void deleteFirst() {
        if (size == 0) {
            throw new DoubleLinkedQueueException("Deque is empty");
        }
        if (first.getNext() != null) {
            first = first.getNext();
            first.setPrevious(null);
        } else {
            first = null;
            last = null;
        }
        size--;
    }

    @Override
    public void deleteLast() {
        if (size == 0) {
            throw new DoubleLinkedQueueException("Deque is empty");
        }
        if (size > 1) {
            last = last.getPrevious();
            last.setNext(null);
        } else {
            first = null;
            last = null;
        }
        size--;
    }

    @Override
    public T first() {
        // Añadido excepciones
        if (size == 0) {
            throw new DoubleLinkedQueueException("Deque is empty");
        }
        return this.first.getItem();
    }

    @Override
    public T last() {
        // Añadido excepciones
        if (size == 0) {
            throw new DoubleLinkedQueueException("Deque is empty");
        }
        return this.last.getItem();
    }

    @Override
    public int size() {
        return this.size;
    }
}
