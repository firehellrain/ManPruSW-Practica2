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
        if (first != null) {
            LinkedNode<T> newNode = new LinkedNode<T>(value, null, first);
            this.first.setPrevious(newNode);
            this.first = newNode;
        } else {
            this.first = new LinkedNode<T>(value, null, null);
            this.last = this.first; // He añadido esto
        }

        this.size++;
    }

    @Override
    public void append(T value) {
        if (last != null) {
            LinkedNode<T> newNode = new LinkedNode<T>(value, last, null);
            this.last.setNext(newNode);
            this.last = newNode;
        } else if (first != null) {
            this.last = new LinkedNode<T>(value, first, null);
            this.first.setNext(last); // He añadido esto
        } else {
            this.first = new LinkedNode<T>(value, null, null);
            this.last = this.first; // He añadido esto
        }

        this.size++;
    }

    @Override
    public void deleteFirst() {
        if (first.getNext() != null) {
            LinkedNode<T> tempNode = this.first.getNext();
            this.first = tempNode;
            this.first.setPrevious(null);
        } else {
            this.first = null;
            this.last = null; // He añadido esto
        }

        this.size--;
    }

    @Override
    public void deleteLast() {
        if (this.size > 1) {
            LinkedNode<T> tempNode = this.last.getPrevious();
            this.last = tempNode;
            this.last.setNext(null);
        } else {
            this.first = null;
            this.last = null;
        }

        this.size--;
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
