import mylists.LinkedSortedList;

public class Class implements Comparable<Class>{
    private char turno;
    private LinkedSortedList<Student> students;
    public Class(char turno) {
        this.turno = turno;
        this.students = new LinkedSortedList<>();
    }
    @Override
    public int compareTo(Class o) {
        return Integer.compare(this.turno, o.turno);
    }
    public boolean addStudent(Student student){
        return students.add(student);
    }
    public void clear(){
        students.clear();
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("Class " + turno + ":\n\tStudents: \n");
        for(Student student : students){
            s.append("\t\t").append(student.toString());
        }
        return s.toString();
    }
}
