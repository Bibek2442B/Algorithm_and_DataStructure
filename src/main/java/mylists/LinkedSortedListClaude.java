package mylists;

import java.util.Iterator;

/**
 * A sorted list implementation based on {@link DoublyLinkedList}.
 * Elements are kept in ascending natural order at all times.
 * Duplicate elements are not allowed.
 *
 * @param <E> the type of elements; must be {@link Comparable}.
 * @author anonymous
 */
public class LinkedSortedListClaude<E extends Comparable<E>>
        extends DoublyLinkedList<E>
        implements SortedList<E> {

    /**
     * Constructs an empty sorted list.
     */
    public LinkedSortedListClaude() {
        super();
    }

    // ------------------------------------------------------------------
    // SortedList — query methods
    // ------------------------------------------------------------------

    /**
     * Returns {@code true} if the list contains an element equal to {@code e}.
     *
     * @param e element to search for.
     * @return {@code true} if found; {@code false} otherwise.
     */
    @Override
    public boolean contains(E e) {
        Node<E> cur = header.getNext();
        while (cur != trailer) {
            int cmp = e.compareTo(cur.getData());
            if (cmp == 0) return true;
            if (cmp < 0)  return false; // passed insertion point
            cur = cur.getNext();
        }
        return false;
    }

    /**
     * Returns the element at position {@code i} (0-based), or {@code null}
     * if the index is out of range.
     *
     * @param i zero-based position.
     * @return the element at position {@code i}, or {@code null}.
     */
    @Override
    public E get(int i) {
        if (i < 0 || i >= size()) return null;
        Node<E> cur = header.getNext();
        for (int k = 0; k < i; k++) cur = cur.getNext();
        return cur.getData();
    }

    /**
     * Returns the position of {@code e} in the list, or {@code -1} if absent.
     *
     * @param e element to locate.
     * @return zero-based index, or {@code -1} if not found.
     */
    @Override
    public int indexOf(E e) {
        Node<E> cur = header.getNext();
        int idx = 0;
        while (cur != trailer) {
            int cmp = e.compareTo(cur.getData());
            if (cmp == 0) return idx;
            if (cmp < 0)  return -1;
            cur = cur.getNext();
            idx++;
        }
        return -1;
    }

    // ------------------------------------------------------------------
    // SortedList — mutation methods
    // ------------------------------------------------------------------

    /**
     * Inserts {@code e} in the correct sorted position, provided it is not
     * already present in the list.
     *
     * @param e element to add.
     * @return {@code true} if inserted; {@code false} if a duplicate was found.
     */
    @Override
    public boolean add(E e) {
        Node<E> cur = header.getNext();
        while (cur != trailer) {
            int cmp = e.compareTo(cur.getData());
            if (cmp == 0) return false;  // duplicate — reject
            if (cmp < 0) {
                // insert before cur
                addBetween(e, cur.getPrev(), cur);
                return true;
            }
            cur = cur.getNext();
        }
        // e is greater than all existing elements — append before trailer
        addBetween(e, trailer.getPrev(), trailer);
        return true;
    }

    /**
     * Removes and returns the element at position {@code i} (0-based).
     * Returns {@code null} if the index is out of range.
     *
     * @param i zero-based position.
     * @return the removed element, or {@code null}.
     */
    @Override
    public E remove(int i) {
        if (i < 0 || i >= size()) return null;
        Node<E> cur = header.getNext();
        for (int k = 0; k < i; k++) cur = cur.getNext();
        return remove(cur);
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
     * @param other list to check for containment.
     * @return {@code true} if all elements are present.
     */
    @Override
    public boolean containsAll(SortedList<E> other) {
        for (E e : other) {
            if (!contains(e)) return false;
        }
        return true;
    }

    /**
     * Removes all elements from the list, leaving it empty.
     */
    @Override
    public void clear() {
        while (!isEmpty()) removeFirst();
    }

    // ------------------------------------------------------------------
    // SortedList — Object methods
    // ------------------------------------------------------------------

    /**
     * Returns a string listing all elements in sorted order.
     *
     * @return bracketed, comma-separated list of elements.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> cur = header.getNext();
        while (cur != trailer) {
            sb.append(cur.getData());
            if (cur.getNext() != trailer) sb.append(", ");
            cur = cur.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns a shallow copy of this list (elements themselves are not cloned).
     *
     * @return a new {@code LinkedSortedList} containing the same elements.
     */
    @Override
    public SortedList<E> clone() {
        LinkedSortedList<E> copy = new LinkedSortedList<>();
        Node<E> cur = header.getNext();
        while (cur != trailer) {
            copy.addBetween(cur.getData(), copy.trailer.getPrev(), copy.trailer);
            cur = cur.getNext();
        }
        return copy;
    }

    /**
     * Two sorted lists are equal if they contain the same elements in the
     * same order.
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
        Iterator<E> it1 = iterator();
        Iterator<?> it2 = other.iterator();
        while (it1.hasNext()) {
            if (!it1.next().equals(it2.next())) return false;
        }
        return true;
    }
}