package mylists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements Iterable<E> {


    private static class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E data,  Node<E> next) {
            this.data = data;
            this.next = next;
        }
        public E getData() {
            return data;
        }
        public Node<E> getNext() {
            return this.next;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size(){
        return size;
    }
    public E first(){
        if(isEmpty())
            return null;
        return head.getData();
    }
    public E last(){
        if(isEmpty())
            return null;
        return tail.getData();
    }
    public void addFirst(E e){
        head = new Node<>(e,head);
        if(isEmpty()) tail = head;
        size++;
    }
    public void addLast(E e){
        Node<E> node = new Node<>(e,null);
        if(isEmpty()) head = node;
        else tail.setNext(node);
        tail = node;
        size++;
    }
    public E removeFirst(){
        if(isEmpty()) return null;
        E ret = head.getData();
        head = head.getNext();
        size--;
        if(isEmpty()) tail = null;
        return ret;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private Node<E> cur;
        public MyIterator() {
            cur = head;
        }
        @Override
        public boolean hasNext() {
            return cur != null;
        }
        @Override
        public E next() {
            if(cur == null) throw new NoSuchElementException("No next element");
            E ret = cur.getData();
            cur = cur.getNext();
            return ret;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}