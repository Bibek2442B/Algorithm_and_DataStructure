package mylists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedSinglyLinkedList<E extends Comparable<E>> extends SinglyLinkedList<E>implements SortedList<E>{
    public SortedSinglyLinkedList(){
        super();
    }
    @Override
    public E removeFirst(){
        throw new UnsupportedOperationException("Method not implemented");
    }
    @Override
    public void addFirst(E e){
        throw new UnsupportedOperationException("Method not implemented");
    }
    @Override
    public void addLast(E e){
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> node = head;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                if(!hasNext()) throw new NoSuchElementException();
                E element = node.getData();
                node = node.next;
                return element;
            }
        };
    }

    @Override
    public boolean contains(E e) {
        for(Node<E> node = head; node != null; node = node.getNext()){
            int cmp = node.getData().compareTo(e);
            if(cmp == 0) return true;
            if(cmp < 0) return false;
        }
        return false;
    }
    @Override
    public boolean add(E e){
//        Node<E> data = new Node<>(e, null);
//        Node<E> prev = null;
//        Node<E> cur = head;
//        while(cur != null){
//            if(cur.getData().compareTo(e) <0) break;
//            prev = cur;
//            cur = cur.getNext();
//        }
//        if(prev == null){
//            tail = data;
//        }
        return true;
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
