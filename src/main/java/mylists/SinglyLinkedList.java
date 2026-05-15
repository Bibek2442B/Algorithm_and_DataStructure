package mylists;

public class SinglyLinkedList {
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

}
