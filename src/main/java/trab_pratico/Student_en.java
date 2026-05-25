/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trab_pratico;

/**
 * Represents an international student in the AED system.
 * Inherits from {@link Student} with no additional attributes.
 *
 */
public class Student_en extends Student {

    /**
     * Constructs an international student with the given number and name.
     *
     * @param number student identifier number.
     * @param name   student name.
     */
    public Student_en(int number, String name) {
        super(number, name);
    }

    /**
     * Returns a textual representation of the international student.
     *
     * @return string with the number and name, prefixed with "[EN]".
     */
    @Override
    public String toString() {
        return "[EN] " + super.toString();
    }
}
