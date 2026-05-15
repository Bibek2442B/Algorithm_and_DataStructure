public class Main {
    public static void main(String[] args) {
        AED aed = new AED();
        aed.createClasses(2);
        aed.addStudent_en(1, "Bibek");
        aed.addStudent_en(2, "Divya");
        aed.addStudent_pt(3, "Ashish");
        aed.addStudent_pt(4, "Rushmita");
        aed.addStudent_pt(5, "Rushmit");
        aed.addStudent_pt(6, "sfas");
        aed.addStudent_pt(7, "Rusfasfdhmit");
        aed.addStudent_en(7, "Rusfasfdhmit");
        aed.createClasses(4);
        aed.createClasses(5);
        aed.showClasses();
    }
}
