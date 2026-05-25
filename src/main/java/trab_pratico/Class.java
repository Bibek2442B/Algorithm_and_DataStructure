/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trab_pratico;

import mylists.LinkedSortedListMine;
import mylists.SortedList;

/**
 * Represents a class in the AED system.
 * Each class is identified by a letter (A, B, C, ...) and contains
 * a sorted list of students without repetitions.
 *
 */
public class Class implements Comparable<Class> {

    /** Class identifier (letter of the alphabet). */
    private char id;

    /** Sorted list of students in the class. */
    private LinkedSortedListMine<Student> students;

    /**
     * Constructs a class with the given identifier.
     *
     * @param id letter that identifies the class (e.g.: 'A', 'B', ...).
     */
    public Class(char id) {
        this.id = id;
        this.students = new LinkedSortedListMine<>();
    }

    /**
     * Returns the class identifier.
     *
     * @return letter identifying the class.
     */
    public char getId() { return id; }

    /**
     * Returns the list of students in the class.
     *
     * @return sorted list of students.
     */
    public SortedList<Student> getStudents() { return students; }

    /**
     * Adds a student to the class, if not already enrolled.
     *
     * @param s student to add.
     * @return true if added; false if already existed.
     */
    public boolean addStudent(Student s) {
        return students.add(s);
    }

    /**
     * Removes all students from the class.
     */
    public void clearStudents() {
        students.clear();
    }

    /**
     * Returns the number of students in the class.
     *
     * @return number of students.
     */
    public int numStudents() { return students.size(); }

    /**
     * Compares this class with another based on the identifier.
     *
     * @param other another class.
     * @return negative, zero, or positive value depending on whether this
     *         class's letter is less than, equal to, or greater than the other's.
     */
    @Override
    public int compareTo(Class other) {
        return Character.compare(this.id, other.id);
    }

    /**
     * Two classes are equal if they have the same identifier.
     *
     * @param obj object to compare.
     * @return true if the identifiers are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Class)) return false;
        Class other = (Class) obj;
        return this.id == other.id;
    }

    /**
     * Returns a textual representation of the class with its students.
     *
     * @return string with the class identifier and its students.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Class " + id + ":\n");
        if (students.isEmpty()) {
            sb.append("  (no students)\n");
        } else {
            for (Student s : students) {
                sb.append("  ").append(s).append("\n");
            }
        }
        return sb.toString();
    }
}
