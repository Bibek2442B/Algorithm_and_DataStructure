public class Student_pt extends Student {
    public Student_pt(int number, String name) {
        super(number, name);
    }
    @Override
    public String toString(){
        return "[PT] " +  super.toString() + "\n";
    }
}
