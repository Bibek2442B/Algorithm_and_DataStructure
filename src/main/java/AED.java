import mylists.LinkedSortedList;
import mylists.SortedList;

import java.util.LinkedList;

public class AED {
    private LinkedSortedList<Class> classes;
    private LinkedSortedList<Student> students;

    public AED(){
        this.classes = new LinkedSortedList<>();
        this.students = new LinkedSortedList<>();
    }
    boolean addStudent_pt(int num, String name){
        boolean retValue =  students.add(new Student_pt(num, name));
        if(!classes.isEmpty()) this.distributeStudents();
        return retValue;
    }
    boolean addStudent_en(int num, String name){
        boolean retValue = students.add(new Student_en(num, name));
        if(!classes.isEmpty()) this.distributeStudents();
        return retValue;
    }
    boolean createClasses(int n){
        if(n<2) return false;
        for(int i = 0; i < n; i++){
            classes.add(new Class((char) ('A'+ i)));
        }
        this.distributeStudents();
        return true;
    }
    boolean removeLastClass(){
        if(classes.size() < 3) return false;
        classes.remove(classes.size()-1);
        distributeStudents();
        return true;
    }
    void showClasses(){
        for(Class c : classes){
            System.out.println(c);
        }
    }
    private void distributeStudents(){
        for(Class c : classes){
            c.clear();
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
