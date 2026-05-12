package mylists;

import java.util.Iterator;

public class LinkedSortedList<E extends Comparable<E>> implements SortedList<E>{

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = iterator();

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public E get(int i) {
        return null;
    }

    @Override
    public E remove(int i) {
        return null;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public void addAll(SortedList<E> other) {

    }

    @Override
    public void removeAll(SortedList<E> other) {

    }

    @Override
    public boolean containsAll(SortedList<E> other) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public SortedList<E> clone() {
        return null;
    }
}
