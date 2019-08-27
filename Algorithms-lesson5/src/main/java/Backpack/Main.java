package Backpack;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        ArrayList<Subject> subjects = new ArrayList<Subject>();

        subjects.add(new Subject("Book", 7, 15.50));
        subjects.add(new Subject("Pen", 1, 1.30));
        subjects.add(new Subject("Workbook", 5, 20.90));
        subjects.add(new Subject("Pencil", 2, 3.50));
        subjects.add(new Subject("Phone", 12, 55.50));

        Backpack backpack = new Backpack(20);

        System.out.println(backpack.getSubjectSet(subjects));
    }
}
