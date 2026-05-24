package mylists;

import java.util.Iterator;

public class LinkedSortedListSinglyAttribute<E extends Comparable<E>> implements SortedList<E>  {
    private final SinglyLinkedList<E> list;
    public LinkedSortedListSinglyAttribute(){
        list = new SinglyLinkedList<>();
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        for(E element: list){
            if(element.compareTo(e) == 0) return true;
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        for(E element: list){
            if(element.compareTo(e) == 0) break;
        }
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
