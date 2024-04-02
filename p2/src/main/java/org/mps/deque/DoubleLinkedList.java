/*
 * Realizado por:
 * David Zarzavilla Borrego
 * Pablo Ruiz-Cruces Fernández-Vázquez 
 */
package org.mps.deque;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        LinkedNode<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getItem();
    }

    @Override
    public boolean contains(T value) {
        LinkedNode<T> current = first;
        while (current != null) {
            if (current.getItem().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void remove(T value) {
        LinkedNode<T> current = first;
        while (current != null) {
            if (current.getItem().equals(value)) {
                if (current == first) {
                    deleteFirst();
                } else if (current == last) {
                    deleteLast();
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    size--;
                }
                return;
            }
            current = current.getNext();
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        List<T> list = new ArrayList<>();
        LinkedNode<T> current = first;
        while (current != null) {
            list.add(current.getItem());
            current = current.getNext();
        }
        list.sort(comparator);
        current = first;
        for (T item : list) {
            current.setItem(item);
            current = current.getNext();
        }
    }
}
