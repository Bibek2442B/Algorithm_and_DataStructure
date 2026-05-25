///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/trab_pratico.Class.java to edit this template
// */
//package mylists;
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
///**
// * Implementation of a sorted list without repetitions based on a doubly linked list.
// * Elements are kept in ascending order according to their natural ordering.
// *
// *
// * @param <E> type of element to be collected; must be comparable.
// */
//public class LinkedSortedListMine<E extends Comparable<E>> extends DoublyLinkedList<E> implements SortedList<E>{
//    public LinkedSortedListMine() {
//        super();
//    }
//
//    @Override
//    public int size() {
//        return super.size();
//    }
//    @Override
//    public boolean isEmpty() {
//        return super.isEmpty();
//    }
//    @Override
//    public Iterator<E> iterator(){
//        return super.iterator();
//    }
//    @Override
//    public boolean contains(E e) {
//        for(E elem: this) if(elem.compareTo(e)==0) return true;
//        return false;
//    }
//
//    @Override
//    public boolean add(E e) {
//        Node<E> node = this.header.getNext();
//        for(E elem: this){
//            int compare = e.compareTo(elem);
//            if(compare == 0) return false;
//            if(compare<0) break;
//            node = node.getNext();
//        }
//        this.addBetween(e, node.getPrev(), node);
//        return true;
//    }
//
//    @Override
//    public E get(int i) {
//        if(i<0 || i>=size()) throw new IndexOutOfBoundsException();
//        Iterator<E> iterator = this.iterator();
//        for(int j=0;j<i;j++){
//            iterator.next();
//        }
//        return iterator.next();
//    }
//
//    @Override
//    public E remove(int i) {
//        if(i<0 || i>=size()) throw new IndexOutOfBoundsException();
//        Node<E> node = this.header.getNext();
//        for(int j=0;j<i;j++){
//            node = node.getNext();
//        }
//        E deleted = node.getData();
//        this.remove(node);
//        return deleted;
//    }
//
//    @Override
//    public int indexOf(E e) {
//        int i=0;
//        for(E elem: this){
//            int compare = e.compareTo(elem);
//            if(compare==0) return i;
//            if(compare<0) break;
//            i++;
//        }
//        throw new NoSuchElementException();
//    }
//
//    @Override
//    public void addAll(SortedList<E> other) {
//        for(E elem: other) this.add(elem);
//    }
//
//    @Override
//    public void removeAll(SortedList<E> other) {
//        for(E elem: other){
//            int idx = this.indexOf(elem);
//            if(idx!=-1) this.remove(idx);
//        }
//    }
//
//    @Override
//    public boolean containsAll(SortedList<E> other) {
//        if(other.isEmpty()) return true;
//        for(E elem: other) if(!this.contains(elem)) return false;
//        return true;
//
//    }
//
//    @Override
//    public void clear() {
//        this.removeAll(this);
//    }
//
//    @Override
//    public SortedList<E> clone() {
//        LinkedSortedListMine<E> copy = new LinkedSortedListMine<>();
//        for(E elem: this) copy.add(elem);
//        return copy;
//    }
//    @Override
//    public E first() {
//        throw new UnsupportedOperationException("Method not implemented!");
//    }
//    @Override
//    public E last() {
//        throw new UnsupportedOperationException("Method not implemented!");
//    }
//    @Override
//    public void addFirst(E e) {
//        throw new UnsupportedOperationException("Method not implemented!");
//    }
//    @Override
//    public void addLast(E e) {
//        throw new UnsupportedOperationException("Method not implemented!");
//    }
//    @Override
//    public E removeFirst() {
//        throw new UnsupportedOperationException("Method not implemented!");
//    }
//    @Override
//    public E removeLast() {
//        throw new UnsupportedOperationException("Method not implemented!");
//    }
//
//}
//
