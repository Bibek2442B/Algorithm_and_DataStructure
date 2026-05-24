package mylists;

public class DoublyLinkedList <E>{
    private static class Node<E>{
        E data;
        Node<E> next;
        Node<E> prev;
        public Node(E data, Node<E> prev, Node<E> next){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public E getData(){
            return data;
        }
        public Node<E> getNext(){
            return next;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public void setNext(Node<E> next){
            this.next = next;
        }
        public void setPrev(Node<E> prev){
            this.prev = prev;
        }
    }
    private Node<E> header;
    private Node<E> trailer;
    private int size;
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E first(){
        return header.getNext().getData();
    }
    public E last(){
        return trailer.getPrev().getData();
    }
    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }
    public void addLast(E e){
        addBetween(e, trailer, trailer.getPrev());
    }
    public E removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }
    public E removeLast(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }
    private void addBetween(E e, Node<E> prev, Node<E> next){
        Node<E> node = new Node<>(e, prev, next);
        prev.setNext(node);
        next.setPrev(node);
        size++;
    }
    private E remove(Node<E> node){
        Node<E> prev = node.getPrev();
        Node<E> next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return node.getData();
    }


}
