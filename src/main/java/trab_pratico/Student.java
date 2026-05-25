/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trab_pratico;

/**
 * Represents a generic student in the AED system.
 * Each student has an identifier number and a name.
 * Students are ordered by their student number.
 *
 */
public abstract class Student implements Comparable<Student> {

    /** Student identifier number. */
    private int number;

    /** Student name. */
    private String name;

    /**
     * Constructs a student with the given number and name.
     *
     * @param number student identifier number.
     * @param name   student name.
     */
    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }

    /**
     * Returns the student identifier number.
     *
     * @return student number.
     */
    public int getNumber() { return number; }

    /**
     * Returns the student name.
     *
     * @return student name.
     */
    public String getName() { return name; }

    /**
     * Compares this student with another based on the identifier number.
     *
     * @param other another student to compare with.
     * @return negative, zero, or positive value depending on whether this
     *         student has a number less than, equal to, or greater than the other.
     */
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.number, other.number);
    }

    /**
     * Two students are equal if they have the same identifier number.
     *
     * @param obj object to compare.
     * @return true if the students have the same number.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return this.number == other.number;
    }

    /**
     * Returns a textual representation of the student.
     *
     * @return string with the student number and name.
     */
    @Override
    public String toString() {
        return number + " - " + name;
    }
}
