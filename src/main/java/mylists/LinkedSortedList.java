package mylists;

import java.util.Iterator;

public class LinkedSortedList<E extends Comparable<E>> implements SortedList<E> {

    private final DoublyLinkedList<E> list;

    public LinkedSortedList() {
        list = new DoublyLinkedList<>();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        for (E elem : list) {
            int cmp = e.compareTo(elem);
            if (cmp == 0) return true;
            if (cmp < 0)  return false;
        }
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
