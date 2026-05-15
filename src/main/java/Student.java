public abstract class Student implements Comparable<Student>{
    private int number;
    private String name;
    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int compareTo(Student student) {
        return Integer.compare(this.number, student.number);
    }
    @Override
    public String toString() {
        return number + " - " + name;
    }

}
