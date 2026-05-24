package mylists;

public class SinglyLinkedList<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data,  Node<E> next) {
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
        head = new Node<E>(e,head);
        if(isEmpty()) tail = head;
        size++;
    }
    public void addLast(E e){
        Node<E> node = new Node<E>(e,tail);
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
        return ret;
    }


}
