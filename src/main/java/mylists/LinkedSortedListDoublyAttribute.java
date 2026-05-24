package mylists;

import java.util.Iterator;

public class LinkedSortedListDoublyAttribute <E extends Comparable<E>> extends DoublyLinkedList<E> implements SortedList<E>{
    public LinkedSortedListDoublyAttribute() {
        super();
    }
    @Override
    public Iterator<E> iterator() {
        return this.iterator();
    }

    @Override
    public int size() {
        return this.size();
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        for(E elem: this) if(elem.compareTo(e)==0) return true;
        return false;
    }

    @Override
    public boolean add(E e) {
        Node<E> node = this.header.getNext();
        for(E elem: this){
            int compare = e.compareTo(elem);
            if(compare == 0) return false;
            if(compare<0) break;
            node = node.getNext();
        }
        this.addBetween(e, node.getPrev(), node);
        return true;
    }

    @Override
    public E get(int i) {
        if(i<0 || i>=size()) throw new IndexOutOfBoundsException();
        Iterator<E> iterator = this.iterator();
        for(int j=0;j<i;j++){
            iterator.next();
        }
        return iterator.next();
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
