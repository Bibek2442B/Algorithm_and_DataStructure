/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trab_pratico;

import mylists.LinkedSortedListMine;

/**
 * Central class of the AED class management system.
 * Manages student registration and the creation/removal of classes,
 * as well as the distribution of students among the classes.
 *
 * <p>International students ({@link Student_en}) are always placed
 * in class A; the remaining ones ({@link Student_pt}) are distributed
 * evenly among the other classes.</p>
 *
 */
public class AED {

    /** Sorted list of all created classes. */
    private LinkedSortedListMine<Class> classes;

    /** Sorted list of registered students. */
    private LinkedSortedListMine<Student> students;


    /**
     * Constructs an AED system with no classes or registered students.
     */
    public AED() {
        this.classes    = new LinkedSortedListMine<>();
        this.students = new LinkedSortedListMine<>();
    }

    /**
     * Registers a Portuguese student with the given number and name.
     * Registration is rejected if a student with that number already exists.
     *
     * @param num  identifier number of the student.
     * @param name name of the student.
     * @return true if registered successfully; false otherwise.
     */
    public boolean addStudent_pt(int num, String name) {
        boolean ret = students.add(new Student_pt(num, name));
        if(!classes.isEmpty()) this.distributeStudents();
        return ret;
    }

    /**
     * Registers an international student with the given number and name.
     * Registration is rejected if a student with that number already exists.
     *
     * @param num  identifier number of the student.
     * @param name name of the student.
     * @return true if registered successfully; false otherwise.
     */
    public boolean addStudent_en(int num, String name) {
        boolean ret = students.add(new Student_en(num, name));
        if(!classes.isEmpty()) this.distributeStudents();
        return ret;
    }

    /**
     * Creates {@code n} classes (n &gt;= 2), automatically identified by
     * the letters A, B, C, ... and distributes the registered students:
     * <ul>
     *   <li>All international students go to class A.</li>
     *   <li>Portuguese students are distributed evenly
     *       among the remaining classes (B, C, ...) in order of number.</li>
     * </ul>
     * The operation fails if classes have already been created or if { n &lt; 2}.
     *
     * @param n number of classes to create (must be &gt;= 2).
     * @return true if the classes were created successfully; false otherwise.
     */
    public boolean createClasses(int n) {
        if (n < 2 || n<=classes.size()) return false;


        for (int i = 0; i < n; i++) {
            classes.add(new Class((char) ('A' + i)));
        }

        distributeStudents();
        return true;
    }

    /**
     * Removes the last class (the one with the highest letter), provided
     * there are at least three classes. After removal, redistributes all
     * students among the remaining classes.
     *
     * @return true if the removal was performed; false otherwise
     *         (fewer than three classes or no classes at all).
     */
    public boolean removeLastClass() {
        if (classes.size() < 3) return false;
        classes.remove(classes.size() - 1);
        distributeStudents();
        return true;
    }

    /**
     * Displays all classes and their respective students on the screen.
     */
    public void showClasses() {
        if (classes.isEmpty()) {
            System.out.println("There are no classes created.");
            return;
        }
        for (Class c : classes) {
            System.out.println(c);
        }
    }

    /**
     * Distributes the registered students among the existing classes:
     * <ul>
     *   <li>International students -&gt; class A (index 0).</li>
     *   <li>Portuguese students -&gt; distributed in round-robin
     *       among classes B, C, ... (indices 1 ... n-1).</li>
     * </ul>
     */
    private void distributeStudents() {
        for(Class c : classes){
            c.clearStudents();
        }
        int i = 0;
        for(Student student : students){
            if(student instanceof Student_en){
                classes.get(0).addStudent(student);
            }
            else{
                classes.get(1+(i++)%(classes.size()-1)).addStudent(student);
            }
        }
    }
}
