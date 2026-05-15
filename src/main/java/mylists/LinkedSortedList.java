package mylists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedSortedList<E extends Comparable<E>> implements SortedList<E>{
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E element,  Node<E> next) {
            this.element = element;
            this.next = next;
        }
        public E getElement() {
            return this.element;
        }
        public Node<E> getNext() {
            return this.next;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    private Node<E> head;
    private int size;
    public LinkedSortedList() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E element = current.getElement();
                current = current.getNext();
                return element;
            }
        };
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

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
        Node<E> current = head;
        while(current!=null){
            int  cmp = e.compareTo(current.getElement());
            if(cmp == 0) return false;
            if(cmp < 0) break;
            prev = current;
            current = current.getNext();
        }
        Node<E> node = new Node<>(e,current);
        if(prev == null) head = node;
        else prev.setNext(node);
        size++;
        return true;
    }

    @Override
    public E get(int i) {
        if(i<0 || i>=size()) throw new IndexOutOfBoundsException();
        Node<E> node = head;
        for(int j=0;j<i;j++) node = node.getNext();
        return node.getElement();
    }

    @Override
    public E remove(int i) {
        if(i<0 || i>=size()) throw new IndexOutOfBoundsException();
        Node<E> prev = null;
        Node<E> current = head;
        for(int j=0;j<i;j++){
            prev = current;
            current = current.getNext();
        }
        if(prev == null) {
            head = current.getNext();
        }
        else prev.setNext(current.getNext());
        size--;
        return current.getElement();
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
        for(E element : other){
            this.add(element);
        }
    }

    @Override
    public void removeAll(SortedList<E> other) {
        for(E element : other){
            int index = this.indexOf(element);
            if(index != -1) this.remove(index);
        }
    }

    @Override
    public boolean containsAll(SortedList<E> other) {
        for(E element : other){
            if(!this.contains(element)) return false;
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public SortedList<E> clone() {
        LinkedSortedList<E> list = new LinkedSortedList<>();
        Node<E> listTail = null;
        for(Node<E> node = head; node != null; node = node.getNext()){
            Node<E> newNode = new Node<>(node.getElement(), null);
            if(listTail == null) list.head = newNode;
            else listTail.setNext(newNode);
            listTail = newNode;
            list.size++;
        }
        return list;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(Node<E> node = head; node != null; node = node.getNext()){
            sb.append(node.getElement());
            if(node.getNext() != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || !(obj instanceof SortedList)) return false;
        SortedList<?> list = (SortedList<?>) obj;
        if(this.size != list.size()) return false;
        Iterator<E> iterator = this.iterator();
        Iterator<?> otherIterator = list.iterator();
        while(iterator.hasNext()){
            if(!iterator.next().equals(otherIterator.next())) return false;
        }
        return true;
    }
}
