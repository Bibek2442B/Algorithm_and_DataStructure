public class Student_en extends Student {
    public Student_en(int number, String name) {
        super(number, name);
    }
    @Override
    public String toString(){
        return "[EN] " +  super.toString()+ "\n";
    }
}
