package mylists;

import java.util.Iterator;

/**
 * A sorted list without duplicates, internally backed by a {@link DoublyLinkedList}.
 * Elements are kept in ascending natural order at all times.
 * The internal list is fully encapsulated, therefore no unsorted insertions are possible.
 *
 * @param <E> the type of elements; must be {@link Comparable}.
 */
public class LinkedSortedList<E extends Comparable<E>> implements SortedList<E> {

    /** Internal doubly linked list used as storage. */
    private final DoublyLinkedList<E> list;

    /**
     * Constructs an empty sorted list.
     */
    public LinkedSortedList() {
        list = new DoublyLinkedList<>();
    }

    @Override
    public int size() { return list.size(); }

    @Override
    public boolean isEmpty() { return list.isEmpty(); }

    /**
     * Returns {@code true} if the list contains an element equal to {@code e}.
     *
     * @param e element to search for.
     * @return {@code true} if found; {@code false} otherwise.
     */
    @Override
    public boolean contains(E e) {
        for (E elem : list) {
            int cmp = e.compareTo(elem);
            if (cmp == 0) return true;
            if (cmp < 0)  return false;
        }
        return false;
    }

    /**
     * Returns the element at zero-based position {@code i}, or {@code null}
     * if the index is out of range.
     *
     * @param i zero-based position.
     * @return element at position {@code i}, or {@code null}.
     */
    @Override
    public E get(int i) {
        if (i < 0 || i >= list.size()) return null;
        int idx = 0;
        for (E elem : list) {
            if (idx == i) return elem;
            idx++;
        }
        return null;
    }

    /**
     * Returns the zero-based position of {@code e}, or {@code -1} if absent.
     *
     * @param e element to locate.
     * @return index of {@code e}, or {@code -1}.
     */
    @Override
    public int indexOf(E e) {
        int idx = 0;
        for (E elem : list) {
            int cmp = e.compareTo(elem);
            if (cmp == 0) return idx;
            if (cmp < 0)  return -1; // passed insertion point — not present
            idx++;
        }
        return -1;
    }

    /**
     * Inserts {@code e} in sorted order, provided it is not already present.
     *
     * Strategy (using only the public DLL API):
     * 1. Scan forward to find the first element >= e.
     * 2. If equal, reject (duplicate).
     * 3. Otherwise, temporarily drain all elements from that position
     *    onwards into a helper DLL, append e, then re-append them.
     *
     * @param e element to add.
     * @return {@code true} if inserted; {@code false} if a duplicate was found.
     */
    @Override
    public boolean add(E e) {
        int splitIndex = list.size();
        int idx = 0;
        for (E elem : list) {
            int cmp = e.compareTo(elem);
            if (cmp == 0) return false;
            if (cmp < 0)  { splitIndex = idx; break; }
            idx++;
        }

        int tailCount = list.size() - splitIndex;
        DoublyLinkedList<E> tail = new DoublyLinkedList<>();
        for (int i = 0; i < tailCount; i++) {
            tail.addFirst(list.removeLast());
        }

        list.addLast(e);
        while (!tail.isEmpty()) {
            list.addLast(tail.removeFirst());
        }

        return true;
    }

    /**
     * Removes and returns the element at zero-based position {@code i}.
     * Returns {@code null} if the index is out of range.
     *
     * Strategy: drain elements after position i into a helper DLL,
     * remove the last element of the main list (now at position i),
     * then re-append the saved tail.
     *
     * @param i zero-based position.
     * @return the removed element, or {@code null}.
     */
    @Override
    public E remove(int i) {
        if (i < 0 || i >= list.size()) return null;

        int tailCount = list.size() - 1 - i;
        DoublyLinkedList<E> tail = new DoublyLinkedList<>();
        for (int k = 0; k < tailCount; k++) {
            tail.addFirst(list.removeLast());
        }

        E removed = list.removeLast();

        while (!tail.isEmpty()) {
            list.addLast(tail.removeFirst());
        }

        return removed;
    }

    /**
     * Adds all elements from {@code other} into this list (duplicates ignored).
     *
     * @param other list whose elements are to be added.
     */
    @Override
    public void addAll(SortedList<E> other) {
        for (E e : other) add(e);
    }

    /**
     * Removes from this list every element that is also present in {@code other}.
     *
     * @param other list of elements to remove.
     */
    @Override
    public void removeAll(SortedList<E> other) {
        for (E e : other) {
            int idx = indexOf(e);
            if (idx >= 0) remove(idx);
        }
    }

    /**
     * Returns {@code true} if this list contains every element in {@code other}.
     *
     * @param other list whose elements are checked for membership.
     * @return {@code true} if all elements of {@code other} are present.
     */
    @Override
    public boolean containsAll(SortedList<E> other) {
        for (E e : other) {
            if (!contains(e)) return false;
        }
        return true;
    }

    /**
     * Removes all elements, leaving the list empty.
     */
    @Override
    public void clear() {
        while (!list.isEmpty()) list.removeFirst();
    }


    @Override
    public Iterator<E> iterator() { return list.iterator(); }


    /**
     * Returns a bracketed, comma-separated string of all elements in order.
     *
     * @return string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<E> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns a shallow copy of this list (elements are not cloned).
     *
     * @return a new {@code LinkedSortedList} with the same elements.
     */
    @Override
    public SortedList<E> clone() {
        LinkedSortedList<E> copy = new LinkedSortedList<>();
        for (E e : list) copy.list.addLast(e);
        return copy;
    }

    /**
     * Two sorted lists are equal if they have the same size and identical
     * elements in the same order.
     *
     * @param obj object to compare with.
     * @return {@code true} if both lists are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SortedList)) return false;
        SortedList<?> other = (SortedList<?>) obj;
        if (size() != other.size()) return false;
        Iterator<E>  it1 = iterator();
        Iterator<?>  it2 = other.iterator();
        while (it1.hasNext()) {
            if (!it1.next().equals(it2.next())) return false;
        }
        return true;
    }
}