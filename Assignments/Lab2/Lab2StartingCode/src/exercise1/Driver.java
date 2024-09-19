package exercise1;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {

    public static void main(String[] args) {
        ArrayList<Student> studs = new ArrayList<>();
        studs.add(new Student("Smith", 34));
        studs.add(new Student("Johnson", 21));
        studs.add(new Student("Williams", 67));
        studs.add(new Student("Brown", 53));
        studs.add(new Student("Jones", 48));
        studs.add(new Student("Miller", 36));
        studs.add(new Student("Davis", 44));
        studs.add(new Student("Wilson", 52));
        studs.add(new Student("Anderson", 34));
        studs.add(new Student("Moore", 33));

        System.out.println("Before sorting:");
        for (Student s : studs) {
            System.out.println(s);
        }

        Collections.sort(studs);
        System.out.println("\nAfter sorting (name) (Comparable):");
        for (Student s : studs) {
            System.out.println(s);
        }

        Collections.sort(studs, new AgeComparator());
        System.out.println("\nAfter sorting (age) (Comparator):");
        for (Student s : studs) {
            System.out.println(s);
        }
    }
}
