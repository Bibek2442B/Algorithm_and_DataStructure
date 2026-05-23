package mylists;

import mylists.SortedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedSortedList<E extends Comparable<E>> implements SortedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    }

    private Node<E> head;
    private int size;

    public LinkedSortedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public boolean contains(E e) {
        for(Node<E> node = head; node != null; node = node.getNext()){
            int cmp = e.compareTo(node.getElement());
            if(cmp == 0) return true;
            if(cmp < 0) return false;
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        Node<E> prev = null;
        Node<E> cur = head;

        while (cur != null) {
            int cmp = e.compareTo(cur.getElement());
            if (cmp == 0) return false;
            if (cmp < 0) break;
            prev = cur;
            cur = cur.getNext();
        }
        Node<E> newNode = new Node<>(e, cur);
        if (prev == null) head = newNode;
        else prev.setNext(newNode);
        size++;
        return true;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        Node<E> cur = head;
        for (int k = 0; k < i; k++) cur = cur.getNext();
        return cur.getElement();
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i >= size) return null;
        Node<E> prev = null;
        Node<E> cur = head;
        for (int k = 0; k < i; k++) {
            prev = cur;
            cur = cur.getNext();
        }
        if (prev == null) {
            head = cur.getNext();
        } else {
            prev.setNext(cur.getNext());
        }
        size--;
        return cur.getElement();
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        for(Node<E> node = head; node != null; node = node.getNext()){
            int cmp = e.compareTo(node.getElement());
            if(cmp == 0) return index;
            if(cmp < 0) return -1;
            index++;
        }
        return -1;
    }

    @Override
    public void addAll(SortedList<E> other) {
        for (E e : other) add(e);
    }

    @Override
    public void removeAll(SortedList<E> other) {
        for (E e : other) {
            int idx = indexOf(e);
            if (idx >= 0) remove(idx);
        }
    }

    @Override
    public boolean containsAll(SortedList<E> other) {
        for (E e : other) {
            if (!contains(e)) return false;
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> cur = head;
        while (cur != null) {
            sb.append(cur.getElement());
            if (cur.getNext() != null) sb.append(", ");
            cur = cur.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public SortedList<E> clone() {
        LinkedSortedList<E> copy = new LinkedSortedList<>();
        Node<E> cur = head;
        Node<E> copyTail = null;
        while (cur != null) {
            Node<E> newNode = new Node<>(cur.getElement(), null);
            if (copyTail == null) {
                copy.head = newNode;
            } else {
                copyTail.setNext(newNode);
            }
            copyTail = newNode;
            copy.size++;
            cur = cur.getNext();
        }
        return copy;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SortedList)) return false;
        SortedList<?> other = (SortedList<?>) obj;
        if (size != other.size()) return false;
        Iterator<E> it1 = iterator();
        Iterator<?> it2 = other.iterator();
        while (it1.hasNext()) {
            if (!it1.next().equals(it2.next())) return false;
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> cur = head;

            @Override
            public boolean hasNext() { return cur != null; }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E val = cur.getElement();
                cur = cur.getNext();
                return val;
            }
        };
    }

}