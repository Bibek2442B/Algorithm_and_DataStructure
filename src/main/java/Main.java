public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  Test of the AED Class Management Application");
        System.out.println("=================================================\n");

        AED aed = new AED();

        System.out.println("--- Student registration ---");

        System.out.println("addStudent_pt(1001, \"Ana Silva\")     -> " + aed.addStudent_pt(1001, "Ana Silva"));
        System.out.println("addStudent_pt(1002, \"Bruno Costa\")   -> " + aed.addStudent_pt(1002, "Bruno Costa"));
        System.out.println("addStudent_pt(1003, \"Carla Martins\") -> " + aed.addStudent_pt(1003, "Carla Martins"));
        System.out.println("addStudent_pt(1004, \"David Sousa\")   -> " + aed.addStudent_pt(1004, "David Sousa"));
        System.out.println("addStudent_pt(1005, \"Eva Ferreira\")  -> " + aed.addStudent_pt(1005, "Eva Ferreira"));
        System.out.println("addStudent_pt(1006, \"Filipe Neves\")  -> " + aed.addStudent_pt(1006, "Filipe Neves"));

        System.out.println("addStudent_pt(1001, \"Duplicate\")     -> " + aed.addStudent_pt(1001, "Duplicate") + "  (expected: false)");

        System.out.println();

        System.out.println("addStudent_en(2001, \"Alice Brown\")   -> " + aed.addStudent_en(2001, "Alice Brown"));
        System.out.println("addStudent_en(2002, \"Bob Johnson\")   -> " + aed.addStudent_en(2002, "Bob Johnson"));
        System.out.println("addStudent_en(2003, \"Clara White\")   -> " + aed.addStudent_en(2003, "Clara White"));

        System.out.println("addStudent_en(2001, \"Duplicate\")     -> " + aed.addStudent_en(2001, "Duplicate") + "  (expected: false)");

        System.out.println();

        System.out.println("--- Class creation (n=3) ---");
        System.out.println("createClasses(1) -> " + aed.createClasses(1) + "  (expected: false, n<2)");
        System.out.println("createClasses(3) -> " + aed.createClasses(3));
        System.out.println("createClasses(3) -> " + aed.createClasses(3) + "  (expected: false, classes already exist)");
        System.out.println();

        System.out.println("--- Classes after creation ---");
        aed.showClasses();

        System.out.println("--- Removal of the last class (3 classes -> 2 classes) ---");
        System.out.println("removeLastClass() -> " + aed.removeLastClass());
        System.out.println();

        System.out.println("--- Classes after removal (2 classes) ---");
        aed.showClasses();

        System.out.println("--- Attempt to remove with only 2 classes ---");
        System.out.println("removeLastClass() -> " + aed.removeLastClass() + "  (expected: false)");
        System.out.println();

        System.out.println("=================================================");
        System.out.println("  New system: 4 classes, more students");
        System.out.println("=================================================\n");

        AED aed2 = new AED();

        aed2.addStudent_pt(3001, "Goncalo Alves");
        aed2.addStudent_pt(3002, "Helena Dias");
        aed2.addStudent_pt(3003, "Ivo Rodrigues");
        aed2.addStudent_pt(3004, "Joana Pires");
        aed2.addStudent_pt(3005, "Kevin Lopes");
        aed2.addStudent_pt(3006, "Luisa Santos");
        aed2.addStudent_pt(3007, "Miguel Teixeira");
        aed2.addStudent_pt(3008, "Nuno Cardoso");

        aed2.addStudent_en(4001, "Oliver Smith");
        aed2.addStudent_en(4002, "Paula Garcia");

        System.out.println("createClasses(4) -> " + aed2.createClasses(4));
        System.out.println();
        System.out.println("--- Classes after creation (4 classes) ---");
        aed2.showClasses();

        System.out.println("--- Removal of the last class (4 -> 3) ---");
        System.out.println("removeLastClass() -> " + aed2.removeLastClass());
        System.out.println();
        System.out.println("--- Classes after removal ---");
        aed2.showClasses();

        System.out.println("--- Second removal (3 -> 2) ---");
        System.out.println("removeLastClass() -> " + aed2.removeLastClass());
        System.out.println();
        System.out.println("--- Classes after second removal ---");
        aed2.showClasses();
    }
}
